package com.javaED.repository;

import com.javaED.model.account.AppUser;
import com.javaED.model.account.userProgress.Mistake;
import com.javaED.model.material.Section;
import com.javaED.model.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface MistakeRepository extends JpaRepository<Mistake, Integer> {

    @Query("SELECT m FROM Mistake m WHERE app_user_id = ?1 ")
    List<Mistake> findByUser(AppUser appUser);

    @Query("SELECT m FROM Mistake m WHERE app_user_id = ?1 AND section_id = ?2")
    Optional<Mistake> findByAppUserAndQuestion(AppUser appUser, Section section);

    @Transactional
    @Modifying
    @Query("UPDATE Mistake m SET m.count = :count WHERE m.id = :id")
    int updateMistakeCount(@Param("count") int count, @Param("id") int id);
}
