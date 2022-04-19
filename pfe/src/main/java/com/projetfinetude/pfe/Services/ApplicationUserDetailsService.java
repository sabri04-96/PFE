package com.projetfinetude.pfe.Services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projetfinetude.pfe.Repositories.PersonRepository;

@Service
public class ApplicationUserDetailsService implements UserDetailsService{

	private PersonRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return new User(username, username, null);
	}
	
}
