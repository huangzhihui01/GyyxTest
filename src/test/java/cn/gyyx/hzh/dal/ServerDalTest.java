package cn.gyyx.hzh.dal;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import cn.gyyx.hzh.model.ServerInfo;
import cn.gyyx.hzh.dal.ServerDal;

public class ServerDalTest {
	ServerDal serverDal = new ServerDal();

	@Test
	public void queryListByGameIdTest() {
		List<ServerInfo> list = serverDal.queryListByGameId(1);
		assertNotNull(list);
	}

}
