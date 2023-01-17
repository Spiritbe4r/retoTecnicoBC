package com.banco.comercio.apiblog.domain.entities;

import com.banco.comercio.apiblog.adapters.rest.dto.PostWebDTO;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Post {

    private String title;
    private String content;

    public PostWebDTO toPostWebDTO() {
        return PostWebDTO.builder().content(content)
                .title(title).build();

    }

}
