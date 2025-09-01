package com.aedev.AdemFlix.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)
@Data
@Entity
@NoArgsConstructor
public class Movie extends BaseEntity{
    private String title;
    private String genre; //enum'a çevir
    //private String director; //director özel class'ı
    //private List bla bla actors <-- bunu deneyebiliriz, many to many join column gerektirir
    private String summary;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "movie_director",
        joinColumns = @JoinColumn(name = "movie_id"),
        inverseJoinColumns = @JoinColumn(name = "director_id")
    )
    @JsonIgnoreProperties("movies")
    @JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
    )
    private List<Director> directors;

}
