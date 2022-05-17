package com.airlineapp.service;

import com.airlineapp.model.Passenger;
import com.airlineapp.repository.IPassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * @author shravani karupakala
 * @Date : 16-05-2022
 * @Project :spring-airlineticketbooking-project
 */

@Service
public class PassengerServiceImpl implements IPassengerService{
    private IPassengerRepository passengerRepository;

    @Autowired
    public void setPassengerRepository(IPassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public Passenger addPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public void updatePassenger(Passenger passenger) {
    passengerRepository.save(passenger);
    }

    @Override
    public void deletePassenger(int passengerId) {
    passengerRepository.deleteById(passengerId);
    }

    @Override
    public List<Passenger> getAll() {
        return passengerRepository.findAll();
    }

    @Override
    public Passenger getByPassengerId(int passengerId) {
        return passengerRepository.findById(passengerId).get();
    }

    @Override
    public Passenger getByPassengerName(String passengerName) {
        return passengerRepository.findByPassengerName(passengerName);
    }

    @Override
    public Passenger getByPassengerPhoneNo(long phoneNo) {
        return passengerRepository.findByPassengerPhoneNo(phoneNo);
    }

    @Override
    public Passenger getByAddressId(int addressId) {
        return passengerRepository.findByAddressId(addressId);
    }

    @Override
    public List<Passenger> getByCity(String city) {
        return passengerRepository.findByCity(city);
    }

    @Override
    public List<Passenger> getByState(String state) {
        return passengerRepository.findByState(state);
    }

    @Override
    public List<Passenger> getByZipcode(int zipcode) {
        return passengerRepository.findByZipcode(zipcode);
    }
}
