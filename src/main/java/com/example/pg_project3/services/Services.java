package com.example.pg_project3.services;

import com.example.pg_project3.tables.MyTables;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Services {

    public ResponseEntity <List <MyTables>> getAllEmployee();

    public ResponseEntity <MyTables> getEmployeeById(long id);

    public String createNewEmployee(MyTables myTables);

    public String updateEmployeeById(long id, MyTables myTables);

    public String deleteEmployeeByEmployeeId(long id);

    public String deleteAllEmployee();


}
