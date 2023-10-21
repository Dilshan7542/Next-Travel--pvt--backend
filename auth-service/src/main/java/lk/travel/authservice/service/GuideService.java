package lk.travel.authservice.service;

import lk.travel.authservice.dto.GuideDTO;

import java.util.List;

public interface GuideService {
    GuideDTO saveGuide(GuideDTO guideDTO);
    GuideDTO updateGuide(GuideDTO guideDTO);
    GuideDTO searchGuide(int guideID);
    void deleteGuide(int guideID);
    List<GuideDTO> getAllGuide();
}
