package Com.Module;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Com.Entity.AdminRegisterEntity;
import Com.Entity.ContactFormEntity;
import Com.Entity.JobApplicationFormEntity;
import Com.Entity.JobCategoryEntity;
import Com.Entity.JobDetailsEntity;
import Com.Entity.UserEntity;
import Com.Entity.UserProfileEntity;
import Com.Entity.UserRegistrationEntity;

public class Promodule 
{
	Connection con;
	public Promodule(Connection con) 
	{
		this.con = con;
	}

	public boolean insert(AdminRegisterEntity ar) throws SQLException 
	{
		boolean f=false;
		String sql = "insert into adminregister(AdminName, AdminEmail, AdminUserName, AdminPassword) values(?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, ar.getAdminName());
		ps.setString(2, ar.getAdminEmail());
		ps.setString(3, ar.getAdminUserName());
		ps.setString(4, ar.getAdminPassword());
		
		int i = ps.executeUpdate();
		if(i == 1)
		{
			System.out.println("Record Inserted");
			f = true;
		}
		return false;
	}

	public String LoginCheck(String email, String password) throws SQLException 
	{
		AdminRegisterEntity ar = null;
		String s = null;
		String sql = "select * from adminregister where AdminEmail = ? and AdminPassword = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, email);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			ar = new AdminRegisterEntity();
			ar.setId(rs.getInt(1));
			ar.setAdminName(rs.getString(2));
			ar.setAdminEmail(rs.getString(3));
			ar.setAdminUserName(rs.getString(4));
			ar.setAdminPassword(rs.getString(5));
			
			if(email.equals(ar.getAdminEmail()) && password.equals(ar.getAdminPassword()))
			{
				s = ar.getAdminEmail();
				break;
			}
			
		}
		
		return s;
	}

	public boolean InsertUser(UserRegistrationEntity ur) throws SQLException 
	{
		boolean f = false;
		String sql = "insert into userregistrationtable(UserName, UserEmail, UserPassword, UserMobileNumber, UserLocation, UserRegistrationFee) values(?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, ur.getUserName());
		ps.setString(2, ur.getUserEmail());
		ps.setString(3, ur.getUserPassword());
		ps.setString(4, ur.getUserMobileNumber());
		ps.setString(5, ur.getUserLocation());
		ps.setString(6, ur.getUserRegistrationFee());
		
		int i = ps.executeUpdate();
		if(i == 1)
		{
			System.out.println("Record Inserted");
			f = true;
		}
		return false;
	}
	
	public List<UserRegistrationEntity> Allrecords() throws SQLException
	{
		List<UserRegistrationEntity> l = new ArrayList<UserRegistrationEntity>();
		UserRegistrationEntity ur = null;
		String sql = "select * from userregistrationtable";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) 
		{
			ur = new UserRegistrationEntity();
			ur.setUserId(rs.getInt(1));
			ur.setUserName(rs.getString(2));
			ur.setUserEmail(rs.getString(3));
			ur.setUserPassword(rs.getString(4));
			ur.setUserMobileNumber(rs.getString(5));
			ur.setUserLocation(rs.getString(6));
			ur.setUserRegistrationFee(rs.getString(7));
			l.add(ur);
		}
		return l;
		
	}

	public List<UserRegistrationEntity> CheckId(int Id) throws SQLException
	{
		List<UserRegistrationEntity> l=new ArrayList<UserRegistrationEntity>();
		UserRegistrationEntity ur=null;
		String sql="select * from userregistrationtable where UserId=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, Id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			ur=new UserRegistrationEntity();
			ur.setUserId(rs.getInt(1));
			ur.setUserName(rs.getString(2));
			ur.setUserEmail(rs.getString(3));
			ur.setUserPassword(rs.getString(4));
			ur.setUserMobileNumber(rs.getString(5));
			ur.setUserLocation(rs.getString(6));
			ur.setUserRegistrationFee(rs.getString(7));
			l.add(ur);
		}
		return l;
		
	}

	
	public boolean InsertRegisteredUser(UserRegistrationEntity ur) throws SQLException 
	{
		boolean f = false;
		String sql = "insert into registereduserstable(UserName, UserEmail, UserPassword, UserMobileNumber, UserLocation, UserRegistrationFee) values(?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
	
		ps.setString(1, ur.getUserName());
		ps.setString(2, ur.getUserEmail());
		ps.setString(3, ur.getUserPassword());
		ps.setString(4, ur.getUserMobileNumber());
		ps.setString(5, ur.getUserLocation());
		ps.setString(6, ur.getUserRegistrationFee());
		
		int i = ps.executeUpdate();
		System.out.println(i);
		if(i == 1)
		{
			System.out.println("Record Inserted");
			f = true;
		}
		return f;
	}
	
	public boolean InsertUserProfile(UserProfileEntity up) throws SQLException 
	{
		boolean f = false;
		String sql = "insert into userprofile(UserFirstName, UserLastName, UserEmail, UserMobileNumber, UserEducation, UserStatus, UserResume) values(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, up.getUserFirstName());
		ps.setString(2, up.getUserLastName());
		ps.setString(3, up.getUserEmail());
		ps.setString(4, up.getUserMobileNumber());
		ps.setString(5, up.getUserEducation());
		ps.setString(6, up.getUserStatus());
		
		if (up.getUserResume() != null) {
            ps.setBytes(7, up.getUserResume());  // Set the resume as bytes
        } else {
            ps.setNull(7, java.sql.Types.BLOB);
        }
		
		int i = ps.executeUpdate();
		if(i == 1)
		{
			System.out.println("Record Inserted");
			f = true;
		}
		return f;
	}
	
	public boolean InsertJobCategory(JobCategoryEntity j) throws SQLException 
	{
		boolean f = false;
		String sql = "insert into jobcategory(JobCategoryName) values(?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, j.getJobCategoryName());
		
		int i = ps.executeUpdate();
		if(i == 1)
		{
			System.out.println("Record Inserted");
		}
		return false;
	}

	public String loginCheck(String useremail, String userpassword) throws SQLException 
	{
		UserRegistrationEntity ur = null;
		String s = null;
		String sql = "select * from registereduserstable where UserEmail = ? and UserPassword = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, useremail);
		ps.setString(2, userpassword);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			ur = new UserRegistrationEntity();
			ur.setUserId(rs.getInt(1));
			ur.setUserName(rs.getString(2));
			ur.setUserEmail(rs.getString(3));
			ur.setUserPassword(rs.getString(4));
			ur.setUserMobileNumber(rs.getString(5));
			ur.setUserLocation(rs.getString(6));
			ur.setUserRegistrationFee(rs.getString(7));
			
			
			
			if(useremail.equals(ur.getUserEmail()) && userpassword.equals(ur.getUserPassword()))
			{
				s = ur.getUserEmail();
				break;
			}
		}
		return s;
	}

	public boolean InsertJobDetails(JobDetailsEntity jd) throws SQLException 
	{
		boolean f = false;
		String sql = "insert into jobdetail(CompanyLogo, JobTitle, JobLocation, JobType, JobSalary, JobDescription, JobResponsibility, JobQualification, JobSummary, JobCompanyDetails, JobDateLine) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setBytes(1, jd.getCompanyLogo());
		ps.setString(2, jd.getJobTitle());
		ps.setString(3, jd.getJobLocation());
		ps.setString(4, jd.getJobType());
		ps.setString(5, jd.getJobSalary());
		ps.setString(6, jd.getJobDescription());
		ps.setString(7, jd.getJobResponsibility());
		ps.setString(8, jd.getJobQualification());
		ps.setString(9, jd.getJobSummary());
		ps.setString(10, jd.getJobCompanyDetail());
		ps.setString(11, jd.getJobDateLine());
		
		int i = ps.executeUpdate();
		if(i == 1)
		{
			System.out.println("Record Inserted");
			f = true;
		}
		return f;
	}
	
	public List<JobDetailsEntity> Allrecord() throws SQLException
	{
		List<JobDetailsEntity> l = new ArrayList<JobDetailsEntity>();
		JobDetailsEntity jd = null;
		String sql = "select * from jobdetail";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			jd = new JobDetailsEntity();
			jd.setJobId(rs.getInt(1));
			jd.setCompanyLogo(rs.getBytes(2));
			jd.setJobTitle(rs.getString(3));
			jd.setJobLocation(rs.getString(4));
			jd.setJobType(rs.getString(5));
			jd.setJobSalary(rs.getString(6));
			jd.setJobDescription(rs.getString(7));
			jd.setJobResponsibility(rs.getString(8));
			jd.setJobQualification(rs.getString(9));
			jd.setJobSummary(rs.getString(10));
			jd.setJobCompanyDetail(rs.getString(11));
			jd.setJobDateLine(rs.getString(12));
			
			l.add(jd);
		}
		return l;
	}
	
	public List<JobDetailsEntity> checkId(int id) throws SQLException
	{
		List<JobDetailsEntity> l = new ArrayList<JobDetailsEntity>();
		JobDetailsEntity n = null;
		String sql = "select * from jobdetail where JobId=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			n = new JobDetailsEntity();
			n.setJobId(rs.getInt(1));
			n.setCompanyLogo(rs.getBytes(2));
			n.setJobTitle(rs.getString(3));
			n.setJobLocation(rs.getString(4));
			n.setJobType(rs.getString(5));
			n.setJobSalary(rs.getString(6));
			n.setJobDescription(rs.getString(7));
			n.setJobResponsibility(rs.getString(8));
			n.setJobQualification(rs.getString(9));
			n.setJobSummary(rs.getString(10));
			n.setJobCompanyDetail(rs.getString(11));
			n.setJobDateLine(rs.getString(12));
			l.add(n);
		}
		return l;
		
	}

	public boolean InsertApplicationForm(JobApplicationFormEntity ja) throws SQLException 
	{
		boolean f = false;
		String sql = "insert into jobapplication(JobTitle, JobApplicationUserName, JobApplicationUserEmail, JobApplicationUserContact, UserEducation, JobApplicationUserResume, JobApplicationUserAreaOfExpertise) values(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, ja.getJobTitle());
		ps.setString(2, ja.getJobApplicationUserName());
		ps.setString(3, ja.getJobApplicationUserEmail());
		ps.setString(4, ja.getJobApplicationUserContact());
		ps.setString(5, ja.getUserEducation());
		ps.setString(6, ja.getJobApplicationUserResume());
		ps.setString(7, ja.getJobApplicationUserAreaOfExpertise());
		
		int i = ps.executeUpdate();
		if(i == 1)
		{
			System.out.println("Record Inserted");
			f = true;
		}
		return f;
	}
	
	public List<JobApplicationFormEntity> allrecord() throws SQLException
	{
		List<JobApplicationFormEntity> l = new ArrayList<JobApplicationFormEntity>();
		JobApplicationFormEntity ja = null;
		String sql = "select * from jobapplication";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			ja = new JobApplicationFormEntity();
			ja.setJobApplicationId(rs.getInt(1));
			ja.setJobTitle(rs.getString(2));
			ja.setJobApplicationUserName(rs.getString(3));
			ja.setJobApplicationUserEmail(rs.getString(4));
			ja.setJobApplicationUserContact(rs.getString(5));
			ja.setUserEducation(rs.getString(6));
			ja.setJobApplicationUserResume(rs.getString(7));
			ja.setJobApplicationUserAreaOfExpertise(rs.getString(8));
			
			l.add(ja);
		}
		return l;
		
	}

	public boolean InsertContactForm(ContactFormEntity c) throws SQLException 
	{
		boolean f = false;
		String sql = "Insert into contactformtable(ContactPersonName, ContactPersonEmail, SubjectOfContact, Message) values(?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, c.getContactPersonName());
		ps.setString(2, c.getContactPersonEmail());
		ps.setString(3, c.getSubjectOfContact());
		ps.setString(4, c.getMessage());
		
		int i = ps.executeUpdate();
		if(i == 1)
		{
			System.out.println("Record Inserted");
			f = true;
		}
		return f;
	}
	
	public List<ContactFormEntity> allrecords() throws SQLException
	{
		List<ContactFormEntity> l = new ArrayList<ContactFormEntity>();
		ContactFormEntity C = null;
		String sql = "select * from contactformtable";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			C = new ContactFormEntity();
			C.setContactId( rs.getInt(1));
			C.setContactPersonName(rs.getString(2));
			C.setContactPersonEmail(rs.getString(3));
			C.setSubjectOfContact(rs.getString(4));
			C.setMessage(rs.getString(5));
			l.add(C);
		}
		return l;
		
	}

	public boolean delete(int id) throws SQLException 
	{
		boolean f = false;
		String sql = "delete from userregistrationtable where UserId = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		int i = ps.executeUpdate();
		if(i == 1)
		{
			f=true;
		}
		return false;
	}
	
	public List<JobDetailsEntity> fetch() throws SQLException
	{
		List<JobDetailsEntity> l = new ArrayList<JobDetailsEntity>();
		JobDetailsEntity jd = null;
		String sql = "select * from jobdetail";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			jd = new JobDetailsEntity();
			jd.setJobId(rs.getInt(1));
			jd.setCompanyLogo(rs.getBytes(2));
			jd.setJobTitle(rs.getString(3));
			jd.setJobLocation(rs.getString(4));
			jd.setJobType(rs.getString(5));
			jd.setJobSalary(rs.getString(6));
			jd.setJobDescription(rs.getString(7));
			jd.setJobResponsibility(rs.getString(8));
			jd.setJobQualification(rs.getString(9));
			jd.setJobSummary(rs.getString(10));
			jd.setJobCompanyDetail(rs.getString(11));
			jd.setJobDateLine(rs.getString(12));
			l.add(jd);
		}
		return l;
	}
	
	public List<JobDetailsEntity> CheckJobId(int JobId) throws SQLException
	{
		List<JobDetailsEntity> l = new ArrayList<JobDetailsEntity>();
		JobDetailsEntity jd = null;
		String sql = "select * from jobdetail where JobId = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,JobId);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			jd = new JobDetailsEntity();
			jd.setJobId(rs.getInt(1));
			jd.setCompanyLogo(rs.getBytes(2));
			jd.setJobTitle(rs.getString(3));
			jd.setJobLocation(rs.getString(4));
			jd.setJobType(rs.getString(5));
			jd.setJobSalary(rs.getString(6));
			jd.setJobDescription(rs.getString(7));
			jd.setJobResponsibility(rs.getString(8));
			jd.setJobQualification(rs.getString(9));
			jd.setJobSummary(rs.getString(10));
			jd.setJobCompanyDetail(rs.getString(11));
			jd.setJobDateLine(rs.getString(12));
			l.add(jd);
		}
		return l;
		
	}

	public boolean update(JobDetailsEntity jd) throws SQLException 
	{
		boolean f = false;
		String sql = "update jobdetail set CompanyLogo=?, JobTitle=?, JobLocation=?, JobType=?, JobSalary=?, JobDescription=?, JobResponsibility=?, JobQualification=?, JobSummary=?, JobCompanyDetail=?, JobDateLine=? where JobId=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setBytes(1, jd.getCompanyLogo());
		ps.setString(2, jd.getJobTitle());
		ps.setString(3, jd.getJobLocation());
		ps.setString(4, jd.getJobType());
		ps.setString(5, jd.getJobSalary());
		ps.setString(6, jd.getJobDescription());
		ps.setString(7, jd.getJobResponsibility());
		ps.setString(8, jd.getJobQualification());
		ps.setString(9, jd.getJobSummary());
		ps.setString(10, jd.getJobCompanyDetail());
		ps.setString(11, jd.getJobDateLine());
		ps.setInt(12, jd.getJobId());
		
		int i = ps.executeUpdate();
		if(i == 1)
		{
			f = true;
		}
		return f;
	
	}
	
	
	public List<JobApplicationFormEntity> Checkid(int id) throws SQLException 
	{
		List<JobApplicationFormEntity> l = new ArrayList<JobApplicationFormEntity>();
		JobApplicationFormEntity ja = null;
		String sql = "select * from jobapplication where JobApplicationId=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			ja = new JobApplicationFormEntity();
			ja.setJobApplicationId(rs.getInt(1));
			ja.setJobTitle(rs.getString(2));
			ja.setJobApplicationUserName(rs.getString(3));
			ja.setJobApplicationUserEmail(rs.getString(4));
			l.add(ja);
		}
		return l;
		
	}
	
	public boolean insertdetails(UserEntity ue) throws SQLException 
	{
		boolean f = false;
		String sql = "insert into users(JobTitle, UserName, UserEmail) values(?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, ue.getJobTitle());
		ps.setString(2, ue.getUserName());
		ps.setString(3, ue.getUserEmail());
		
		int i = ps.executeUpdate();
		if(i==1)
		{
			System.out.println("Record Inserted");
			f = true;
		}
		
		return f;
	}

	public boolean DelteRecord(int id) throws SQLException 
	{
		boolean f = false;
		String sql = "delete from jobapplication where JobApplicationId=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		int i = ps.executeUpdate();
		if(i == 1)
		{
			f = true;
		}
		return f;
	}

	public boolean Delete(int id) throws SQLException 
	{
		boolean f = false;
		String sql = "delete from jobdetail where JobId = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		int i = ps.executeUpdate();
		if(i == 1)
		{
			f = true;
		}
		return f;
	}

	
}
