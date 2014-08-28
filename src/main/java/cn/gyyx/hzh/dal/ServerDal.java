package cn.gyyx.hzh.dal;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import cn.gyyx.hzh.model.ServerInfo;

public class ServerDal extends BaseDal {
	private SqlSession session = null;

	public List<ServerInfo> queryListByGameId(int gameId) {
		String smtpId = "ServerInfo.queryListByGameId";
		List<ServerInfo> list = null;
		try {
			session = sessionFactory.openSession();
			list = session.selectList(smtpId, gameId);
			session.close();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}
		return list;
	}

}
