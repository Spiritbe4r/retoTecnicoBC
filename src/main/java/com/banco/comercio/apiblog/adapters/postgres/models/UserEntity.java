package com.banco.comercio.apiblog.adapters.postgres.models;

import com.banco.comercio.apiblog.adapters.rest.dto.UserResponseDTO;
import com.banco.comercio.apiblog.adapters.rest.dto.UserWebDTO;
import com.banco.comercio.apiblog.config.enums.UserRoles;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends BaseEntity  {

    private String cellPhone;
    private String name;
    private String lastName;
    private String username;

    private String email;
    private String password;

    private Boolean enabled=true;

    //@ElementCollection
    private List<UserRoles> roles;

    @OneToMany(mappedBy="user")
    private List<PostEntity> posts;

    public UserWebDTO toUserWebDTO() {
        return UserWebDTO.builder()
                .name(name)
                .lastName(lastName)
                .cellPhone(cellPhone)
                .username(username).build();


    }

    public UserResponseDTO toUserResponseDTO() {
        return UserResponseDTO.builder().id(getId())
                .email(email)
                .name(name)
                .lastName(lastName)
                .roles(roles.stream().toList()).build();
    }

}
