package com.banco.comercio.apiblog.domain.dto;

import com.banco.comercio.apiblog.adapters.rest.dto.CreateUserWebDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDTO {

    private String cellPhone;
    private String name;
    private String lastName;
    private String username;

    UserDTO toUserDTO(CreateUserWebDTO createUserWebDTO){
        return UserDTO.builder().name(createUserWebDTO.getName())
                .cellPhone(createUserWebDTO.getCellPhone())
                .lastName(createUserWebDTO.getLastName())
                .username(createUserWebDTO.getUsername()).build();

    }
}
