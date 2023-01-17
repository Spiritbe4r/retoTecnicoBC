
package com.banco.comercio.apiblog.config.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum UserRoles {
    ROLE_USER("ROLE_USER"),
    ROLE_ADMIN("ROLE_ADMIN");

    private final String name;

    UserRoles (String name) {
        this.name = name;
    }

    public static String getRoleByName(String name) {


        return Arrays.stream(UserRoles.values()).map(UserRoles::getName).filter(xName -> xName.equalsIgnoreCase(name)).
                findFirst().orElse(null);

    }
}
