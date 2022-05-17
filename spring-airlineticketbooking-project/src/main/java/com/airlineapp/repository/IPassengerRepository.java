package com.airlineapp.repository;

import com.airlineapp.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @author shravani karupakala
 * @Date : 16-05-2022
 * @Project :spring-airlineticketbooking-project
 */

@Repository
public interface IPassengerRepository extends JpaRepository<Passenger,Integer> {
    @Query("from Passenger p where p.passengerName=?1")
    Passenger findByPassengerName(String passengerName);
    @Query("from Passenger p where p.phoneNo=?1")
    Passenger findByPassengerPhoneNo(long phoneNo);

    @Query("from Passenger p inner join p.address a where a.addressId=?1")
    Passenger findByAddressId(int addressId);
    @Query("from Passenger p inner join p.address a where a.city=?1")
    List<Passenger> findByCity(String city);
    @Query("from Passenger p inner join p.address a where a.state=?1")
    List<Passenger> findByState(String state);
    @Query("from Passenger p inner join p.address a where a.zipcode=?1")
    List<Passenger> findByZipcode(int zipcode);
}
