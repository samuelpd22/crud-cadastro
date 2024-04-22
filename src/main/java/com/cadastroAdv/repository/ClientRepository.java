package com.cadastroAdv.repository;

import com.cadastroAdv.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    @Query("SELECT c FROM ClientEntity c WHERE REPLACE(REPLACE(REPLACE(c.cpf, '.', ''), '-', ''), ' ', '') = :cleanedCpf")
    Optional<ClientEntity> findByCpf(@Param("cleanedCpf") String cleanedCpf);


    //    Optional<ClientEntity> findByUsername(String username);

    @Query(value = "SELECT * FROM clients WHERE LOWER(REPLACE(UNACCENT(nome_completo), ' ', '')) LIKE LOWER(CONCAT('%', REPLACE(UNACCENT(:nomeCompleto), ' ', ''), '%'))", nativeQuery = true)
    List<ClientEntity> findByNomeCompletoIgnoreCaseContaining(@Param("nomeCompleto") String nomeCompleto);

}
