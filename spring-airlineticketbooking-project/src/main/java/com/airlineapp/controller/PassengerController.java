package com.airlineapp.controller;

import com.airlineapp.model.Passenger;
import com.airlineapp.model.Passenger;
import com.airlineapp.service.IPassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author shravani karupakala
 * @Date : 16-05-2022
 * @Project :spring-airlineticketbooking-project
 */

@RestController
@RequestMapping("/passenger-api")
public class PassengerController {
    private IPassengerService passengerService;

    @Autowired
    public void setPassengerService(IPassengerService passengerService) {
        this.passengerService = passengerService;
    }
    @PostMapping("/passengers")
    public ResponseEntity<Passenger> addPassenger(@RequestBody Passenger passenger){
        passengerService.addPassenger(passenger);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/passengers")
    public ResponseEntity<Void> updatePassenger(@RequestBody Passenger passenger){
        passengerService.updatePassenger(passenger);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @DeleteMapping("/passengers/passengerId/{passengerId}")
    public ResponseEntity<Void> deletePassenger(@PathVariable("passengerId") int passengerId){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","delete passenger by id");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();

    }
    //http://localhost:8080/passenger-api/passengers
    @GetMapping("/passengers")
    public ResponseEntity<List<Passenger>> getAll(){
        List<Passenger> passengers=passengerService.getAll();
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","getting all passengers");
        headers.add("info","get all method called");
        ResponseEntity<List<Passenger>> passengerResponse=new ResponseEntity(passengers,headers,HttpStatus.OK);
        return passengerResponse;
    }


    //http://localhost:8080/passenger-api/passengers/passengerId
    @GetMapping("passengers/passengerId/{passengerId}")
    public ResponseEntity<Passenger> getByPassengerId(@PathVariable("passengerId") int passengerId){
        Passenger passenger= passengerService.getByPassengerId(passengerId);
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","get by id");
        return ResponseEntity.ok().headers(headers).body(passenger);

    }
    
    //http://localhost:8081/passenger-api/passengers/passengerName
    @GetMapping("passengers/passengerName/{passengerName}")
    ResponseEntity<Passenger> getByPassengerName(@PathVariable("passengerName") String passengerName){
        Passenger passenger= passengerService.getByPassengerName(passengerName);
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","get by passenger name");
        return ResponseEntity.ok().headers(headers).body(passenger);
        }

    //http://localhost:8081/passenger-api/passengers/phoneNo
    @GetMapping("passengers/phoneNo/{phoneNo}")
    ResponseEntity<Passenger> getByPassengerPhoneNo(long phoneNo){
        Passenger passenger= passengerService.getByPassengerPhoneNo(phoneNo);
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","get by passenger phoneNo");
        return ResponseEntity.ok().headers(headers).body(passenger);
    }

    //http://localhost:8081/passenger-api/passengers/addressId
    @GetMapping("passengers/addressId/{addressId}")
    ResponseEntity<Passenger> getByAddressId(@PathVariable("addressId") int addressId){
        Passenger passenger= passengerService.getByAddressId(addressId);
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","get by addressId");
        return ResponseEntity.ok().headers(headers).body(passenger);
    }

    //http://localhost:8081/passenger-api/passengers/city
    @GetMapping("passengers/city/{city}")
    ResponseEntity<List<Passenger>> getByCity(String city){
        List<Passenger> passengers=passengerService.getByCity(city);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","get by city");
        return ResponseEntity.ok().headers(headers).body(passengers);
    }

    //http://localhost:8081/passenger-api/passengers/state
    @GetMapping("passengers/state/{state}")
    ResponseEntity<List<Passenger>> getByState(String state){
        List<Passenger> passengers=passengerService.getByState(state);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","get by state");
        return ResponseEntity.ok().headers(headers).body(passengers);
    }

    //http://localhost:8081/passenger-api/passengers/zipcode
    @GetMapping("passengers/zipcode/{zipcode}")
    ResponseEntity<List<Passenger>> getByZipcode(int zipcode){
        List<Passenger> passengers=passengerService.getByZipcode(zipcode);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","get by zipcode");
        return ResponseEntity.ok().headers(headers).body(passengers);
    }
}
