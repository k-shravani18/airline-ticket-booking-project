package com.airlineapp.service;

import com.airlineapp.model.Booking;
import com.airlineapp.repository.IBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
/**
 * @author shravani karupakala
 * @Date : 16-05-2022
 * @Project :spring-airlineticketbooking-project
 */

@Service
public class BookingServiceImpl implements IBookingService{
    private IBookingRepository bookingRepository;

    @Autowired
    public void setBookingRepository(IBookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public void updateBooking(Booking booking) {
    bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(int bookingId) {
    bookingRepository.deleteById(bookingId);
    }

    @Override
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getByBookingId(int bookingId) {
        return bookingRepository.findById(bookingId).get();
    }

    @Override
    public List<Booking> getByBookingDate(LocalDate bookingDate) {
        return bookingRepository.findByBookingDate(bookingDate);
    }

    @Override
    public List<Booking> getBySource(String source) {
        return bookingRepository.findBySource(source);
    }

    @Override
    public List<Booking> getByDestination(String destination) {
        return bookingRepository.findByDestination(destination);
    }

    @Override
    public List<Booking> getByTicketCost(double ticketCost) {
        return bookingRepository.findByTicketCost(ticketCost);
    }

    @Override
    public List<Booking> getBySourceAndDest(String source, String destination) {
        return bookingRepository.findBySourceAndDest(source,destination);
    }

    @Override
    public List<Booking> getByScheduleId(int scheduleId) {
        return bookingRepository.findByScheduleId(scheduleId);
    }

    @Override
    public List<Booking> getByPassengerId(int passengerId) {
        return bookingRepository.findByPassengerId(passengerId);
    }

    @Override
    public List<Booking> getByActiveBookings(LocalDate bookingDate1,LocalDate bookingDate2) {
        return bookingRepository.findByActiveBookings( bookingDate1,bookingDate2);
    }

}
