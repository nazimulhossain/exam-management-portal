package com.example.onlineexamportal.admin.repository;

import com.example.onlineexamportal.admin.entity.Mcq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface McqRepository extends JpaRepository<Mcq,Integer> {
}
