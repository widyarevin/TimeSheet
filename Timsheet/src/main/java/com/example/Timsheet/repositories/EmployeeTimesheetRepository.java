package com.example.Timsheet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Timsheet.DTO.EmployeDTOTime;
import com.example.Timsheet.DTO.EmployeeTimesheetDTO;
import com.example.Timsheet.models.EmployeeTimesheet;

@Repository
public interface EmployeeTimesheetRepository extends JpaRepository<EmployeeTimesheet, Integer> {
     @Query(value = "SELECT * FROM tbl_tr_employee_timesheet order by id desc;", nativeQuery = true)
    public List<EmployeeTimesheet> getEmployeeTimesheet();
    
    @Query(value = "SELECT * FROM tbl_tr_employee_timesheet order by id desc", nativeQuery = true)
    public List<EmployeDTOTime> getEmployeeTimesheetDTO();

     @Query(value = "SELECT * FROM tbl_tr_employee_timesheet  where timesheet_id = ?1", nativeQuery = true)
    public List<EmployeeTimesheet> getDetailTimesheet(Integer id);
    
    
}
