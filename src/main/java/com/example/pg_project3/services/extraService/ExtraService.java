package com.example.pg_project3.services.extraService;

import com.example.pg_project3.repositories.Repositories;
import com.example.pg_project3.services.Services;
import com.example.pg_project3.tables.MyTables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ExtraService implements Services {

    @Autowired
    private final Repositories repositories;

    public ExtraService (Repositories repositories) {
        this.repositories = repositories;
    }

    @Override
    public ResponseEntity<List <MyTables>> getAllEmployee() {
        List <MyTables> myTablesList = new ArrayList<>();
        repositories.findAll().forEach(myTablesList::add);
        return new ResponseEntity<List<MyTables>>(myTablesList, HttpStatus.OK);
    }


    @Override
    public ResponseEntity <MyTables> getEmployeeById(long id) {
        Optional <MyTables> optionalId = repositories.findById(id);

        if (optionalId.isPresent()){
            return new ResponseEntity<MyTables>(optionalId.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<MyTables>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public String createNewEmployee(MyTables myTables) {
        repositories.save(myTables);
        return "Dastur muvaffaqiyatli saqlandi!";
    }


    @Override
    public String updateEmployeeById(long id, MyTables myTables) {
        Optional <MyTables> optionalIds = repositories.findById(id);

        if (optionalIds.isPresent()) {
            MyTables otherTable = optionalIds.get();

            otherTable.setFirstname(myTables.firstname);
            otherTable.setLastname(myTables.lastname);
            otherTable.setYears(myTables.years);
            otherTable.setAddress(myTables.address);

            repositories.save(otherTable);
            return "Ma'lumot muvaffaqiyatli o'zgartirildi!";
        } else {
            return "Dasturda muammo mavjud!";
        }
    }

    @Override
    public String deleteEmployeeByEmployeeId(long id) {
        repositories.deleteById(id);
        return "Berilgan element muvaffaqiyatli olib tashlandi!";
    }

    @Override
    public String deleteAllEmployee() {
        repositories.deleteAll();
        return "Bazadagi barcha ma'lumot tozalandi va baza bo'shatildi!";
    }

}
