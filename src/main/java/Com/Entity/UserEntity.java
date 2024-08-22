package Com.Entity;

public class UserEntity 
{
	private int UserId;
	private String JobTitle;
	private String UserName;
	private String UserEmail;
	
	public int getUserId() 
	{
		return UserId;
	}
	
	public void setUserId(int userId) 
	{
		UserId = userId;
	}
	
	public String getJobTitle() 
	{
		return JobTitle;
	}
	
	public void setJobTitle(String jobTitle) 
	{
		JobTitle = jobTitle;
	}
	
	public String getUserName() 
	{
		return UserName;
	}
	
	public void setUserName(String userName) 
	{
		UserName = userName;
	}
	
	public String getUserEmail() 
	{
		return UserEmail;
	}
	
	public void setUserEmail(String userEmail) 
	{
		UserEmail = userEmail;
	}
	
}
