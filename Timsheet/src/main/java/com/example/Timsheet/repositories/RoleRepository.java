
package com.example.Timsheet.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.Timsheet.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
    
    @Query(value = "SELECT rl.id FROM tbl_m_role rl WHERE rl.level = (SELECT MAX(rl.level) FROM tbl_m_role rl)", nativeQuery = true)
    int findMaxLevel();
}
