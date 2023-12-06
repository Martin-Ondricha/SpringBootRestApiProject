/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringBoot.demo.users;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author marti
 */
@Configuration
public class UsersConfig {

    @Bean
    CommandLineRunner commandLineRunner(UsersRepository repository) {
        return args -> {

            //list of existing users
            Users user1 = new Users(5, "Martin", 30, "Slovakia", "mato@email.com");
            Users user2 = new Users(10, "Lukas", 27, "Czech republic", "luko@email.com");
            Users user3 = new Users(15, "Peter", 21, "Poland", "peto@email.com");
            Users user4 = new Users(20, "Samuel", 37, "Austria", "samo@email.com");
            Users user5 = new Users(25, "Jan", 30, "Slovakia", "jano@email.com");

            repository.saveAll(List.of(user1, user2, user3, user4, user5));

        };
    }
}
