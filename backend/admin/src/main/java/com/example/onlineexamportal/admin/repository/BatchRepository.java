package com.example.onlineexamportal.admin.repository;

import com.example.onlineexamportal.admin.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BatchRepository extends JpaRepository<Batch,Integer> {
    Optional<Batch> findByBatchName(String batchName);
}
