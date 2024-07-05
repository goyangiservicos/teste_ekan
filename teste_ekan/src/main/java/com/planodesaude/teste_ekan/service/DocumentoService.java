package com.planodesaude.teste_ekan.service;

import com.planodesaude.teste_ekan.model.Documento;
import com.planodesaude.teste_ekan.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    public Documento save(Documento documento) {
        return documentoRepository.save(documento);
    }

    public List<Documento> findAll() {
        return documentoRepository.findAll();
    }

    public List<Documento> findByBeneficiarioId(Long beneficiarioId) {
        return documentoRepository.findByBeneficiarioId(beneficiarioId);
    }

    public List<Documento> findAllBeneficiariosDocumentos() {
        return documentoRepository.findAllBeneficiariosDocumentos();
    }

    public void deleteById(Long id) {
        documentoRepository.deleteById(id);
    }
    public void deleteByBeneficiarioId(Long beneficiarioId) {
        documentoRepository.deleteByBeneficiarioId(beneficiarioId);
    }
    public Optional<Documento> findById(Long id) {
        return documentoRepository.findById(id);
    }


    public Documento updateDocumento(Long documentoId, Documento documentoAtualizado) {
        Optional<Documento> optionalDocumento = documentoRepository.findById(documentoId);
        if (optionalDocumento.isPresent()) {
            Documento documentoExistente = optionalDocumento.get();

            // Atualiza os campos do documento existente com os dados do documento atualizado
            documentoExistente.setTipoDocumento(documentoAtualizado.getTipoDocumento());
            documentoExistente.setDescricao(documentoAtualizado.getDescricao());
            documentoExistente.setDataAtualizacao(LocalDate.now());

            // Salva o documento atualizado no banco de dados
            return documentoRepository.save(documentoExistente);
        } else {
            throw new IllegalArgumentException("Documento não encontrado com o ID: " + documentoId);
        }
    }

}
