package com.airlineapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
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
public class Passenger {
    @Id
    @GeneratedValue(generator = "passenger_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "passenger_gen",sequenceName = "passenger_sequence",initialValue = 1,allocationSize = 1)
    private Integer passengerId;
    @Column(length = 30)
    private String passengerName;
    @Column(length = 30)
    private String gender;
    private int age;
    private long phoneNo;

    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER,mappedBy = "passenger")
    private List<Booking> bookings;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    public Passenger(String passengerName, String gender, int age, long phoneNo, Address address) {
        this.passengerName = passengerName;
        this.gender = gender;
        this.age = age;
        this.phoneNo = phoneNo;
        this.address = address;
    }
}
