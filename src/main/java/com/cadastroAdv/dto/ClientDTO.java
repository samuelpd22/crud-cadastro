package com.cadastroAdv.dto;

public record ClientDTO(String nomeCompleto, String cpf, String identidade,
                        String cli, String processo, String planoEc,
                        String email, String celular, String datNascimento,
                        String endereco,String cep, String obs) {}
