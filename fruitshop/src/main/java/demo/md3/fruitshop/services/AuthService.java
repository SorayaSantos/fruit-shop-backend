package demo.md3.fruitshop.services;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import demo.md3.fruitshop.entities.Role;
import demo.md3.fruitshop.entities.User;
import demo.md3.fruitshop.exception.AppException;
import demo.md3.fruitshop.payload.ApiResponse;
import demo.md3.fruitshop.payload.JwtAuthenticationResponse;
import demo.md3.fruitshop.payload.LoginRequest;
import demo.md3.fruitshop.payload.SignUpRequest;
import demo.md3.fruitshop.repositories.RoleRepository;
import demo.md3.fruitshop.repositories.UserRepository;
import demo.md3.fruitshop.security.JwtTokenProvider;

@Service
public class AuthService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	public ResponseEntity<JwtAuthenticationResponse> authenticateUser(LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtTokenProvider.generateToken(authentication);
		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
	}

	public ResponseEntity<ApiResponse> registerUser(SignUpRequest signUpRequest) {

		if (signUpRequest.getName().isEmpty() || signUpRequest.getUsername().isEmpty()
				|| signUpRequest.getEmail().isEmpty() || signUpRequest.getPassword().isEmpty()) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Empty credentials!"),
					HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "Email address already registered!"),
					HttpStatus.BAD_REQUEST);
		}

		User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
				signUpRequest.getPassword(), true, new ArrayList<Role>());

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		Role userRole = roleRepository.findByName("ROLE_USER").orElseThrow(() -> new AppException("User role not set"));

		user.addRole(userRole);

		User result = userRepository.saveAndFlush(user);

		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("api/users/{username}")
				.buildAndExpand(result.getUsername()).toUri();

		return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully!"));

	}
}
