package lk.travel.bookingservice.repo;

import lk.travel.bookingservice.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking,Integer> {
}
