package demo.md3.fruitshop.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SignUpRequest {

	@Size(min = 2, max = 100)
	private String name;

	@Size(min = 2, max = 100)
	private String username;

	@NotNull
	@Email(message = "The email isn't valid")
	private String email;

	@NotNull
	private String password;

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
