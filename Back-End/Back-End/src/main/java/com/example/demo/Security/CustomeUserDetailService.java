package com.example.demo.Security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.repository.IUserDao;

import custom_exceptions.ResourceNotFoundException;
import lombok.ToString;

//@Service
@ToString
public class CustomeUserDetailService implements UserDetails{
	
	private User user;
	

	public CustomeUserDetailService(User user) {
		super();
		this.user = user;
	}
	
	
	 @Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return user.getEmail();
		}

		@Override
		public boolean isAccountNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return true;
		}
	   
		/* @ManyToMany(fetch = FetchType.EAGER)
		    @JoinTable(name="user_role",
		    joinColumns = @JoinColumn(name="customer",referencedColumnName="id"),
		    inverseJoinColumns = @JoinColumn(name="role",referencedColumnName="id"))
		    private Set<Role> role=new HashSet<>();
		 */
		 
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			
			return null;

}


		@Override
		public String getPassword() {
		
			return user.getPassword();
		}
}
