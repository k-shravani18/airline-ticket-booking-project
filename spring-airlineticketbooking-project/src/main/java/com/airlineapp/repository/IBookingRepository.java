package com.airlineapp.repository;

import com.airlineapp.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
/**
 * @author shravani karupakala
 * @Date : 16-05-2022
 * @Project :spring-airlineticketbooking-project
 */

@Repository
public interface IBookingRepository extends JpaRepository<Booking,Integer> {
    @Query("from Booking b where b.bookingDate=?1")
    List<Booking> findByBookingDate(LocalDate bookingDate);
    @Query("from Booking b inner join b.flightSchedule s where s.source=?1")
    List<Booking> findBySource(String source);
    @Query("from Booking b inner join b.flightSchedule s where s.destination=?1")
    List<Booking> findByDestination(String destination);
    @Query("from Booking b inner join b.flightSchedule s where s.ticketCost=?1")
    List<Booking> findByTicketCost(double ticketCost);

    @Query("from Booking b inner join b.flightSchedule s where s.source=?1 and s.destination=?2")
    List<Booking> findBySourceAndDest(String source, String destination);

    @Query("from Booking b inner join b.flightSchedule s where s.scheduleId=?1")
    List<Booking>findByScheduleId(int scheduleId);
    @Query("from Booking b inner join b.passenger p where p.passengerId=?1")
    List<Booking>findByPassengerId(int passengerId);
    @Query("from Booking b where b.bookingDate between ?1 and ?2")
    List<Booking> findByActiveBookings(LocalDate bookingDate1,LocalDate bookingDate2);
}
