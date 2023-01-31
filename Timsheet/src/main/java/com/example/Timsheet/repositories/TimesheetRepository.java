package com.example.Timsheet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.Timsheet.models.Timesheet;

@Repository
public interface TimesheetRepository extends JpaRepository<Timesheet, Integer> {
    @Query(value = "SELECT MAX(t.id) FROM tbl_m_timesheet t", nativeQuery = true)
    int findMaxId();
}
