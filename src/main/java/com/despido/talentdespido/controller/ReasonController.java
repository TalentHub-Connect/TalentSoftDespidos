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
    public ResponseEntity<?> getAllReasons() {
        return ResponseEntity.ok(reasonService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> createReason(@RequestBody Reason reason, @RequestParam String createForUser) {
        reason.setCreateForUser(createForUser); 
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
