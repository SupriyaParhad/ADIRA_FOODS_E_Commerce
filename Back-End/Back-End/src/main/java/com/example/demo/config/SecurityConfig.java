package com.example.demo.config;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.demo.Security.CustomeUserDetailService;
import com.example.demo.Security.JwtAuthenticationEntryPoint;
import com.example.demo.Security.JwtAuthenticationFilter;
import com.example.demo.Security.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Autowired
	private MyUserDetailsService customeUserDetailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
        csrf()			//cross site forgeries
        .disable()          
        .authorizeHttpRequests() 
        
        
        .antMatchers("/user/login").permitAll()
        
        //.antMatchers("/customer/**").permitAll()
       // .antMatchers("/admin/addproduct").permitAll()
        
        .antMatchers("/customer/**").permitAll()//.hasAnyRole("CUSTOMER","ADMIN")
        .antMatchers("/user/signUp").permitAll()
        //.antMatchers("/admin/**").permitAll()//.hasRole("ADMIN")
        
		//.antMatchers("/admin").hasRole("ADMIN")
		//.antMatchers("/home","/api/auth/**").permitAll() //enabling global access to all urls with /api/auth 
		//only for JS clnts (react / angular)
        .antMatchers("/admin/**").permitAll()
		.antMatchers(HttpMethod.OPTIONS).permitAll()
        .anyRequest()         //authorize any requests  //hectic  //so use jwt
        .authenticated()
        .and()
        .exceptionHandling().authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
        .and()
        .sessionManagement() //will give javascript login  //now form based will go
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	
	http.addFilterBefore(this.jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);
	}
	
	//for authentication//added after authority
	//added through source

	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}*/
	
	/*@Bean
	public UserDetailsService getUserDetailService() {
		return new MyUserDetailsService();
	}*/
	
    @Bean

	public AuthenticationManager authenticationMgr(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
		
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	/*@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider daoAuthenticationProvider =new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		
		return daoAuthenticationProvider;
	}

	*/
	
	/*@Bean
     public FilterRegistrationBean coresFilter()
     {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		
		CorsConfiguration corsConfiguration =new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.addAllowedOriginPattern("*");
		corsConfiguration.addAllowedHeader("Authorization");
		corsConfiguration.addAllowedHeader("Content-Type");
		corsConfiguration.addAllowedHeader("Accept");
		corsConfiguration.addAllowedMethod("POST");
		corsConfiguration.addAllowedMethod("GET");
		corsConfiguration.addAllowedMethod("PUT");
		corsConfiguration.addAllowedMethod("DELETE");
		corsConfiguration.addAllowedMethod("OPTIONS");
		corsConfiguration.setMaxAge(3600L);
		//source.registerCorsConfiguration("/**", corsConfiguration);
		source.registerCorsConfiguration("/**", corsConfiguration);
		FilterRegistrationBean bean=new FilterRegistrationBean(new CorsFilter(source));
    	return bean;
     }*/
	
    
	
}
