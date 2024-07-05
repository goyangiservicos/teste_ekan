package com.planodesaude.teste_ekan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.planodesaude.teste_ekan.repository.BeneficiarioRepository;

import jakarta.transaction.Transactional;

import com.planodesaude.teste_ekan.model.Beneficiario;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BeneficiarioService {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    public Beneficiario save(Beneficiario beneficiario) {
        return beneficiarioRepository.save(beneficiario);
    }

    public List<Beneficiario> findAll() {
        return beneficiarioRepository.findAll();
        
    }

    public Optional<Beneficiario> findById(Long id) {
        return beneficiarioRepository.findById(id);
    }

    public void deleteById(Long id) {
        beneficiarioRepository.deleteById(id);
    }
}
