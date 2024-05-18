package com.example.Authservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class
PassengerSignupRequestDto {
    private String name;
    private String phoneNumber;
    private String email;
    private String password;
}
