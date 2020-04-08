package com.sv.applaudo.studio.movies.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "movies")
public class Movies implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;
    @Column(name = "title")
    private String title;
    @Column(name = "stock")
    private int stock;
    @Column(name = "rental_price",precision = 8,scale = 2)
    private double rental_price;
    @Column(name = "sale_price",precision = 8,scale = 2)
    private double sale_price;
    @Column(name = "availability")
    private boolean availability;
    @Column(name = "popularity")
    private int popularity;


}
