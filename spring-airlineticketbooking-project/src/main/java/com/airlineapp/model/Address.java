package com.airlineapp.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author shravani karupakala
 * @Date : 17-05-2022
 * @Project :spring-airlineticketbooking-project
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Address {
    @Id
    @GeneratedValue(generator = "address_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "address_gen",sequenceName = "address_sequence",initialValue = 1,allocationSize = 1)
    private Integer addressId;
    private String city;
    private String state;
    private int zipcode;

    public Address(String city, String state, int zipcode) {
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
}
