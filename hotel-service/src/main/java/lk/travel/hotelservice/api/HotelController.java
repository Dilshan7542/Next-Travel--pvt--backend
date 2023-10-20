package lk.travel.hotelservice.api;

import lk.travel.hotelservice.dto.HotelDTO;
import lk.travel.hotelservice.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotel")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @PostMapping
    public ResponseEntity<HotelDTO> saveHotel(@RequestBody HotelDTO hotelDTO) {
        return new ResponseEntity(hotelService.saveHotel(hotelDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<HotelDTO> updateHotel(@RequestBody HotelDTO hotelDTO) {
        return new ResponseEntity(hotelService.updateHotel(hotelDTO), HttpStatus.OK);
    }

    @PutMapping(path = "image", params = "hotelID", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<HotelDTO> updateImageHotel(@RequestPart byte[] image, @RequestParam int hotelID) {
        HotelDTO hotelDTO = hotelService.searchHotel(hotelID);
        hotelDTO.setImage(image);
        return new ResponseEntity(hotelDTO, HttpStatus.OK);
    }

    @GetMapping(path = "search", params = "hotelID")
    public ResponseEntity<HotelDTO> searchHotel(@RequestParam int hotelID) {
        return new ResponseEntity(hotelService.searchHotel(hotelID), HttpStatus.OK);
    }

    @DeleteMapping(params = "hotelID")
    public ResponseEntity<HotelDTO> deleteHotel(@RequestParam int hotelID) {
        return new ResponseEntity(hotelService.searchHotel(hotelID), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<HotelDTO>> getAllHotel() {
        return new ResponseEntity(hotelService.getAllHotel(), HttpStatus.OK);
    }

}
