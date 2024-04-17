package com.cadastroAdv.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity( name = "cli_adv" )
@Table( name ="cli_adv")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientEntity {


    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCompleto;

    private String cpf;

    private String identidade;

    private String cli;

    private String planoEc;

    private String processo;

    private String datNascimento;

    private String email;

    private String celular;

    private String endereco;

    private String cep;

    private String obs;


}
