package peaksoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class RestApi19Application {

    public static void main(String[] args) {
        SpringApplication.run(RestApi19Application.class, args);

        System.out.println(LocalDate.now());
    }

}
