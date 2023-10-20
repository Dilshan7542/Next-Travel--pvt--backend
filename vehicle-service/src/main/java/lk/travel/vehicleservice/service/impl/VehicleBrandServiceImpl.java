package lk.travel.vehicleservice.service.impl;

import lk.travel.vehicleservice.dto.VehicleBrandDTO;
import lk.travel.vehicleservice.entity.VehicleBrand;
import lk.travel.vehicleservice.repo.VehicleBrandRepo;
import lk.travel.vehicleservice.service.VehicleBrandService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class VehicleBrandServiceImpl implements VehicleBrandService {
    private final VehicleBrandRepo vehicleBrandRepo;
    private final ModelMapper mapper;

    @Override
    public VehicleBrandDTO saveVehicleBrand(VehicleBrandDTO vehicleBrandDTO) {
        if (vehicleBrandRepo.existsById(vehicleBrandDTO.getVehicleID())) {
            throw new RuntimeException("Vehicle Brand Already Exists..!!");
        }
        vehicleBrandRepo.save(mapper.map(vehicleBrandDTO, VehicleBrand.class));
        return vehicleBrandDTO;
    }

    @Override
    public VehicleBrandDTO updateVehicleBrand(VehicleBrandDTO vehicleBrandDTO) {
        if (!vehicleBrandRepo.existsById(vehicleBrandDTO.getVehicleID())) {
            throw new RuntimeException("Vehicle Brand Not Exists..!!");
        }
        vehicleBrandRepo.save(mapper.map(vehicleBrandDTO, VehicleBrand.class));
        return vehicleBrandDTO;
    }

    @Override
    public VehicleBrandDTO searchVehicleBrand(int vehicleID) {
        if (!vehicleBrandRepo.existsById(vehicleID)) {
            throw new RuntimeException("Vehicle Brand Not Exists..!!");
        }
        return mapper.map( vehicleBrandRepo.findById(vehicleID), VehicleBrandDTO.class);
    }

    @Override
    public void deleteVehicleBrand(int vehicleID) {
        if (!vehicleBrandRepo.existsById(vehicleID)) {
            throw new RuntimeException("Vehicle Brand Not Exists..!!");
        }
        vehicleBrandRepo.deleteById(vehicleID);
    }

    @Override
    public List<VehicleBrandDTO> getAllVehicleBrand() {
        return mapper.map(vehicleBrandRepo.findAll(), new TypeToken<List<VehicleBrandDTO>>() {
        }.getType());
    }
}
