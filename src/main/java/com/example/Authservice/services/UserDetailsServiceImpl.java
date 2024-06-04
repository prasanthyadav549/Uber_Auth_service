package com.example.Authservice.services;

import com.example.Authservice.helpers.AuthPassengerDetails;
import com.example.Authservice.models.Passenger;
import com.example.Authservice.repositories.PassengerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserDetailsServiceImpl implements UserDetailsService {

    private final PassengerRepository passengerRepository;

    public UserDetailsServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Passenger> passenger = passengerRepository.findPassengerByEmail(email);
        if(passenger.isPresent()) {
            return new AuthPassengerDetails(passenger.get());
        }
        else {
            throw new UsernameNotFoundException("Cannot find the Passenger by the given Email");
        }
    }
}
