package lk.travel.vehicleservice.api;

import jakarta.persistence.EntityManager;
import lk.travel.vehicleservice.dto.VehicleBrandDTO;
import lk.travel.vehicleservice.dto.VehicleCategoryDTO;
import lk.travel.vehicleservice.entity.VehicleBrand;
import lk.travel.vehicleservice.entity.VehicleCategory;
import lk.travel.vehicleservice.repo.VehicleBrandRepo;
import lk.travel.vehicleservice.repo.VehicleCategoryRepo;
import lk.travel.vehicleservice.service.VehicleBrandService;
import lk.travel.vehicleservice.util.ImageUtility;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/vehicle/brand")
@RequiredArgsConstructor
public class VehicleBrandController {
    private final VehicleBrandService vehicleBrandService;


    @PostMapping
    public ResponseEntity<VehicleBrandDTO> saveVehicleBrand(@RequestBody VehicleBrandDTO vehicleBrandDTO) {
        return new ResponseEntity<>(vehicleBrandService.saveVehicleBrand(vehicleBrandDTO), HttpStatus.OK);
    }

    @PostMapping(path = "image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<VehicleBrandDTO> saveWithImageVehicleBrand(
            @RequestPart int vehicleID,
            @RequestPart String brandName,
            @RequestPart int seat,
            @RequestPart double fee1Day,
            @RequestPart double fee1KM,
            @RequestPart double fuel1KM,
            @RequestPart byte[] image,
            @RequestPart int vehicleCategoryID
    ) {
        return new ResponseEntity<>(vehicleBrandService.saveVehicleBrand(
                new VehicleBrandDTO(vehicleID, brandName, seat, fee1Day, fee1KM, fuel1KM,image, new VehicleCategoryDTO(vehicleCategoryID)))
                , HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<VehicleBrandDTO> updateVehicleBrand(@RequestBody VehicleBrandDTO vehicleBrandDTO) {
        return new ResponseEntity<>(vehicleBrandService.updateVehicleBrand(vehicleBrandDTO), HttpStatus.OK);
    }

    @PutMapping(path = "image", params = "vehicleBrandID",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<VehicleBrandDTO> uploadImageVehicleBrand(@RequestPart MultipartFile multipartFile, @RequestParam int vehicleBrandID) throws IOException {
        VehicleBrandDTO vehicleBrandDTO = vehicleBrandService.searchVehicleBrand(vehicleBrandID);
        vehicleBrandDTO.setImage(multipartFile.getBytes());
        return new ResponseEntity<>( vehicleBrandService.updateVehicleBrand(vehicleBrandDTO), HttpStatus.OK);
    }


    @GetMapping(path = "search", params = "vehicleBrandID")
    public ResponseEntity<VehicleBrandDTO> searchVehicleBrand(@RequestParam int vehicleBrandID) {
        return new ResponseEntity<>(vehicleBrandService.searchVehicleBrand(vehicleBrandID), HttpStatus.OK);
    }

    @DeleteMapping(params = "vehicleBrandID")
    public ResponseEntity<VehicleBrandDTO> deleteVehicleBrand(@RequestParam int vehicleBrandID) {
        vehicleBrandService.deleteVehicleBrand(vehicleBrandID);
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<VehicleBrandDTO>> getAllVehicleBrand() {
        return new ResponseEntity<>(vehicleBrandService.getAllVehicleBrand(), HttpStatus.OK);
    }
}
