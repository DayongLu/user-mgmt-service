package com.dlu.task.mgmt.usermgmtservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class UserMgmtServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserMgmtServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner initial(UserRepository userRepository) {
        return args -> {

            Stream.of("Felix Xu felix.xu@emc.com Sales", "Dayong Lu dayong.lu@paradyme.us PreSale", "Helen Han helen.han@dareauto.com PreSale" ).map(str -> {
                User user = new User();
                String[] arr = str.split(" ");
                user.setFirstName(arr[0]);
                user.setLastName(arr[1]);
                user.setEmailAddress(arr[2]);
                user.setRole(arr[3]);
                return user;
            }).forEach(user -> {
                userRepository.save(user);
            });

        };
    }
}
