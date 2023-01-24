package com.jpa.restful.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "language")
public class Language extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer language_id;

    @Column(length = 20)
    private String name;

    @Builder
    public Language(Integer language_id, String name) {
        this.language_id = language_id;
        this.name = name;

    }
}