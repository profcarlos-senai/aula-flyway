package br.senai.aula.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.math.BigDecimal;
import java.util.Objects;


@Entity
@DiscriminatorValue("1")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Aluno extends Pessoa {

    // responsável
    @Column(length = 100, name = "nome_resp")
    private String nomeResponsavel;

    @Column(precision = 11, name = "cpf_resp")
    private BigDecimal cpfResponsavel;

    @Column(precision = 11, name = "fone_resp")
    private BigDecimal foneResponsavel;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Aluno aluno = (Aluno) o;
        return getId() != null && Objects.equals(getId(), aluno.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
