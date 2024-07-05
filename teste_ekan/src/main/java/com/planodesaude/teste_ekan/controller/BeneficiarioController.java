package com.planodesaude.teste_ekan.controller;

import com.planodesaude.teste_ekan.model.Beneficiario;
import com.planodesaude.teste_ekan.model.Documento;
import com.planodesaude.teste_ekan.service.BeneficiarioService;
import com.planodesaude.teste_ekan.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/beneficiarios")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioService beneficiarioService;

    @Autowired
    private DocumentoService documentoService;

    @PostMapping
    public ResponseEntity<Beneficiario> createBeneficiario(@RequestBody Beneficiario beneficiario) {
        Beneficiario savedBeneficiario = beneficiarioService.save(beneficiario);

        // Criar documentos para o beneficiário
        for (Documento documento : beneficiario.getDocumentos()) {
            documento.setBeneficiario(savedBeneficiario);
            documento.setDataInclusao(LocalDate.now());
            documentoService.save(documento);
        }

        return ResponseEntity.ok(savedBeneficiario);
    }

    @GetMapping
    public List<Beneficiario> getAllBeneficiarios() {
        List<Beneficiario> beneficiarios = beneficiarioService.findAll();
        for (Beneficiario beneficiario : beneficiarios) {
            List<Documento> documentos = documentoService.findByBeneficiarioId(beneficiario.getId());
            beneficiario.setDocumentos(documentos);
        }
        return beneficiarios;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Beneficiario> getBeneficiarioById(@PathVariable Long id) {
        Optional<Beneficiario> beneficiario = beneficiarioService.findById(id);
        if (beneficiario.isPresent()) {
            List<Documento> documentos = documentoService.findByBeneficiarioId(id);
            beneficiario.get().setDocumentos(documentos);
            return ResponseEntity.ok(beneficiario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Beneficiario> updateBeneficiario(@PathVariable Long id, @RequestBody Beneficiario beneficiarioDetails) {
        Optional<Beneficiario> optionalBeneficiario = beneficiarioService.findById(id);
        if (optionalBeneficiario.isPresent()) {
            Beneficiario existingBeneficiario = optionalBeneficiario.get();
            existingBeneficiario.setNome(beneficiarioDetails.getNome());
            existingBeneficiario.setTelefone(beneficiarioDetails.getTelefone());
            existingBeneficiario.setDataNascimento(beneficiarioDetails.getDataNascimento());
            existingBeneficiario.setDataInclusao(beneficiarioDetails.getDataInclusao());
            existingBeneficiario.setDataAtualizacao(LocalDate.now()); // Adicionado: Atualizar a data de atualização para a data atual
    
                       for (Documento documento : beneficiarioDetails.getDocumentos()) {
                documento.setBeneficiario(existingBeneficiario);
                documentoService.save(documento);
            }
    
            Beneficiario updatedBeneficiario = beneficiarioService.save(existingBeneficiario);
            return ResponseEntity.ok(updatedBeneficiario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
public ResponseEntity<Void> deleteBeneficiario(@PathVariable Long id) {
    Optional<Beneficiario> beneficiario = beneficiarioService.findById(id);
    if (beneficiario.isPresent()) {
        beneficiarioService.deleteById(id);
        documentoService.deleteByBeneficiarioId(id); 
        return ResponseEntity.noContent().build();
    } else {
        return ResponseEntity.notFound().build();
    }
}
}
