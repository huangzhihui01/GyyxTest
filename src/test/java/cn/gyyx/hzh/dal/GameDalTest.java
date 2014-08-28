package cn.gyyx.hzh.dal;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cn.gyyx.hzh.model.GameInfo;
import cn.gyyx.hzh.dal.GameDal;

public class GameDalTest {
	GameDal gameDal = new GameDal();

	@Test
	public void queryListTest() {
		assertNotNull(gameDal.queryList());
	}

	@Test
	public void queryByIdTest() {
		assertNotNull(gameDal.queryById(1));
	}

	@Test
	public void TestInsert() {
		GameInfo info = new GameInfo();
		info.setGameName("²âÊÔÓÎÏ·");
		int result = gameDal.insert(info);
		assertTrue(result > 0);
	}

	@Test
	public void TestUpdate() {
		GameInfo info = gameDal.queryById(1);
		info.setGameName("ÆßÉ±Ñ½");
		int result = gameDal.update(info);
		assertTrue(result > 0);
	}

	@Test
	public void TestGet() {
		GameInfo info = gameDal.queryById(1);
		assertNotNull(info);
	}

}
