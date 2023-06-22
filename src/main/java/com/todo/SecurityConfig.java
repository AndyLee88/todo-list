package com.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
public class SecurityConfig {
	
	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf->{
			csrf.disable();
		});
		
		http.cors(cors->{
			cors.disable();
		});
		
		http.authorizeHttpRequests(request->{
			request.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll();
			request.requestMatchers("/error").permitAll();
			request.requestMatchers("/favicon.png").permitAll();
			request.requestMatchers("/user/signup-end").permitAll();
			request.requestMatchers("/user/**","/user/forgot-password").permitAll();
			//login page에 bootstrap 적용
			request.requestMatchers("/webjars/**", "/css/**", "/images/**", "/js/**","/include/**").permitAll();
			
			request.requestMatchers("/user/manage").hasAnyRole("ADMIN");
			
			request.anyRequest().authenticated();
		});
		
		http.formLogin(login->{
			login.loginPage("/user/login");
			login.loginProcessingUrl("/user/login");
			login.defaultSuccessUrl("/", true);
			login.failureHandler((request, response, e)->{
				request.setAttribute("exception", e);
				request.getRequestDispatcher("login-fail").forward(request, response);
			});
			login.permitAll();
		});
		
		http.logout(logout->{
			logout.logoutUrl("/user/logout");
			logout.logoutSuccessUrl("/");
		});
		
		http.rememberMe(remember -> {
			remember.alwaysRemember(true);
			remember.tokenValiditySeconds(60*60*25);
			remember.userDetailsService(userDetailsService);
		});
		
		return http.build();
	}
}
