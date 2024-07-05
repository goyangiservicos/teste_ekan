package com.planodesaude.teste_ekan.repository;

import com.planodesaude.teste_ekan.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {

    @Query("SELECT d FROM Documento d WHERE d.beneficiario.id = :beneficiarioId")
    List<Documento> findByBeneficiarioId(Long beneficiarioId);

    @Query("SELECT d FROM Documento d JOIN FETCH d.beneficiario")
    List<Documento> findAllBeneficiariosDocumentos();

    void deleteByBeneficiarioId(Long beneficiarioId);

    Optional<Documento> findByTipoDocumentoAndBeneficiarioId(String tipoDocumento, Long beneficiarioId);
}
