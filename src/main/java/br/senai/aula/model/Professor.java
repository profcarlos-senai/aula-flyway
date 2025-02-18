package br.senai.aula.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@DiscriminatorValue("2")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Professor extends Pessoa {

    // formação (strings contendo nome do curso, universidade e ano de conclusão)
    @Column(length = 100, name = "graduacao")
    private String graduacao;

    @Column(length = 100, name = "mestrado")
    private String mestrado;

    @Column(length = 100, name = "doutorado")
    private String doutorado;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Professor professor = (Professor) o;
        return getId() != null && Objects.equals(getId(), professor.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
