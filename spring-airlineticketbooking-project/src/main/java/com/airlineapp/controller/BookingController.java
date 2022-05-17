package com.airlineapp.controller;

import com.airlineapp.model.Booking;
import com.airlineapp.model.Booking;
import com.airlineapp.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
/**
 * @author shravani karupakala
 * @Date : 16-05-2022
 * @Project :spring-airlineticketbooking-project
 */

@RestController
@RequestMapping("/booking-api")
public class BookingController {
    private IBookingService bookingService;

    @Autowired
    public void setBookingService(IBookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/bookings")
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking){
        bookingService.addBooking(booking);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/bookings")
    public ResponseEntity<Void> updateBooking(@RequestBody Booking booking){
        bookingService.updateBooking(booking);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @DeleteMapping("/bookings/bookingId/{bookingId}")
    public ResponseEntity<Void> deleteBooking(@PathVariable("bookingId") int bookingId){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","delete booking by id");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();

    }
    //http://localhost:8081/booking-api/bookings
    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getAll(){
        List<Booking> bookings=bookingService.getAll();
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","getting all bookings");
        headers.add("info","get all method called");
        ResponseEntity<List<Booking>> bookingResponse=new ResponseEntity(bookings,headers,HttpStatus.OK);
        return bookingResponse;
    }


    //http://localhost:8081/booking-api/bookings/bookingId
    @GetMapping("bookings/bookingId/{bookingId}")
    public ResponseEntity<Booking> getByBookingId(@PathVariable("bookingId") int bookingId){
        Booking booking= bookingService.getByBookingId(bookingId);
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","get by id");
        return ResponseEntity.ok().headers(headers).body(booking);

    }
    //http://localhost:8081/booking-api/bookings/bookingDate
    @GetMapping("bookings/bookingDate/{bookingDate}")
   ResponseEntity<List<Booking>> getByBookingDate(@PathVariable("bookingDate") LocalDate bookingDate){
       List<Booking> bookings= bookingService.getByBookingDate(bookingDate);
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","get by booking date");
        return ResponseEntity.ok().headers(headers).body(bookings);
    }
    //http://localhost:8081/booking-api/bookings/source
    @GetMapping("bookings/source/{source}")
    ResponseEntity<List<Booking>> getBySource(@PathVariable("source") String source){
        List<Booking> bookings= bookingService.getBySource(source);
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","get by source");
        return ResponseEntity.ok().headers(headers).body(bookings);
    }
    //http://localhost:8081/booking-api/bookings/destination
    @GetMapping("bookings/destination/{destination}")
    ResponseEntity<List<Booking>> getByDestination(@PathVariable("destination") String destination){
        List<Booking> bookings= bookingService.getByDestination(destination);
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","get by destination");
        return ResponseEntity.ok().headers(headers).body(bookings);
    }
    //http://localhost:8081/booking-api/bookings/ticketCost
    @GetMapping("bookings/ticketCost/{ticketCost}")
    ResponseEntity<List<Booking>> getByTicketCost(@PathVariable("ticketCost") double ticketCost){
        List<Booking> bookings= bookingService.getByTicketCost(ticketCost);
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","get by ticketCost");
        return ResponseEntity.ok().headers(headers).body(bookings);
    }
    //http://localhost:8081/booking-api/bookings/source/destination
    @GetMapping("bookings/source/{source}/destination/{destination}")
    ResponseEntity<List<Booking>> getBySourceAndDest(@PathVariable("source") String source,@PathVariable("destination") String destination){
        List<Booking> bookings= bookingService.getBySourceAndDest(source,destination);
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","get by source"+source+"destination"+destination);
        return ResponseEntity.ok().headers(headers).body(bookings);
    }
    //http://localhost:8081/booking-api/bookings/scheduleId
    @GetMapping("bookings/scheduleId/{scheduleId}")
    ResponseEntity<List<Booking>> getByScheduleId(@PathVariable("scheduleId") int scheduleId){
        List<Booking> bookings= bookingService.getByScheduleId(scheduleId);
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","get by scheduleId");
        return ResponseEntity.ok().headers(headers).body(bookings);
    }
    //http://localhost:8081/booking-api/bookings/passengerId
    @GetMapping("bookings/passengerId/{passengerId}")
    ResponseEntity<List<Booking>> getByPassengerId(@PathVariable("passengerId") int passengerId){
        List<Booking> bookings= bookingService.getByPassengerId(passengerId);
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","get by passengerId");
        return ResponseEntity.ok().headers(headers).body(bookings);
    }
    //http://localhost:8081/booking-api/bookings/bookingDate1/bookingDate2
    @GetMapping("bookings/bookingDate1/{bookingDate1}/bookingDate2/{bookingDate2}")
    ResponseEntity<List<Booking>> getByActiveBookings(@PathVariable("bookingDate1") LocalDate bookingDate1,@PathVariable("bookingDate1")LocalDate bookingDate2){
        List<Booking> bookings= bookingService.getByActiveBookings(bookingDate1,bookingDate2);
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","get by bookingDate");
        return ResponseEntity.ok().headers(headers).body(bookings);
    }
}
