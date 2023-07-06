package com.meva.finance.repository;

import com.meva.finance.entity.Family;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FamilyRepository extends JpaRepository<Family, Integer> {
}
