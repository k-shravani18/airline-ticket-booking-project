package com.airlineapp.service;

import com.airlineapp.model.Airline;
import com.airlineapp.model.Flight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
/**
 * @author shravani karupakala
 * @Date : 16-05-2022
 * @Project :spring-airlineticketbooking-project
 */

public interface IFlightService {
    Flight addFlight(Flight flight);
    void updateFlight(Flight flight);
    void deleteFlight(int flightId);
    List<Flight> getAll();

    Flight getByFlightId(int flightId);
    List<Flight> getByFlightName(String flightName);
    List<Flight> getByStopType(String stopsType);
    List<Flight> getByFood(boolean food);

    List<Flight> getByAirlineName(String airlineName);

    List<Flight> getBySource(String source);
    List<Flight> getByDestination(String destination);
    List<Flight> getByArrivalTime(LocalDateTime arrivalTime);
    List<Flight> getByDepartureTime(LocalDateTime departureTime);
    List<Flight> getByTicketCost(double ticketCost);
    List<Flight> getByDuration(String duration);
    List<Flight> getByDateOfJourney(LocalDate dateOfJourney);
    Flight getByScheduleId(int scheduleId);

    List<Flight> getBySourceAndDest(String source,String destination);
    List<Flight> getByFlightNameAndSource(String flightName, String source);
}
