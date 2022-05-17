package com.airlineapp.service;

import com.airlineapp.model.Booking;
import com.airlineapp.model.Flight;
import com.airlineapp.model.Passenger;

import java.time.LocalDate;
import java.util.List;
/**
 * @author shravani karupakala
 * @Date : 16-05-2022
 * @Project :spring-airlineticketbooking-project
 */

public interface IBookingService {
    Booking addBooking(Booking booking);
    void updateBooking(Booking booking);
    void deleteBooking(int bookingId);
    List<Booking> getAll();
    Booking getByBookingId(int bookingId);

    List<Booking> getByBookingDate(LocalDate bookingDate);
    List<Booking> getBySource(String source);
    List<Booking> getByDestination(String destination);
    List<Booking> getByTicketCost(double ticketCost);

    List<Booking> getBySourceAndDest(String source, String destination);

    List<Booking>getByScheduleId(int scheduleId);
    List<Booking>getByPassengerId(int passengerId);
    List<Booking> getByActiveBookings(LocalDate bookingDate1,LocalDate bookingDate2);
}
