package com.banco.comercio.apiblog.adapters.rest.dto;

import lombok.Builder;

//@Getter
@Builder
public record LoginDto(
        String email,
        String password)
{ }
