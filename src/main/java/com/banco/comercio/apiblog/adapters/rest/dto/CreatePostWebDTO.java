package com.banco.comercio.apiblog.adapters.rest.dto;

import lombok.Builder;

@Builder
public record CreatePostWebDTO(String title, String content) { }