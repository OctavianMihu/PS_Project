package com.example.demo.Repo;

import com.example.demo.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository <Driver, Integer> {
    @Modifying
    @Query("update Driver d set d.isWorking = true where d.id = :id")
    Driver startWork(int id);

    @Modifying
    @Query("update Driver d set d.isWorking = false where d.id = :id")
    Driver stopWork(int id);
}
