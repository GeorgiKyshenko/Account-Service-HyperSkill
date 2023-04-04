package com.example.demo.models.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonPropertyOrder({"name", "lastName", "email"})
public class SignUpResponse {

    String name;
    @JsonProperty("lastname")
    String lastName;
    String email;
}
