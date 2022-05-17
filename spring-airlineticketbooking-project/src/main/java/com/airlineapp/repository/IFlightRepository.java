package com.airlineapp.repository;

import com.airlineapp.model.Airline;
import com.airlineapp.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
/**
 * @author shravani karupakala
 * @Date : 16-05-2022
 * @Project :spring-airlineticketbooking-project
 */

@Repository
public interface IFlightRepository extends JpaRepository<Flight,Integer> {
    @Query("from Flight f where f.flightName=?1")
    List<Flight> findByFlightName(String flightName);
    @Query("from Flight f inner join f.airline a where a.airlineName=?1")
    List<Flight> findByAirlineName(String airlineName);
    @Query("from Flight f where f.stopType=?1")
    List<Flight> findByStopType(String stopsType);
    @Query("from Flight f where f.food=?1")
    List<Flight> findByFood(boolean food);


    @Query("from Flight f inner join f.flightSchedules s where s.source=?1")
    List<Flight> findBySource(String source);
    @Query("from Flight f inner join f.flightSchedules s where s.destination=?1")
    List<Flight> findByDestination(String destination);
    @Query("from Flight f inner join f.flightSchedules s where s.ticketCost=?1")
    List<Flight> findByTicketCost(double ticketCost);
    @Query("from Flight f inner join f.flightSchedules s where s.duration=?1")
    List<Flight> findByDuration(String duration);
    @Query("from Flight f inner join f.flightSchedules s where s.arrivalTime=?1")
    List<Flight> findByArrivalTime(LocalDateTime arrivalTime);
    @Query("from Flight f inner join f.flightSchedules s where s.departureTime=?1")
    List<Flight> findByDepartureTime(LocalDateTime departureTime);
    @Query("from Flight f inner join f.flightSchedules s where s.dateOfJourney=?1")
    List<Flight> findByDateOfJourney(LocalDate dateOfJourney);
    @Query("from Flight f inner join f.flightSchedules s where s.scheduleId=?1")
    Flight findByScheduleId(int scheduleId);

    @Query("from Flight f inner join f.flightSchedules s where s.source=?1 and s.destination=?2")
    List<Flight> findBySourceAndDest(String source,String destination);
    @Query("from Flight f inner join f.flightSchedules s where f.flightName=?1 and s.source=?2")
    List<Flight> findByFlightNameAndSource(String flightName, String source);

}
