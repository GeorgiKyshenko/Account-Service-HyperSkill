package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_registration")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    private String name;
    @NotEmpty
    @JsonProperty("lastname")
    private String lastName;
    @NotEmpty
    @Email(regexp = "[a-z,0-9]+@[acme]+\\.com")
    private String email;
    @NotEmpty
    private String password;
}
