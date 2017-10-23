package br.ufrn.imd.ihc.identificationkey.form;

import java.util.Random;

public class UserForm {

	private String name;
	private String institution;
	private String email;
	private String userProfile;
	private String username;
	private String password;
	
	public static UserForm getDefaultForm() {
		UserForm form = new UserForm();
		
		form.setName(Long.toHexString(new Random().nextLong())); // Gera nome aleatório
		form.setInstitution("test_default_user_institution");
		form.setEmail("test@default.user.email");
		form.setUserProfile("Aluno");
		form.setUsername("test_default_user_user");
		form.setPassword("test_default_user_pass");
		
		return form;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
