package com.banco.comercio.apiblog.adapters.rest.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthResponse {

    private String authToken;
   /* private String email;
    private String userId;*/
}
