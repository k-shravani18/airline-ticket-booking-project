package com.airlineapp.service;

import com.airlineapp.model.Airline;
import com.airlineapp.model.Flight;
import com.airlineapp.repository.IFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
/**
 * @author shravani karupakala
 * @Date : 16-05-2022
 * @Project :spring-airlineticketbooking-project
 */

@Service
public class FlightServiceImpl implements IFlightService{
    private IFlightRepository flightRepository;

    @Autowired
    public void setFlightRepository(IFlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    /**
     * method is to add a fight detail into db
     * @param flight
     * @return one particular flight details
     */
    @Override
    @Transactional
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    /**
     *
     * @param flight
     */

    @Override
    public void updateFlight(Flight flight) {
    flightRepository.save(flight);
    }

    @Override
    public void deleteFlight(int flightId) {
    flightRepository.deleteById(flightId);
    }

    @Override
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    @Override
    public Flight getByFlightId(int flightId) {
        return flightRepository.findById(flightId).get();
    }

    @Override
    public List<Flight> getByFlightName(String flightName) {
        return flightRepository.findByFlightName(flightName);
    }

    @Override
    public List<Flight> getByAirlineName(String airlineName) {
        return flightRepository.findByAirlineName(airlineName);
    }


    @Override
    public List<Flight> getBySource(String source) {
        return flightRepository.findBySource(source);
    }

    @Override
    public List<Flight> getByDestination(String destination) {
        return flightRepository.findByDestination(destination);
    }

    @Override
    public List<Flight> getByArrivalTime(LocalDateTime arrivalTime) {
        return flightRepository.findByArrivalTime(arrivalTime);
    }

    @Override
    public List<Flight> getByDepartureTime(LocalDateTime departureTime) {
        return flightRepository.findByDepartureTime(departureTime);
    }

    @Override
    public List<Flight> getByTicketCost(double ticketCost) {
        return flightRepository.findByTicketCost(ticketCost);
    }

    @Override
    public List<Flight> getByDuration(String duration) {
        return flightRepository.findByDuration(duration);
    }

    @Override
    public List<Flight> getByDateOfJourney(LocalDate dateOfJourney) {
        return flightRepository.findByDateOfJourney(dateOfJourney);
    }

    @Override
    public Flight getByScheduleId(int scheduleId) {
        return flightRepository.findById(scheduleId).get();
    }

    @Override
    public List<Flight> getBySourceAndDest(String source, String destination) {
        return flightRepository.findBySourceAndDest(source,destination);
    }

    @Override
    public List<Flight> getByFlightNameAndSource(String flightName, String source) {
        return flightRepository.findByFlightNameAndSource(flightName,source);
    }

    @Override
    public List<Flight> getByStopType(String stopsType) {
        return flightRepository.findByStopType(stopsType);
    }

    @Override
    public List<Flight> getByFood(boolean food) {
        return flightRepository.findByFood(food);
    }


}
