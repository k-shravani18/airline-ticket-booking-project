package com.airlineapp.service;

import com.airlineapp.model.Flight;
import com.airlineapp.model.Passenger;

import java.util.List;
/**
 * @author shravani karupakala
 * @Date : 16-05-2022
 * @Project :spring-airlineticketbooking-project
 */

public interface IPassengerService {
    Passenger addPassenger(Passenger passenger);
    void updatePassenger(Passenger passenger);
    void deletePassenger(int passengerId);
    List<Passenger> getAll();
    Passenger getByPassengerId(int passengerId);

    Passenger getByPassengerName(String passengerName);
    Passenger getByPassengerPhoneNo(long phoneNo);

    Passenger getByAddressId(int addressId);
    List<Passenger> getByCity(String city);
    List<Passenger> getByState(String state);
    List<Passenger> getByZipcode(int zipcode);

}
