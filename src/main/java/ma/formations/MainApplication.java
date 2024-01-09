package ma.formations;

import ma.formations.dtos.CustomerDto;
import ma.formations.service.IService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CommandLineRunner initDatabase(IService customerService) {

        return (args) -> {

            customerService.save(CustomerDto.builder().
                    address("1111 foo blvd").
                    name("Foo Industries").
                    serviceRendered("Important services").
                    build());

            customerService.save(CustomerDto.builder().
                    address("2222 bar street").
                    name("Bar LLP").
                    serviceRendered("Important services").
                    build());

            customerService.save(CustomerDto.builder().
                    address("33 main street").
                    name("Big LLC").
                    serviceRendered("Important services").
                    build());
        };

    }
}
