package com.airlineapp.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
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
public class FlightSchedule {
    @Id
    @GeneratedValue(generator = "schedule_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "schedule_gen",sequenceName = "schedule_sequence",initialValue = 1,allocationSize = 1)
    private Integer scheduleId;
    @Column(length = 40)
    private String source;
    @Column(length = 40)
    private String destination;
    private LocalDate dateOfJourney;
    private double ticketCost;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;
    private String duration;
    @ToString.Exclude
    @OneToMany(cascade =CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "flightSchedule")
    private Set<Booking> bookings;


    public FlightSchedule(String source, String destination, LocalDate dateOfJourney, double ticketCost, LocalDateTime arrivalTime, LocalDateTime departureTime, String duration, Set<Booking> bookings) {
        this.source = source;
        this.destination = destination;
        this.dateOfJourney = dateOfJourney;
        this.ticketCost = ticketCost;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.duration = duration;
        this.bookings = bookings;
    }
}

