package cn.gyyx.hzh.common;

public class ResultInfo<T>{
	
	private boolean isSuccess;
	private String message;
	private T data;
	
	public boolean isSuccess()
	{
		return isSuccess;
	} 
	
	public void setSuccess(boolean isSuccess)
	{
		this.isSuccess=isSuccess;
	}
	public String GetMessage() {
		return message;		
	}
	
	public void setMessage(String message)
	{
		this.message=message;		
	}
	
	public T getData()
	{
		return data;
	}
	public void setData(T data)
	{
		this.data=data;
	}
}
