package com.despido.talentdespido.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.despido.talentdespido.model.Retirement;
import com.despido.talentdespido.repository.RetirementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RetirementService {

    @Autowired
    private RetirementRepository retirementRepository;

    public List<Retirement> getAllRetirementsByCompanyId(int companyid) {
        return retirementRepository.findByCompanyid(companyid);
    }

    public Retirement createRetirement(Retirement retirement) {
        return retirementRepository.save(retirement);
    }

    public Optional<Retirement> updateRetirement(Long id, String etapa, int progreso, String documento) {
        Optional<Retirement> retirementOpt = retirementRepository.findById(id);
        if (retirementOpt.isPresent()) {
            Retirement retirement = retirementOpt.get();
            retirement.setEtapa(etapa);
            retirement.setProgresodedespido(progreso);
            List<String> documentos = retirement.getListaDocumentos();
            documentos.add(documento);
            retirement.setListaDocumentos(documentos);
            return Optional.of(retirementRepository.save(retirement));
        }
        return Optional.empty();
    }
}
