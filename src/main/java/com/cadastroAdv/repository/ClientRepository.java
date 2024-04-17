package com.cadastroAdv.repository;

import com.cadastroAdv.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {


    Optional<ClientEntity> findByCpf(String cpf);

    //    Optional<ClientEntity> findByUsername(String username);

    List<ClientEntity> findByNomeCompletoIgnoreCaseContaining(String nomeCompleto);
}
