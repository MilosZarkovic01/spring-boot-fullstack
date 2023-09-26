package com.somika.customer;

public record CustomerRegistrationRequest(
        String name,
        String email,
        Integer age
) {

}
