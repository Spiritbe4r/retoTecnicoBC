package com.banco.comercio.apiblog.adapters.postgres.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -90000027L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "updatedBy")
    @LastModifiedBy
    private String updatedBy;

    @Column(name = "updatedOn")
    @LastModifiedDate
    private LocalDateTime updatedOn;

}