package com.javaED.repository;


import com.javaED.model.test.GeneralTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmitGeneralTestRepository extends JpaRepository<GeneralTest, Integer> {

}
