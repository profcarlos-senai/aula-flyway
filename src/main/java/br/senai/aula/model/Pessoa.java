package br.senai.aula.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "pessoas")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_pessoa", discriminatorType = DiscriminatorType.INTEGER)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, name = "nome")
    private String nome;
    @Column(name = "data_nasc")
    private Date dataNasc;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Pessoa pessoa = (Pessoa) o;
        return getId() != null && Objects.equals(getId(), pessoa.getId());
    }

    @Override
    public int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

}
