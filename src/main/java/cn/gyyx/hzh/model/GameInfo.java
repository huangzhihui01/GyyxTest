package cn.gyyx.hzh.model;

import java.io.Serializable;

public class GameInfo implements Serializable  {
	private int Code;
	private String GameName;
	
	public int getCode() {
		return Code;
	}
	
   public void setCode(int Code)
   {
	   this.Code=Code;
   }
   
   public String getGameName()
   {
	   return GameName;
   }
   
   public void setGameName(String GameName)
   {
	   this.GameName=GameName;
   }
   
}
