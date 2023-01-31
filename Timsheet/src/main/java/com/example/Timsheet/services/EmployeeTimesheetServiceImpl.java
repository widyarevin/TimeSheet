package com.example.Timsheet.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Timsheet.DTO.EmployeDTOTime;
import com.example.Timsheet.DTO.EmployeeTimesheetDTO;
import com.example.Timsheet.models.Employee;
import com.example.Timsheet.models.EmployeeTimesheet;
import com.example.Timsheet.models.Timesheet;
import com.example.Timsheet.repositories.EmployeeTimesheetRepository;

@Service
public class EmployeeTimesheetServiceImpl implements EmployeeTimesheetService{
    
    @Autowired
    private EmployeeTimesheetRepository employeeTimesheetRepository;
    @Autowired
    private TimesheetService timesheetService;


    @Override
    public List<EmployeeTimesheet> getAll() {
        return employeeTimesheetRepository.findAll();
    }

    @Override
    public EmployeeTimesheet getById(Integer id) {
        return employeeTimesheetRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Employee_Timesheet tidak ditemukan"));
    }

    @Override
    public boolean save(EmployeeTimesheetDTO dto) {
        Timesheet timesheet = new Timesheet();
        Employee employee = new Employee();
        EmployeeTimesheet employeeTimesheet = new EmployeeTimesheet();

        employeeTimesheet.setWork_Date(dto.getWork_Date());
        employeeTimesheet.setActivity(dto.getActivity());
        employeeTimesheet.setStart_Hour(dto.getStart_Hour());
        employeeTimesheet.setEnd_Hour(dto.getEnd_Hour());
        employeeTimesheet.setPresents(dto.getPresents());
        employee.setId(dto.getEmployee());
        employeeTimesheet.setEmployee(employee);
        timesheet.setId(timesheetService.getByIdTs());
        employeeTimesheet.setTimesheet(timesheet);
        employeeTimesheetRepository.save(employeeTimesheet);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        employeeTimesheetRepository.deleteById(id);
        return !employeeTimesheetRepository.findById(id).isPresent();
    }


    @Override
    public List<EmployeeTimesheet> getEmployeeTimesheet() {
        return employeeTimesheetRepository.getEmployeeTimesheet();
    }

    @Override
    public List<EmployeDTOTime> getEmployeeTimesheetDTO() {
        List<EmployeeTimesheet> employeeTimesheets = employeeTimesheetRepository.getEmployeeTimesheet();
        return employeeTimesheets.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public EmployeDTOTime convertToDto(EmployeeTimesheet employeeTimesheet){
        return new EmployeDTOTime(employeeTimesheet.getId(), 
            employeeTimesheet.getWork_Date(), 
            employeeTimesheet.getActivity(), 
            employeeTimesheet.getStart_Hour(), 
            employeeTimesheet.getEnd_Hour(), 
            employeeTimesheet.getEmployee().getId(), 
            employeeTimesheet.getTimesheet().getId());
    }
    


    @Override
    public List<EmployeDTOTime> getDetailTimeshet(int id) {
        List<EmployeeTimesheet> status = employeeTimesheetRepository.getDetailTimesheet(id);
        return status.stream().map(this::convertToDto2).collect(Collectors.toList());
    }

    public EmployeDTOTime convertToDto2(EmployeeTimesheet employeeTimesheet){
        return new EmployeDTOTime(
            employeeTimesheet.getId(), 
            employeeTimesheet.getWork_Date(), 
            employeeTimesheet.getActivity(), 
            employeeTimesheet.getStart_Hour(), 
            employeeTimesheet.getEnd_Hour(), 
            employeeTimesheet.getEmployee().getId(), 
            employeeTimesheet.getTimesheet().getId()
        );
    }

}
