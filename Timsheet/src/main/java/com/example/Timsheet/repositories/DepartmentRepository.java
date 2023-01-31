package com.example.Timsheet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Timsheet.models.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{
    
//      @Query("select new com.example.Timsheet.models.Department(u.id, u.name, u.division_id) from tbl_m_department u")
//    public List<Department> getAllDepartment();



 @Query(nativeQuery = true,
            value = "SELECT * tbl_m_department.division_id as departmenId, tbl_m_division.name, tbl_m_department.name as department, tbl_m_department.id "
            + "FROM tbl_m_department "
            + "INNER JOIN tbl_m_division "
            + "ON tbl_m_department.division_id=tbl_m_division.id")
    public List<Department> getAllDepartment();

    //  @Query(value = "  JOIN  ON  =", nativeQuery = true)
    // List<Department> getAllDepartment();

}
