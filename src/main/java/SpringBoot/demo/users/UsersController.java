/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpringBoot.demo.users;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author marti
 */
@RestController
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

//  Example usage:  http://localhost:8080/user?id=5 
    @GetMapping("/user")
    public Optional<Users> getUser(@RequestParam Long id) {
        return usersService.getOneUser(id);
    }

//  http://localhost:8080
    @GetMapping
    public List< Users> all() {
        return usersService.allUsers();
    }

//  Example usage:  http://localhost:8080/user?id=5
    @DeleteMapping("/user")
    public ResponseEntity<String> delete(@RequestParam Long id) {

        if (usersService.deleteUser(id)) {
            return ResponseEntity.ok("You deleted account with id: " + id);
            
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no account with id: " + id);
        }
    }

//  http://localhost:8080
    @PostMapping
    public ResponseEntity< String> addNew(@RequestBody Users users) {

        if (this.usersService.createNewUser(users)) {
            return ResponseEntity.ok("User created successfully");
            
        } else if (this.usersService.doesEmailExist(users.getEmail())) {
            return ResponseEntity.badRequest().body("User creation failed email: " + users.getEmail() + "  already exists");
            
        } else {
            return ResponseEntity.badRequest().body("User creation failed id: " + users.getId() + " already exists");
        }
    }

//  Example usage:  http://localhost:8080/user?id=5
    @PutMapping("/user")
    public ResponseEntity<String> updateUser(@RequestBody Users users, @RequestParam Long id) {

        if (this.usersService.updateUsers(users, id)) {
            return ResponseEntity.ok("User updated successfully");

        } else {

            return ResponseEntity.badRequest().body("User update failed email: " + users.getEmail() + " already exists");
        }
    }

}
