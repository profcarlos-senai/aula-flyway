package br.senai.aula.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import br.senai.aula.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}