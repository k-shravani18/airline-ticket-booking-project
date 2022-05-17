package com.airlineapp.repository;

import com.airlineapp.model.Airline;
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
public interface IAirlineRepository extends JpaRepository<Airline,Integer> {

    @Query("from Airline a where a.headquarters=?1")
    List<Airline> findByAirlineHeadquarters(String headquarters);
//    findByFlightName;
}
