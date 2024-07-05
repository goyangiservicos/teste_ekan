package com.planodesaude.teste_ekan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.planodesaude.teste_ekan.model.Beneficiario;

@Repository
public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {
    @Query("SELECT b FROM Beneficiario b LEFT JOIN FETCH b.documentos")
    List<Beneficiario> findAllWithDocumentos();
}
