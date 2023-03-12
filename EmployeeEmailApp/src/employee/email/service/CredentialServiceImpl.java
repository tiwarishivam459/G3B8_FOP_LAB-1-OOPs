package employee.email.service;

import java.util.Random;

import employee.email.model.Employee;

public class CredentialServiceImpl implements CredentialService {
	
	private static final String COMPANY_DOMAIN = ".gl.in";
	private static final int PASSWORD_SIZE = 8;
	
	public String generateEmailAddress(Employee employee) {
		String firstName = employee.getFirstName();
		String lastName = employee.getLastName();
		String department = employee.getDepartment();
		
		return firstName + lastName + "@" + department + COMPANY_DOMAIN;
	}
	
	public String generatePassword() {
		String capitalCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String smallCase = capitalCase.toLowerCase();
		String nums = "0123456789";
		String splChars = "!@#$%^&*()";
		
		String passwordChars = capitalCase + smallCase + nums + splChars;
		
		String password = "";
		
		Random random = new Random();
		
		for(int i=0; i<PASSWORD_SIZE; i++) {
			password = password + passwordChars.charAt(random.nextInt(passwordChars.length()));
		}
		
		return password;
	}
	
	public String showCredentials(Employee employee) {
		System.out.println("    ");
		System.out.println("Dear " + employee.getFirstName() + " your generated credentials are as follows :");
		System.out.println("Email     --->  " + employee.getEmailAddress().toLowerCase());
		System.out.println("Password  --->  " + employee.getPassword());
		return null;
	}
}
