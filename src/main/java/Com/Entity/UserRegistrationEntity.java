package Com.Entity;

public class UserRegistrationEntity 
{
	private int UserId;
	private String UserName;
	private String UserEmail;
	private String UserPassword;
	private String UserMobileNumber;
	private String UserLocation;
	private String UserRegistrationFee;
	private String UserStatus;
	
	public int getUserId() 
	{
		return UserId;
	}
	
	public void setUserId(int userId) 
	{
		UserId = userId;
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
	
	public String getUserPassword() 
	{
		return UserPassword;
	}
	
	public void setUserPassword(String userPassword) 
	{
		UserPassword = userPassword;
	}
	
	public String getUserMobileNumber() 
	{
		return UserMobileNumber;
	}
	
	public void setUserMobileNumber(String userMobileNumber) 
	{
		UserMobileNumber = userMobileNumber;
	}
	
	public String getUserLocation() 
	{
		return UserLocation;
	}
	
	public void setUserLocation(String userLocation) 
	{
		UserLocation = userLocation;
	}
	
	public String getUserRegistrationFee() 
	{
		return UserRegistrationFee;
	}
	
	public void setUserRegistrationFee(String userRegistrationFee) 
	{
		UserRegistrationFee = userRegistrationFee;
	}

	public String getUserStatus() {
		return UserStatus;
	}

	public void setUserStatus(String userStatus) {
		UserStatus = userStatus;
	}
	
}
