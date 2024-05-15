package sit707_week4;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests functions in LoginForm.
 * @author Ahsan Habib
 */
public class LoginFormTest 
{

	@Test
	public void testStudentIdentity() {
		String studentId = "221105067";
		Assert.assertNotNull("Student ID is ", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Jiaqi Li";
		Assert.assertNotNull("Student name is ", studentName);
	}
	
	@Test
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, null);
		Assert.assertTrue( status.isLoginSuccess() == false );
		System.out.println("Empty username -> " + status);
    }
	
	/*
	 * Write more test functions below.
	 */
	
	@Test
	public void testEmptyUsernameWrongPasswordAndDontCareValCode () {
		LoginStatus status = LoginForm.login(null, "xjshs");
		Assert.assertTrue( status.isLoginSuccess()== false);
		System.out.println("Emapty username, wrong password ->" + status);
	}
	
	@Test
	public void testEmaptyUsernameCorrectPasswordAndDontCareValCode () {
		LoginStatus status = LoginForm.login(null, "ahsan_pass");
		Assert.assertTrue( status.isLoginSuccess()== false);
		System.out.println("Empty username, correct password ->" + status);
	}
	
	@Test
	public void testWrongUsernameEmaptyPasswordAndDontCareValCode () {
		LoginStatus status = LoginForm.login("xishg", null);
		Assert.assertTrue( status.isLoginSuccess()== false);
		System.out.println("Wrong username, empty password ->" + status);
	}
	
	@Test
	public void testWrongUsernameWrongPasswordAndDontCareValCode () {
		LoginStatus status = LoginForm.login("xkshf", "sksjd");
		Assert.assertTrue( status.isLoginSuccess()== false);
		System.out.println("Wrong username, wrong password ->" + status);
	}
	
	@Test
	public void testWrongUsernameCorrectPassordAndDontCareValCode () {
		LoginStatus status = LoginForm.login("skchdjs", "ahsan_pass");
		Assert.assertTrue( status.isLoginSuccess()== false);
		System.out.println("Wrong username, correct password ->" + status);
	}
	
	
	@Test
	public void testCorrectUsernameEmptyPasswordAndDontCareValCode () {
		LoginStatus status = LoginForm.login("ahsan", null);
		Assert.assertTrue( status.isLoginSuccess()== false);
		System.out.println("Correct username, Empty password ->" + status);
	}
	
	@Test
	public void testCorrectUsernameWrongPasswordAndDontCareValCode () {
		LoginStatus status = LoginForm.login("ahsan", "sksjd");
		Assert.assertTrue( status.isLoginSuccess()== false);
		System.out.println("Correct username, wrong password ->" + status);
	}
	
	@Test
	public void testCorrectUsernameCorrectPasswordAndEmptyValCode () {
		LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
		Assert.assertTrue( status.isLoginSuccess()== true && LoginForm.validateCode(null) == false);
		System.out.println("Correct username, correct password ->" + status);
		System.out.println("Emapty code ->" + LoginForm.validateCode(null));
	}
	
	@Test
	public void testCorrectUsernameCorrectPasswordAndWrongValCode () {
		LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
		Assert.assertTrue( status.isLoginSuccess()== true && LoginForm.validateCode("abcd") == false);
		System.out.println("Correct username, correct password ->" + status);
		System.out.println("Wrong code ->" + LoginForm.validateCode("abcd"));
	}
	
	@Test
	public void testCorrectUsernameCorrectPasswordAndCorrectValCode () {
		LoginStatus status = LoginForm.login("ahsan", "ahsan_pass");
		Assert.assertTrue( status.isLoginSuccess()== true && LoginForm.validateCode("123456") == true);
		System.out.println("Correct username, correct password ->" + status);
		System.out.println("Wrong code ->" + LoginForm.validateCode("123456"));
	}



	
}
