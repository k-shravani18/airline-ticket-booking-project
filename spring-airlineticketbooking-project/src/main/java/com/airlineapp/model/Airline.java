package com.airlineapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
/**
 * @author shravani karupakala
 * @Date : 16-05-2022
 * @Project :spring-airlineticketbooking-project
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Airline {
    @Id
    @GeneratedValue(generator = "airline_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "airline_gen",sequenceName = "airline_sequence",initialValue = 1,allocationSize = 1)
    private Integer airlineId;
    @Column(length = 40)
    private String airlineName;
    private String headquarters;
    private int fleetSize;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "airline")
    private List<Flight> flights;

    public Airline(String airlineName, String headquarters, int fleetSize) {
        this.airlineName = airlineName;
        this.headquarters = headquarters;
        this.fleetSize = fleetSize;
    }
}
