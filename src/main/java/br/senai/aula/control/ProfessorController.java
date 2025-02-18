package br.senai.aula.control;

import br.senai.aula.model.Professor;
import br.senai.aula.repo.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping
    public List<Professor> listarProfessors() {
        var lista = professorRepository.findAll();
        return lista;
    }

    @GetMapping("/{id}")
    public Professor buscarProfessorsPorId(@PathVariable Long id) {
        return professorRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Professor criarProfessors(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }

    @PutMapping("/{id}")
    public Professor atualizarProfessors(@PathVariable Long id, @RequestBody Professor professor) {
        //professor.setId(id);
        return professorRepository.save(professor);
    }

    @DeleteMapping("/{id}")
    public void deletarProfessors(@PathVariable Long id) {
        professorRepository.deleteById(id);
    }

}