package com.romario.financa_api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.romario.financa_api.domain.model.ContasApagar;

@Repository
public interface ContasApagarRepository extends JpaRepository<ContasApagar, Long>{

}
