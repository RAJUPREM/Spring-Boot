package com.example.SpringBootBegining5.Repsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBootBegining5.Entity.Marks;

@Repository
public interface MarksRepository extends JpaRepository<Marks,Integer>{

}
