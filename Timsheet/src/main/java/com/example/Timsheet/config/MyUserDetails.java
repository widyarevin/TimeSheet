package com.example.Timsheet.config;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.Timsheet.models.User;
import com.example.Timsheet.repositories.UserRepository;

@Service
public class MyUserDetails implements UserDetails, UserDetailsService{
    @Autowired
    private UserRepository userRepository;
    private String username;
    private Integer id;
    private String password;
    private GrantedAuthority authority;

    public MyUserDetails(){}

    public MyUserDetails(User user){
        this.username = user.getEmployee().getEmail();
        this.password = user.getPassword();
        this.id = user.getEmployee().getId();
        this.authority = new SimpleGrantedAuthority(user.getRole().getName());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        Set<GrantedAuthority> grantedAuthority = new HashSet<>();
        grantedAuthority.add(authority);
        return grantedAuthority;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User data = userRepository.LoginSecurity(username);
        return new MyUserDetails(data);
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    
    @Override
    public boolean isEnabled() {
        return true;
    }
}
