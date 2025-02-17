package br.senai.aula.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "pessoas")
@Data
public class Pessoa implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, name = "nome")
    private String nome;

    // endereço
    @Column(length = 255, name="endereco")
    private String endereco;
    @Column(length = 50, name="cidade")
    private String Cidade;
    @Column(length = 2, name="uf")
    private String UF;
    @Column(precision = 8, name="cep")
    private BigDecimal cep;

    // documentos
    @Column(length = 20, name = "identidade")
    String identidade;
    @Column(precision=11, name="cpf")
    BigDecimal cpf;

    // contatos
    @Column(precision = 11, name = "fone1")
    private BigDecimal fone1;
    @Column(precision = 11, name = "fone2")
    private BigDecimal fone2;
    @Column(length = 50, name="email")
    private String email;


    // dados do aluno
    @Column(name = "eh_aluno", nullable = false)
    private boolean isAluno;
    @Column(length = 100, name = "nome_resp")
    private String nomeResponsavel;
    @Column(precision = 11, name = "cpf_resp")
    private BigDecimal cpfResponsavel;
    @Column(precision = 11, name = "fone_resp")
    private BigDecimal foneResponsavel;

    // dados do professor
    @Column(name = "eh_professor", nullable = false)
    private boolean isProfessor;
    @Column(length = 100, name = "graduacao")
    private String graduacao;
    @Column(length = 100, name = "mestrado")
    private String mestrado;
    @Column(length = 100, name = "doutorado")
    private String doutorado;

    // Campos de auditoria (registram quando o registro é criado e alterado)
    @Column(name = "criado_em", updatable = false)
    private java.time.LocalDateTime criadoEm;
    @Column(name = "salvo_em")
    private java.time.LocalDateTime salvoEm;

    @PrePersist
    public void onCreate() {
        this.criadoEm = java.time.LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.salvoEm = java.time.LocalDateTime.now();
    }
}
