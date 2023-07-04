package com.meva.finance.repository;

import com.meva.finance.entity.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface FamilyRepository extends JpaRepository<Family, Long> {

//    @Query("SELECT COALESCE(MAX(f.id), 0) + 1 FROM Family f")
//    Long findNextValidNumber();
//
////    @Modifying
////    @Query("UPDATE Family f SET f.id = :nextValidId WHERE f.id = :id")
////    void updateId(@Param("id") Long id, @Param("nextValidId") Long nextValidId);


}
