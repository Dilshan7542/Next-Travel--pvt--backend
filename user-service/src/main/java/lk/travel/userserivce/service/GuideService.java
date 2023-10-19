package lk.travel.userserivce.service;

import lk.travel.userserivce.dto.GuideDTO;
import lk.travel.userserivce.dto.UserDTO;

import java.util.List;

public interface GuideService {
    GuideDTO saveGuide(GuideDTO guideDTO);
    GuideDTO updateGuide(GuideDTO guideDTO);
    GuideDTO searchGuide(int guideID);
    void deleteGuide(int guideID);
    List<GuideDTO> getAllGuide();
}
