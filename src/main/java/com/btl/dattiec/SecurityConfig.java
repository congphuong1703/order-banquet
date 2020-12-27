package com.btl.dattiec;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http
			   .authorizeRequests()
			   .anyRequest()
			   .permitAll();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web
			   .ignoring()
			   .antMatchers("/resources/**", "/static/**", "/webfonts/**", "/css/**", "/js/**", "/images/**","/jar/**","/build/libs/**");
	}


}
