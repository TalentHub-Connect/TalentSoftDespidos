package com.despido.talentdespido.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.despido.talentdespido.model.Reason;
import com.despido.talentdespido.repository.ReasonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReasonService {

    @Autowired
    private ReasonRepository reasonRepository;

    public List<Reason> findAll() {
        return reasonRepository.findAll();
    }
    public Reason findById(Long id) {
        Optional<Reason> reason = reasonRepository.findById(id);
        return reason.orElse(null);
    }


    public Reason save(Reason reason) {
        return reasonRepository.save(reason);
    }

    public Reason update(Reason reason) {
        return reasonRepository.save(reason);
    }

    public void delete(Long id) {
        reasonRepository.deleteById(id);
    }
}
