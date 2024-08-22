package Com.Entity;

public class UserProfileEntity 
{
	private int UserId;
	private String UserFirstName;
	private String UserLastName;
	private String UserEmail;
	private String UserMobileNumber;
	private String UserEducation;
	private String UserStatus;
	private byte[] UserResume;
	
	public int getUserId() {
		return UserId;
	}
	
	public void setUserId(int userId) {
		UserId = userId;
	}
	
	public String getUserFirstName() {
		return UserFirstName;
	}
	
	public void setUserFirstName(String userFirstName) {
		UserFirstName = userFirstName;
	}
	
	public String getUserLastName() {
		return UserLastName;
	}
	
	public void setUserLastName(String userLastName) {
		UserLastName = userLastName;
	}
	
	public String getUserEmail() {
		return UserEmail;
	}
	
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	
	public String getUserMobileNumber() {
		return UserMobileNumber;
	}
	
	public void setUserMobileNumber(String userMobileNumber) {
		UserMobileNumber = userMobileNumber;
	}
	
	public String getUserEducation() {
		return UserEducation;
	}
	
	public void setUserEducation(String userEducation) {
		UserEducation = userEducation;
	}
	
	public String getUserStatus() {
		return UserStatus;
	}
	
	public void setUserStatus(String userStatus) {
		UserStatus = userStatus;
	}

	public byte[] getUserResume() {
		return UserResume;
	}

	public void setUserResume(byte[] userResume) {
		UserResume = userResume;
	}


	
}
