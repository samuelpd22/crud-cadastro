package com.cadastroAdv.controller;

import com.cadastroAdv.dto.ClientDTO;
import com.cadastroAdv.dto.LoginDTO;
import com.cadastroAdv.entity.ClientEntity;
import com.cadastroAdv.entity.LoginEntity;
import com.cadastroAdv.repository.LoginRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;


    @PostMapping("/adm")
    public ResponseEntity<LoginEntity> logar(@RequestBody LoginDTO loginDTO) {
        Optional<LoginEntity> loginOptional = loginRepository.findByLoginAndPassword(loginDTO.login(), loginDTO.password());

        if (loginOptional.isPresent()) {
            LoginEntity loginEntity = loginOptional.get();
            return ResponseEntity.ok(loginEntity); // Retorna o usuário se o login e a senha estiverem corretos
        } else {
            return ResponseEntity.notFound().build(); // Retorna um erro se o usuário não for encontrado ou a senha estiver incorreta
        }
    }
}