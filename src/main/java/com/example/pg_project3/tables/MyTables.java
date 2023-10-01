package com.example.pg_project3.tables;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;


@Entity
@Data
@Table(name = "mening_jadvalim")
public class MyTables implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    public String firstname;

    @Column
    public String lastname;

    @Column
    public int years;

    @Column
    public String address;

    public MyTables() {
    }

    public MyTables(long id, String firstname, String lastname, int years, String address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.years = years;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
