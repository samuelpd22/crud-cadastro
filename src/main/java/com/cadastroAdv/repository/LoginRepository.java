package com.cadastroAdv.repository;

import com.cadastroAdv.entity.ClientEntity;
import com.cadastroAdv.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<LoginEntity, Long> {

    Optional<LoginEntity> findByLogin(String login);
    Optional<LoginEntity> findByPassword(String password);

    Optional<LoginEntity> findByLoginAndPassword(String login, String password);

}
