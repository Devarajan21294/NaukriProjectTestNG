package com.pageobjectmanager;

//import com.pageobjectmodel.EmployeementPage;
//import com.pageobjectmodel.KeySkillsPage;
import com.pageobjectmodel.LoginPage;
//import com.pageobjectmodel.LogoutPage;
import com.pageobjectmodel.ProfileUpdatePage;
//import com.pageobjectmodel.ProjectsPage;
//import com.pageobjectmodel.ResumeHeadLinePage;
//import com.pageobjectmodel.ResumeUploadPage;
import com.utility.FileReaderManager;

public class PageObjectManager {
	private  static PageObjectManager pageObjectManager;
	private FileReaderManager fileReader;
	private LoginPage loginPage;
	private ProfileUpdatePage profileUpdate;
	//private ResumeUploadPage resumeUpload;
/*private ResumeHeadLinePage resumeHeadLine;
private KeySkillsPage keySkills;
private EmployeementPage employement;
private ProjectsPage project;
private LogoutPage logout;*/

	
	public static PageObjectManager getPageobjectmanager() {
		if(pageObjectManager==null){
			pageObjectManager= new PageObjectManager();
		}
		return pageObjectManager;
	}
	public FileReaderManager getFilereader() {
		if(fileReader==null) {
			fileReader =new FileReaderManager();
		}
		return fileReader;
	}
	public LoginPage getLoginpage() {
		if(loginPage==null) {
			loginPage=new LoginPage();
			
		}
		return loginPage;
	}
	
	public ProfileUpdatePage getProfileUpdate() {
		if(profileUpdate==null) {
			profileUpdate=new ProfileUpdatePage();
			
		}
		return profileUpdate;
	}
}
/*	public ResumeUploadPage getResumeUploadPage() {
		if(resumeUpload==null) {
			resumeUpload=new ResumeUploadPage();
		}
		return resumeUpload;
	}

	public ResumeHeadLinePage getResumeHeadLine() {
		if(resumeHeadLine==null) {
			resumeHeadLine=new ResumeHeadLinePage();
		}
	
	return resumeHeadLine;
}
	public KeySkillsPage getKeySkills() {
		if(keySkills==null) {
			keySkills=new KeySkillsPage();
		}
		return keySkills;
	}
	public EmployeementPage getEmployement() {
		if(employement==null) {
			employement=new EmployeementPage();
		}
		return employement;
	}
	
	public ProjectsPage getProject() {
		if(project==null) {
			project=new ProjectsPage();
		}
		return project;
	}
	
	
	public LogoutPage getLogout() {
		if(logout==null) {
			logout=new LogoutPage();
		}
		return logout;
	}
	
}*/
