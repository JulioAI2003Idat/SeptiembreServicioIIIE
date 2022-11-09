package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true) //usar todos los metodos globales
public class ConfigSecurity extends WebSecurityConfigurerAdapter{
//en la version 2.6.7 se usa esto para facilitar el codigo
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("profesor").password(encriptado().encode("123")).roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
        .antMatchers("/producto/listar*").permitAll()
        .antMatchers("/producto/**").access("hasRole('ADMIN')")
        .and()
        .httpBasic()
        .and()
        .csrf().disable();
	}
	
	@Bean //para usarse en cualquier lado
	public PasswordEncoder encriptado(){
		return new BCryptPasswordEncoder();
	}
	

	/*@Bean
	public UserDetailsService userDetail() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		manager.createUser(
				User.withUsername("profesor")
				.password(encriptado().encode("123"))
				.roles("ADMIN")
				.build());
				
				return manager;
	}
	@Bean //para usarse en cualquier lado
	public PasswordEncoder encriptado(){
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeRequests()
		.antMatchers("/producto/*").access("hasRole('ADMIN')")
		.and()
		.httpBasic()
		.and()
		.csrf().disable();
		
		return http.build();
	}*/
}
