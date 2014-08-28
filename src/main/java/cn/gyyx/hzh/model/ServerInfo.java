package cn.gyyx.hzh.model;

import java.io.Serializable;

public class ServerInfo implements Serializable {
	private int Code;
	private int GameId;
	private String ServerName;
	
	public int getCode()
	{
		return Code;
	}
	
	public void setCode(int Code)
	{
		this.Code=Code;
	}
	
	public int getGameId()
	{
		return GameId;
	}
	
	public void setGameId(int GameId)
	{
		this.GameId=GameId;
	}
	
	public String getServerName()
	{
     	return ServerName;
	}
	
	public void setServerName(String ServerName)
	{
		this.ServerName=ServerName;
	}
	

}
