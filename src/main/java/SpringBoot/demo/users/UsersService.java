/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringBoot.demo.users;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author marti
 */
@Service
public class UsersService {

    // id value must be greater than 1
    private static final int MIN_USER_ID = 1;

    private final UsersRepository repository;

    @Autowired
    public UsersService(UsersRepository repository) {
        this.repository = repository;

    }

    public Optional<Users> getOneUser(Long id) {

        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("User with id: " + id + " does not exist");

        }
        return repository.findById(id);
    }

    public List<Users> allUsers() {
        return repository.findAll();
    }

    public boolean deleteUser(Long id) {

        if (repository.existsById(id)) {
            //user deleting
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }

    }

    public boolean createNewUser(Users users) {

        //Validate the user data by calling the validateUser method to ensure all fields are correct
        validateUser(users);
        boolean existsById = repository.existsById(users.getId());
        boolean existsByEmail = repository.existsByEmail(users.getEmail());
        if (existsById || existsByEmail) {
            return false;
        } else {
            //saving new user
            repository.save(users);
            return true;

        }
    }

    public boolean updateUsers(Users users, Long id) {

        //Validate the user data by calling the validateUser method to ensure all fields are correct
        validateUser(users);

        if (users.getId() != (id)) {
            throw new IllegalArgumentException("User id does not match");
        }
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("User with id: " + id + " not found");

        }

        // Check if there is another user with the same email
  if (repository.existsByIdNotAndEmail(id, users.getEmail())) {
        return false;
        } else {
            //  Update the user's information
            repository.save(users);

            return true;

        }
    }

    private void validateUser(Users users) {
        if (users.getId() < MIN_USER_ID || users.getName() == null || users.getAge() <= 0 || users.getCountry() == null || users.getEmail() == null) {
            throw new IllegalArgumentException("Invalid user data. All fields are required for user creation / id value must be greater than 1");
        }

    }

    public boolean doesEmailExist(String email) {
        return repository.existsByEmail(email);
    }
}
