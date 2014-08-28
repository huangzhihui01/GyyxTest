package cn.gyyx.hzh;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import cn.gyyx.hzh.model.GameInfo;
import cn.gyyx.hzh.loginmemch.GameLogin;

public class GameLoginTest {
	GameLogin gameLogin = new GameLogin();

	@Test
	public void queryListTest() {
		assertNotNull(gameLogin.queryList());
	}

	@Test
	public void queryByIdTest() {
		assertNotNull(gameLogin.queryById(1));
	}

	@Test
	public void insert() {
		GameInfo info = new GameInfo();
		info.setGameName("Junit test");
		assertTrue(gameLogin.insert(info) > 0);
	}

	@Test
	public void update() {
		GameInfo info = gameLogin.queryById(1);
		info.setGameName("Junit test");
		assertTrue(gameLogin.update(info) > 0);
	}

}
