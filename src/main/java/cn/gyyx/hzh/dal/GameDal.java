package cn.gyyx.hzh.dal;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import cn.gyyx.hzh.model.GameInfo;
public class GameDal extends BaseDal {
	private SqlSession session= null;
	
	
	public List<GameInfo> queryList()
	{
		String Id ="GameInfo.queryList";
		List<GameInfo> list= null;
		try{
			session = sessionFactory.openSession();
			list=session.selectList(Id,null);
		} catch(Exception e)
		{
			session.rollback();
			e.printStackTrace();
			
		}
		return list;
	}
	
	public GameInfo queryById(int gameId) {
		GameInfo info = null;
		String smtpId = "GameInfo.queryById";
		try {
			session = sessionFactory.openSession();
			info = session.selectOne(smtpId, gameId);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return info;
	}

	public int update(GameInfo info) {
		int result = 0;
		String smtpId = "GameInfo.update";
		try {
			session = sessionFactory.openSession();
			result = session.update(smtpId, info);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	public int insert(GameInfo info) {
		String smtpId = "GameInfo.insert";
		int result = 0;
		try {
			session = sessionFactory.openSession();
			result = session.insert(smtpId, info);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}
	
	

}
