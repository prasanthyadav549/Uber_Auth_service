package com.example.Authservice.helpers;

import com.example.Authservice.models.Passenger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

// why we need this class ?
// Because spring security works on UserDetails polymorphic type for auth
public class AuthPassengerDetails extends Passenger implements UserDetails {

    private String username;  // this username is unique identifier in spring security we can store email or name or id
    private String password;

    public AuthPassengerDetails(Passenger passenger) {
        this.username = passenger.getEmail();
        this.password = passenger.getPassword()
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    // Below set of methods are not much of concern

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
