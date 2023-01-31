package com.example.Timsheet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.Timsheet.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    @Query(value = "SELECT * FROM tbl_tr_user u JOIN tbl_m_employee e ON e.id = u.id WHERE e.email = ?1", nativeQuery = true)
    User findByEmail(String email);

    @Query(value = "SELECT * FROM user u JOIN employee e ON e.id = u.id WHERE e.email = ?1", nativeQuery = true)
    String findByEmail2(String email);

    @Query(value = "SELECT * FROM tbl_tr_user u JOIN tbl_m_employee e ON e.id = u.id JOIN tbl_m_role r ON r.id = u.role_id WHERE e.email = ?1", nativeQuery = true)
    public User LoginSecurity(String email);

    @Query(value = "SELECT e.id FROM tbl_tr_user u JOIN tbl_m_employee e ON e.id = u.id WHERE e.email = ?1", nativeQuery = true)
    public Integer findIdByEmail(String email);

}
