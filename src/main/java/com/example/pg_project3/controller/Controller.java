package com.example.pg_project3.controller;


import com.example.pg_project3.services.Services;
import com.example.pg_project3.tables.MyTables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/outerPath")
public class Controller {

    @Autowired
    private final Services services;

    public Controller (Services services) {
        this.services = services;
    }


    @GetMapping("/inPath")
    public ResponseEntity <List<MyTables>> hammasiniOlish() {
        return services.getAllEmployee();
    }

    @GetMapping("/inPath/{id}")
    public ResponseEntity <MyTables> idBilanOlish(@PathVariable long id) {
        return services.getEmployeeById(id);
    }


    @PostMapping("/inPath")
    public String foydalanuvchiniSaqlash(@RequestBody MyTables myTables) {
        return services.createNewEmployee(myTables);
    }

    @PutMapping("/inPath/{id}")
    public String idBilanUzgartirish(@PathVariable long id, @RequestBody MyTables myTables) {
        return services.updateEmployeeById(id, myTables);
    }

    @DeleteMapping("/inPath/{id}")
    public String idBilanUchirish(@PathVariable long id) {
        return services.deleteEmployeeByEmployeeId(id);
    }

    @DeleteMapping("/inPath")
    public String hammasiniUchirish() {
        return services.deleteAllEmployee();
    }

}
