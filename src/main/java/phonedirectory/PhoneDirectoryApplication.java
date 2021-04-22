package phonedirectory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class PhoneDirectoryApplication {

    public static void main(String [] args){
        SpringApplication.run(PhoneDirectoryApplication.class, args);
    }

}
