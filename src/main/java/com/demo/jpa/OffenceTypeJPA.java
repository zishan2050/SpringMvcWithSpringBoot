package com.demo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.db.OffenceType;

public interface OffenceTypeJPA extends JpaRepository<OffenceType, Long>{

}
