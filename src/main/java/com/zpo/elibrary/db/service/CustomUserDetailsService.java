package com.zpo.elibrary.db.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.zpo.elibrary.db.entity.User;
import com.zpo.elibrary.db.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String name) throws UsernameNotFoundException {
        final User user = userRepository.getUserByName(name);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User with email=%s was not found", name));
        }
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
            getAuthorities(user));
    }

    private Set<GrantedAuthority> getAuthorities(final User user) {
        final Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

        final GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getRole().name());
        authorities.add(grantedAuthority);

        return authorities;
    }
}
