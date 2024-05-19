package web.service;

import java.time.LocalDate;

/**
 * Business logic to handle login functions.
 * 
 * @author Ahsan.
 */
public class LoginService {

	/**
	 * Static method returns true for successful login, false otherwise.
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean login(String username, String password, String dob) {
		// Match a fixed user name, password, and date of birth.
        if ("ahsan".equals(username) && "ahsan_pass".equals(password)) {
            // Validate date of birth
        	System.out.println("dob : "+dob);
            LocalDate dobDate = LocalDate.parse(dob);
            LocalDate currentDate = LocalDate.now();
            LocalDate eighteenYearsAgo = currentDate.minusYears(18);

            if (dobDate.isBefore(eighteenYearsAgo)) {
                return true;
            }
        }
        return false;
	}
	
	
}
