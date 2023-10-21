package lk.travel.customerservice.api;

import lk.travel.customerservice.dto.CustomerDTO;
import lk.travel.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
   private final CustomerService customerService;
    @PostMapping
    public ResponseEntity<CustomerDTO> saveTravelCategory(@RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<>(customerService.saveCustomer(customerDTO), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CustomerDTO> updateTravelCategory(@RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<>(customerService.updateCustomer(customerDTO), HttpStatus.OK);
    }

    @GetMapping(path = "search", params = "customerID")
    public ResponseEntity<CustomerDTO> searchTravelCategory(@RequestParam int customerID) {
        return new ResponseEntity<>(customerService.searchCustomer(customerID), HttpStatus.OK);
    }

    @DeleteMapping(params = "customerID")
    public ResponseEntity<CustomerDTO> deleteTravelCategory(@RequestParam int customerID) {
        customerService.deleteCustomer(customerID);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllTravelCategory() {
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }
}
