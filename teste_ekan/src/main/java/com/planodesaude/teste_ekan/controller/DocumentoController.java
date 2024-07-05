package com.planodesaude.teste_ekan.controller;

import com.planodesaude.teste_ekan.model.Documento;
import com.planodesaude.teste_ekan.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/documentos")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    // Endpoint para listar todos os documentos
    @GetMapping
    public List<Documento> getAllDocumentos() {
        return documentoService.findAllBeneficiariosDocumentos();
    }

    

    // Endpoint para listar documentos por ID do beneficiário
    @GetMapping("/beneficiario/{beneficiarioId}")
    public List<Documento> getDocumentosByBeneficiarioId(@PathVariable Long beneficiarioId) {
        return documentoService.findByBeneficiarioId(beneficiarioId);
    }
}
