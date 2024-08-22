package Com.Entity;

public class JobApplicationFormEntity 
{
	private int JobApplicationId;
	private String JobTitle;
	private String JobApplicationUserName;
	private String JobApplicationUserEmail;
	private String JobApplicationUserContact;
	private String UserEducation;
	private String JobApplicationUserResume;
	private String JobApplicationUserAreaOfExpertise;
	
	public int getJobApplicationId() 
	{
		return JobApplicationId;
	}
	
	public void setJobApplicationId(int jobApplicationId) 
	{
		JobApplicationId = jobApplicationId;
	}
	
	public String getJobTitle() 
	{
		return JobTitle;
	}

	public void setJobTitle(String jobTitle) 
	{
		JobTitle = jobTitle;
	}
	
	public String getJobApplicationUserName() 
	{
		return JobApplicationUserName;
	}
	
	public void setJobApplicationUserName(String jobApplicationUserName) 
	{
		JobApplicationUserName = jobApplicationUserName;
	}
	
	public String getJobApplicationUserEmail() 
	{
		return JobApplicationUserEmail;
	}
	
	public void setJobApplicationUserEmail(String jobApplicationUserEmail) 
	{
		JobApplicationUserEmail = jobApplicationUserEmail;
	}
	
	public String getJobApplicationUserContact() 
	{
		return JobApplicationUserContact;
	}
	
	public String getUserEducation() 
	{
		return UserEducation;
	}

	public void setUserEducation(String userEducation) 
	{
		UserEducation = userEducation;
	}
	
	public void setJobApplicationUserContact(String jobApplicationUserContact) 
	{
		JobApplicationUserContact = jobApplicationUserContact;
	}
	
	

	/**
	 * @return the jobApplicationUserResume
	 */
	public String getJobApplicationUserResume() {
		return JobApplicationUserResume;
	}

	/**
	 * @param jobApplicationUserResume the jobApplicationUserResume to set
	 */
	public void setJobApplicationUserResume(String jobApplicationUserResume) {
		JobApplicationUserResume = jobApplicationUserResume;
	}

	public String getJobApplicationUserAreaOfExpertise() 
	{
		return JobApplicationUserAreaOfExpertise;
	}
	
	public void setJobApplicationUserAreaOfExpertise(String jobApplicationUserAreaOfExpertise) 
	{
		JobApplicationUserAreaOfExpertise = jobApplicationUserAreaOfExpertise;
	}
	
}
