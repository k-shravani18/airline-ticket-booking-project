package com.airlineapp.controller;

import com.airlineapp.model.Airline;
import com.airlineapp.model.Flight;
import com.airlineapp.service.IAirlineService;
import com.airlineapp.service.IFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
/**
 * @author shravani karupakala
 * @Date : 16-05-2022
 * @Project :spring-airlineticketbooking-project
 */

@RestController
@RequestMapping("/flight-api")
public class FlightController {
    private IFlightService flightService;
    @Autowired
    public FlightController(IFlightService flightService) {
        this.flightService = flightService;
    }

    private IAirlineService iAirlineService;
    @Autowired
    public void setiAirlineService(IAirlineService iAirlineService) {
        this.iAirlineService = iAirlineService;
    }

    @PostMapping("/flights")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight){
        flightService.addFlight(flight);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/flights")
    public ResponseEntity<Void> updateFlight(@RequestBody Flight flight){
        flightService.updateFlight(flight);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @DeleteMapping("/flights/flightId/{flightId}")
    public ResponseEntity<Void> deleteFlight(@PathVariable("flightId") int flightId){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","delete flight by id");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();

    }
    //http://localhost:8081/flight-api/flights
    @GetMapping("/flights")
    public ResponseEntity<List<Flight>> getAll(){
        List<Flight> flights=flightService.getAll();
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","getting all flights");
        headers.add("info","get all method called");
        ResponseEntity<List<Flight>> flightResponse=new ResponseEntity(flights,headers,HttpStatus.OK);
        return flightResponse;
    }


    //http://localhost:8081/flight-api/flights/flightId
    @GetMapping("flights/flightId/{flightId}")
    public ResponseEntity<Flight> getByFlightId(@PathVariable("flightId") int flightId){
        Flight flight= flightService.getByFlightId(flightId);
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","get by id");
        return ResponseEntity.ok().headers(headers).body(flight);

    }
    //http://localhost:8081/flight-api/flights/flightName
    @GetMapping("flights/flightName/{flightName}")
    public ResponseEntity<List<Flight>> getByFlightName(@PathVariable("flightName") String flightName){
        List<Flight> flights= flightService.getByFlightName(flightName);
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","get by flight name");
        return  ResponseEntity.ok().headers(headers).body(flights);
    }
    //http://localhost:8081/flight-api/flights/stopType
    @GetMapping("flights/stopType/{stopType}")
    ResponseEntity<List<Flight>> getByStopType(@PathVariable("stopType") String stopType) {
        List<Flight> flights =flightService.getByStopType(stopType);
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","get by stopType");
        return ResponseEntity.ok().headers(headers).body(flights);
    }
    //http://localhost:8081/flight-api/flights/food
    @GetMapping("flights/food/{food}")
    ResponseEntity<List<Flight>> getByFood(@PathVariable("food") boolean food){
        List<Flight> flights =flightService.getByFood(food);
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","get by food");
        return ResponseEntity.ok().headers(headers).body(flights);
    }
    //http://localhost:8081/flight-api/flights/airlineName
    @GetMapping("flights/airlineName/{airlineName}")
    ResponseEntity<List<Flight>> getByAirlineName(@PathVariable("airlineName") String airlineName){
        List<Flight> flights =flightService.getByAirlineName(airlineName);
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","get by airlineName");
        return ResponseEntity.ok().headers(headers).body(flights);
    }
    //http://localhost:8081/flight-api/flights/source
    @GetMapping("flights/source/{source}")
    ResponseEntity<List<Flight>> getBySource(@PathVariable("source") String source){
        List<Flight> flights =flightService.getBySource(source);
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","get by source");
        return ResponseEntity.ok().headers(headers).body(flights);
    }
    //http://localhost:8081/flight-api/flights/destination
    @GetMapping("flights/destination/{destination}")
    ResponseEntity<List<Flight>> getByDestination(@PathVariable("destination") String destination){
        List<Flight> flights =flightService.getByDestination(destination);
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","get by destination");
        return ResponseEntity.ok().headers(headers).body(flights);
    }
    //http://localhost:8081/flight-api/flights/arrivalTime
    @GetMapping("flights/arrivalTime/{arrivalTime}")
    ResponseEntity<List<Flight>> getByArrivalTime(@PathVariable("arrivalTime") LocalDateTime arrivalTime){
        List<Flight> flights =flightService.getByArrivalTime(arrivalTime);
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","get by arrivalTime");
        return ResponseEntity.ok().headers(headers).body(flights);
    }
    //http://localhost:8081/flight-api/flights/departureTime
    @GetMapping("flights/departureTime/{departureTime}")
    ResponseEntity<List<Flight>> getByDepartureTime(@PathVariable("departureTime") LocalDateTime departureTime){
        List<Flight> flights =flightService.getByDepartureTime(departureTime);
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","get by departureTime");
        return ResponseEntity.ok().headers(headers).body(flights);
    }
    //http://localhost:8081/flight-api/flights/ticketCost
    @GetMapping("flights/ticketCost/{ticketCost}")
    ResponseEntity<List<Flight>> getByTicketCost(@PathVariable("ticketCost") double ticketCost){
        List<Flight> flights =flightService.getByTicketCost(ticketCost);
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","get by ticketCost");
        return ResponseEntity.ok().headers(headers).body(flights);
    }
    //http://localhost:8081/flight-api/flights/duration
    @GetMapping("flights/duration/{duration}")
    ResponseEntity<List<Flight>> getByDuration(@PathVariable("duration") String duration){
        List<Flight> flights =flightService.getByDuration(duration);
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","get by duration");
        return ResponseEntity.ok().headers(headers).body(flights);
    }
    //http://localhost:8081/flight-api/flights/dateOfJourney
    @GetMapping("flights/dateOfJourney/{dateOfJourney}")
    ResponseEntity<List<Flight>> getByDateOfJourney(@PathVariable("dateOfJourney") LocalDate dateOfJourney){
        List<Flight> flights =flightService.getByDateOfJourney(dateOfJourney);
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","get by duration");
        return ResponseEntity.ok().headers(headers).body(flights);
    }
    //http://localhost:8081/flight-api/flights/scheduleId
    @GetMapping("flights/scheduleId/{scheduleId}")
    ResponseEntity<Flight> getByScheduleId(@PathVariable("scheduleId") int scheduleId){
        Flight flight=flightService.getByScheduleId(scheduleId);
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","get by scheduleId");
        return ResponseEntity.ok().headers(headers).body(flight);

    }
    //http://localhost:8081/flight-api/flights/source/destination
    @GetMapping("flights/source/{source}/destination/{destination}")
    ResponseEntity<List<Flight>> getBySourceAndDest(@PathVariable("source") String source,@PathVariable("destination") String destination){
        List<Flight> flights =flightService.getBySourceAndDest(source,destination);
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","get by source"+source+"destination"+destination);
        return ResponseEntity.ok().headers(headers).body(flights);
    }
    //http://localhost:8081/flight-api/flights/flightName/source
    @GetMapping("flights/flightName/{flightName}/source/{source}")
    ResponseEntity<List<Flight>> getByFlightNameAndSource(@PathVariable("flightName") String flightName,@PathVariable("source") String source){
        List<Flight> flights =flightService.getByFlightNameAndSource(flightName,source);
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","get by flightName"+flightName+"source"+source);
        return ResponseEntity.ok().headers(headers).body(flights);
    }
    //http://localhost:8081/flight-api/flights/headquarters
    @GetMapping("flights/headquarters/{headquarters}")
    ResponseEntity<List<Airline>> getByAirlineHeadquarters(@PathVariable("headquarters") String headquarters){
        List<Airline> airlines =iAirlineService.getByAirlineHeadquarters(headquarters);
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc","get by airline headqurters");
        return ResponseEntity.ok().headers(headers).body(airlines);
    }


}
