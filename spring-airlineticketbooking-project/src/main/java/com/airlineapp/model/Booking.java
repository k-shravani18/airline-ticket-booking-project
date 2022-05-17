package com.airlineapp.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
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

public class Booking {
    @Id
    @GeneratedValue(generator = "booking_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "booking_gen",sequenceName = "booking_sequence",initialValue = 1,allocationSize = 1)
    private Integer bookingId;
    private int noOfPersons;
    private LocalDate bookingDate;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "schedule_id")
    private FlightSchedule flightSchedule;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    public Booking(int noOfPersons, LocalDate bookingDate, Passenger passenger) {
        this.noOfPersons = noOfPersons;
        this.bookingDate = bookingDate;
        this.passenger = passenger;
    }
}



