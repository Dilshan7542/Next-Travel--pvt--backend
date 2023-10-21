package lk.travel.bookingservice.api;

import lk.travel.bookingservice.dto.BookingDTO;
import lk.travel.bookingservice.service.BookingService;
import lk.travel.customerservice.dto.CustomerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@RestController
@RequestMapping("/api/v1/booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;
    @PostMapping
    public ResponseEntity<BookingDTO> saveHotel(@RequestBody BookingDTO bookingDTO) {
        return new ResponseEntity(bookingService.saveBooking(bookingDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<BookingDTO> updateHotel(@RequestBody BookingDTO bookingDTO) {
        return new ResponseEntity(bookingService.updateBooking(bookingDTO), HttpStatus.OK);
    }



    @GetMapping(path = "search", params = "bookingID")
    public ResponseEntity<BookingDTO> searchHotel(@RequestParam int bookingID) {
        return new ResponseEntity(bookingService.searchBooking(bookingID), HttpStatus.OK);
    }

    @DeleteMapping(params = "bookingID")
    public ResponseEntity<BookingDTO> deleteHotel(@RequestParam int bookingID) {
        bookingService.deleteBooking(bookingID);
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BookingDTO>> getAllHotel() {
        return new ResponseEntity(bookingService.getAllBooking(), HttpStatus.OK);
    }
}
