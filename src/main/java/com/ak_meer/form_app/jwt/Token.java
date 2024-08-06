package com.ak_meer.form_app.jwt;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Token {
    public String token;
    public String response;


    public Token(String response) {
        this.response = response;
    }


}