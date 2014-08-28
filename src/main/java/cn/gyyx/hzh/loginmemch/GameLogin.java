package cn.gyyx.hzh.loginmemch;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.gyyx.hzh.loginmemch.GameLogin;
import cn.gyyx.hzh.dal.GameDal;
import cn.gyyx.hzh.model.GameInfo;
import cn.gyyx.hzh.memcached.memcached;

//�����ʹ��
public class GameLogin {
	private static Log logger = LogFactory.getLog(GameLogin.class);
	private final GameDal gameDal = new GameDal();
	private final String getGameInfoKey = "/game/get/%s";
	private final String getGameListKey = "/game/list/";
	
	//��ȡ�б��ʹ��
	public List<GameInfo> queryList() {
		List<GameInfo> list = null;
		try {
			list = memcached.getValue(getGameListKey);
			logger.info(String.format("�ӻ������õ�����Ϸ�б������%s", list == null ? 0
					: list.size()));
			if (list == null) {
				list = gameDal.queryList();
				memcached.setValue(getGameListKey, list);
			}
		} catch (Exception ex) {
			logger.error(ex);
		}
		return list;
	}
	
	//��ȡ��Ϸ��ʹ��
	public GameInfo queryById(int id) {
		GameInfo info = null;
		try {
			info = memcached.getValue(String.format(getGameInfoKey, id));
			logger.info(String.format("�ӻ������õ�����Ϸ���ƣ�%s", info == null ? ""
					: info.getGameName()));
			if (info == null) {
				info = gameDal.queryById(id);
				memcached
						.setValue(String.format(getGameInfoKey, id), info);
			}
		} catch (Exception ex) {
			logger.error(ex);
		}
		return info;
	}
   
	//
	public int insert(GameInfo info) {
		int result = 0;
		try {
			result = gameDal.insert(info);
			if (result > 0) {
				memcached.setValue(
						String.format(getGameInfoKey, info.getCode()), info);
			}

		} catch (Exception ex) {
			logger.error(ex);
		}
		return result;
	}

	//
	public int update(GameInfo info) {
		int result = 0;
		try {
			result = gameDal.update(info);
			if (result > 0) {
				memcached.setValue(
						String.format(getGameInfoKey, info.getCode()), info);
			}

		} catch (Exception ex) {
			logger.error(ex);
		}
		return result;
	}
	
	
 

}
