package com.cadastroAdv.controller;

import ch.qos.logback.core.net.server.Client;
import com.cadastroAdv.dto.ClientDTO;
import com.cadastroAdv.entity.ClientEntity;
import com.cadastroAdv.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/cli/cadastro")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;


    @GetMapping
    public ResponseEntity<List> listarTodos (){
        return new ResponseEntity(clientRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{cpf}")
    public ResponseEntity<?> buscarPessoaPorCPF(@PathVariable String cpf) {
        Optional<ClientEntity> clientExist = clientRepository.findByCpf(cpf);
        if(!clientExist.isPresent()){
            throw new EntityNotFoundException("Pessoa não encontrada.");
        } else {
            ClientEntity client = clientExist.get();
            return new ResponseEntity<>(client, HttpStatus.OK);
        }


    }

    @GetMapping ("/buscar/{id}")
    public ResponseEntity<ClientEntity> listarPorId (@PathVariable Long id){
        return new ResponseEntity(clientRepository.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClientEntity> cadastrarCliente(@RequestBody ClientDTO clientDTO){
        ClientEntity newClient = new ClientEntity();
        BeanUtils.copyProperties(clientDTO , newClient);
        clientRepository.save(newClient);
        return new ResponseEntity<>(newClient,HttpStatus.OK);

    }

    @PostMapping("/editar/{cpf}")
    public ResponseEntity<?> editarPessoaPorCPF(@PathVariable String cpf,@RequestBody ClientDTO clientDTO) {
        Optional<ClientEntity> clientExist = clientRepository.findByCpf(cpf);
        if(!clientExist.isPresent()){
            throw new EntityNotFoundException("Pessoa não encontrada.");
        } else {
            ClientEntity client = clientExist.get();
            BeanUtils.copyProperties(clientDTO, client);
            clientRepository.save(client);
            return new ResponseEntity<>(client, HttpStatus.OK);
        }
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarPorId (@PathVariable Long id){
        clientRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
