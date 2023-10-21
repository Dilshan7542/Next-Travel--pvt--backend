package lk.travel.bookingservice.service;

import lk.travel.bookingservice.dto.BookingDTO;
import lk.travel.bookingservice.dto.GuideDTO;

import java.util.List;

public interface BookingService {
    BookingDTO saveBooking(BookingDTO bookingDTO);
    BookingDTO updateBooking(BookingDTO bookingDTO);
    BookingDTO searchBooking(int bookingID);
    void deleteBooking(int bookingID);
    List<BookingDTO> getAllBooking();
}
