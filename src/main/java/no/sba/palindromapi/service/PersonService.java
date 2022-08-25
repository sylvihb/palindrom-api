package no.sba.palindromapi.service;

import org.springframework.stereotype.Service;

@Service
public class PersonService {

    public Boolean erPalindrom(String input) {
        String reversertString = new StringBuilder(input).reverse().toString();
        return input.equalsIgnoreCase(reversertString.toLowerCase());
    }
 }
