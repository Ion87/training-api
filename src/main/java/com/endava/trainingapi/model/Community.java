package com.endava.trainingapi.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "communities")
@EqualsAndHashCode(exclude = {"id"})
public class Community {

    @Id
    @Column(name = "id", columnDefinition = "VARCHAR(36) NOT NULL")
    @GeneratedValue
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "name")
    private String name;

}
