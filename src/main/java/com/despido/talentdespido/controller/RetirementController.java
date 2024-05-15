package com.despido.talentdespido.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.despido.talentdespido.model.Retirement;
import com.despido.talentdespido.service.RetirementService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/retirement")
public class RetirementController {

    @Autowired
    private RetirementService retirementService;

    @GetMapping("/company/{companyid}")
    public List<Retirement> getRetirementsByCompanyId(@PathVariable int companyid) {
        return retirementService.getAllRetirementsByCompanyId(companyid);
    }

    @PostMapping
    public Retirement createRetirement(@RequestBody Retirement retirement) {
        retirement.setEtapa("Notificación");
        retirement.setProgresodedespido(25);
        retirement.setStatus("ACTIVO");
        return retirementService.createRetirement(retirement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Retirement> updateRetirement(@PathVariable Long id, @RequestParam String etapa, @RequestParam int progreso, @RequestParam String documento) {
        Optional<Retirement> updatedRetirement = retirementService.updateRetirement(id, etapa, progreso, documento);
        return updatedRetirement.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
