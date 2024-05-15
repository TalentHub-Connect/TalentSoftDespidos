package com.despido.talentdespido.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.despido.talentdespido.model.Retirement;

import java.util.List;

@Repository
public interface RetirementRepository extends JpaRepository<Retirement, Long> {
    List<Retirement> findByCompanyid(int companyid);
}
