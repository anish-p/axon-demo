package com.example.demoaxon.repository;

import com.example.demoaxon.entities.ComplaintQueryObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintQueryObjectRepository extends JpaRepository<ComplaintQueryObject, String> {
}
