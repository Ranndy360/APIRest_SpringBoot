package com.sv.applaudo.studio.movies.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "rental")
public class Rental implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movies_id", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private Movies movies_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @Fetch(FetchMode.JOIN)
    private Users user_id;
    @Column(name = "quantity")
    private String quantity;
    @Column(name = "rental_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rental_date;
    @Column(name = "return_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date return_date;
    @Column(name = "total")
    private double total;
    @Column(name = "penality")
    private double penality;
    @Column(name = "state")
    private String state;

}
