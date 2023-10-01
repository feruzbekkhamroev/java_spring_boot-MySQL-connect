package com.example.pg_project3.repositories;

import com.example.pg_project3.tables.MyTables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repositories extends JpaRepository<MyTables, Long>, CrudRepository<MyTables, Long> {
}
