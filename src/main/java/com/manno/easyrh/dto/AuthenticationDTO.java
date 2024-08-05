package com.manno.easyrh.dto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record AuthenticationDTO(
        String username,
        String password
) {}
