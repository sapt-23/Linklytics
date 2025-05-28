package com.url.shortener.service;

import com.url.shortener.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID =1L;

    private Long id;
    private String username;
    private String email;

    private String password;

//    GrantedAuthority -> how roles are being managed in spring security
//    Collection<? extends GrantedAuthority>:
//    A collection (e.g., List or Set) of objects that implement the GrantedAuthority interface.
    
//    GrantedAuthority:
//    Represents a permission or role granted to the user. Spring Security uses it to manage authorization.
//  The ? extends GrantedAuthority allows any subclass or implementation of GrantedAuthority (e.g., SimpleGrantedAuthority).

    private Collection<? extends GrantedAuthority>  authorities;


    public UserDetailsImpl(Long id, String username, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

//    This build method converts your custom User entity (from your database) into a UserDetailsImpl object, which implements Spring Security’s UserDetails interface.

    public static UserDetailsImpl build(User user){
//        Converts the user's role (e.g., "ROLE_USER" or "ROLE_ADMIN") into a Spring Security GrantedAuthority. SimpleGrantedAuthority is the most common implementation used for roles.

//        Puts the single role/authority into a list
        GrantedAuthority authority=new SimpleGrantedAuthority(user.getRole());
        return new UserDetailsImpl(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                Collections.singletonList(authority)
        );
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return "password";
    }

    @Override
    public String getUsername() {
        return "username";
    }
}
