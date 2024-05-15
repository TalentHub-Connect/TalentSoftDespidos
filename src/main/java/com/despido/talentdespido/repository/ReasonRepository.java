package com.despido.talentdespido.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.despido.talentdespido.model.Reason;


public interface ReasonRepository extends JpaRepository<Reason, Long> {
    List<Reason> findByCompanyId(Long companyId);

}