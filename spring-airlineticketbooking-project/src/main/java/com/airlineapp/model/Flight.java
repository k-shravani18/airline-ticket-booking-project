package com.airlineapp.model;

import lombok.*;
import org.hibernate.annotations.Cascade;

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
public class Flight {
    @Id
    @GeneratedValue(generator = "flight_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "flight_gen",sequenceName = "flight_sequence",initialValue = 100,allocationSize = 1)
    private Integer flightId;
    @Column(length = 40)
    private String flightName;
    private int capacity;
    private String stopType;
    private String classType;
    private  boolean food;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "airline_id")
    private  Airline airline;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "flight_id")
    private List<FlightSchedule> flightSchedules;

    public Flight(String flightName, int capacity, String stopType, String classType, boolean food, Airline airline, List<FlightSchedule> flightSchedules) {
        this.flightName = flightName;
        this.capacity = capacity;
        this.stopType = stopType;
        this.classType = classType;
        this.food = food;
        this.airline = airline;
        this.flightSchedules = flightSchedules;
    }
}
