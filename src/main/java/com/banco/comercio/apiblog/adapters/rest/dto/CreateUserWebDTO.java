package com.banco.comercio.apiblog.adapters.rest.dto;

import com.banco.comercio.apiblog.adapters.postgres.models.UserEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateUserWebDTO {

    private String cellPhone;
    private String name;

    private String username;
    private String lastName;
    private String password;

    public UserEntity toUserEntity(CreateUserWebDTO createUserWebDTO){

        UserEntity user = new UserEntity();
        user.setName(createUserWebDTO.getName());
        user.setCellPhone(createUserWebDTO.getCellPhone());
        user.setUsername(createUserWebDTO.getUsername());
        user.setPassword(createUserWebDTO.getPassword());

        return user;
    }


}
