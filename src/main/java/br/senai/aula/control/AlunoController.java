package br.senai.aula.control;

import br.senai.aula.model.Aluno;
import br.senai.aula.repo.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public List<Aluno> listarAlunos() {
        var lista =  alunoRepository.findAll();
        return lista;
    }

    @GetMapping("/{id}")
    public Aluno buscarAlunosPorId(@PathVariable Long id) {
        return alunoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Aluno criarAlunos(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @PutMapping("/{id}")
    public Aluno atualizarAlunos(@PathVariable Long id, @RequestBody Aluno aluno) {
        //aluno.setId(id);
        return alunoRepository.save(aluno);
    }

    @DeleteMapping("/{id}")
    public void deletarAlunos(@PathVariable Long id) {
        alunoRepository.deleteById(id);
    }

}