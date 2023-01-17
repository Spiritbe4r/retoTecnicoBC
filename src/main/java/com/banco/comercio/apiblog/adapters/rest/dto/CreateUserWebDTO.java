package com.banco.comercio.apiblog.adapters.rest.dto;

import com.banco.comercio.apiblog.adapters.postgres.models.UserEntity;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserWebDTO {

    private String cellPhone;
    private String name;

    private String email;
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
