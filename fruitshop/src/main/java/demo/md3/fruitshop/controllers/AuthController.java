package demo.md3.fruitshop.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.md3.fruitshop.payload.auth.ApiResponse;
import demo.md3.fruitshop.payload.auth.JwtAuthenticationResponse;
import demo.md3.fruitshop.payload.auth.LoginRequest;
import demo.md3.fruitshop.payload.auth.SignUpRequest;
import demo.md3.fruitshop.services.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("/signin")
	public ResponseEntity<JwtAuthenticationResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		return authService.authenticateUser(loginRequest);
	}

	@PostMapping("/signup")
	public ResponseEntity<ApiResponse> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
		return authService.registerUser(signUpRequest);
	}
}
