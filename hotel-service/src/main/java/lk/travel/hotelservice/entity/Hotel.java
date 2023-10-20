package lk.travel.hotelservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Hotel {
    @Id
    int hotelID;
    String name;
    String email;
    String location;
    String map;
    String tel;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    byte[] image;
    int starRate;
    @ElementCollection
    @CollectionTable(name = "hotel_option")
    List<HotelOption> hotelOption;
}
