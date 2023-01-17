package com.banco.comercio.apiblog.adapters.rest.dto;

import lombok.Builder;

@Builder
public record PostWebDTO(Long id ,String title, String content) { }