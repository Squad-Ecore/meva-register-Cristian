package com.meva.finance.repository;

import com.meva.finance.entity.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FamilyRepository extends JpaRepository<Family, Long> {

}
