package Com.Entity;

public class ContactFormEntity 
{
	private int ContactId;
	private String ContactPersonName;
	private String ContactPersonEmail;
	private String SubjectOfContact;
	private String Message;
	
	public int getContactId() 
	{
		return ContactId;
	}
	
	public void setContactId(int contactId) 
	{
		ContactId = contactId;
	}
	
	public String getContactPersonName() 
	{
		return ContactPersonName;
	}
	
	public void setContactPersonName(String contactPersonName) 
	{
		ContactPersonName = contactPersonName;
	}
	
	public String getContactPersonEmail() 
	{
		return ContactPersonEmail;
	}
	
	public void setContactPersonEmail(String contactPersonEmail) 
	{
		ContactPersonEmail = contactPersonEmail;
	}
	
	public String getSubjectOfContact() 
	{
		return SubjectOfContact;
	}
	
	public void setSubjectOfContact(String subjectOfContact) 
	{
		SubjectOfContact = subjectOfContact;
	}
	
	public String getMessage() 
	{
		return Message;
	}
	
	public void setMessage(String message) 
	{
		Message = message;
	}	
}
