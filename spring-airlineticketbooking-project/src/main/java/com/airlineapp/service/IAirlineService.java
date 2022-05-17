package com.airlineapp.service;

import com.airlineapp.model.Airline;


import java.util.List;

/**
 * @author shravani karupakala
 * @Date : 16-05-2022
 * @Project :spring-airlineticketbooking-project
 */
public interface IAirlineService {
    Airline addAirline(Airline airlineName);
    void updateAirline(Airline airline);
    void deleteAirline(int airlineId);
    List<Airline> getAll();
    Airline getByAirlineId(int airlineId);

    List<Airline> getByAirlineHeadquarters(String headquarters);
}
