package lk.travel.bookingservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BookingServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookingServiceApplication.class);
    }
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}