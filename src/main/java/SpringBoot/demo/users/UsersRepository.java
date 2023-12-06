/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package SpringBoot.demo.users;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author marti
 */
public interface UsersRepository extends JpaRepository<Users, Long>{
     public boolean existsByEmail(String email);

    public boolean existsByIdNotAndEmail(Long id, String email);
}
