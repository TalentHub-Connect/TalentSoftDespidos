package com.despido.talentdespido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.despido.talentdespido.model.Reason;
import com.despido.talentdespido.service.ReasonService;

@RestController
@RequestMapping("/reasons")
public class ReasonController {

    @Autowired
    private ReasonService reasonService;

    @GetMapping
    public ResponseEntity<?> getAllReasons(@RequestParam(required = true) Long companyId) {
        if (companyId != null) {
            return ResponseEntity.ok(reasonService.findAllByCompanyId(companyId));
        } else {
            return ResponseEntity.ok(reasonService.findAll());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReasonById(@PathVariable Long id) {
        Reason reason = reasonService.findById(id);
        if (reason != null) {
            return ResponseEntity.ok(reason);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createReason(@RequestBody Reason reason) {
        return ResponseEntity.ok(reasonService.save(reason));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateReason(@PathVariable Long id, @RequestBody Reason reason) {
        reason.setId(id);
        return ResponseEntity.ok(reasonService.update(reason));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReason(@PathVariable Long id) {
        reasonService.delete(id);
        return ResponseEntity.ok().build();
    }
}
