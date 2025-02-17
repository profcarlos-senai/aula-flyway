package br.senai.aula.control;

import br.senai.aula.model.Pessoa;
import br.senai.aula.repo.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> listarPessoas() {
        List<Pessoa> lista = pessoaRepository.findAll();
        return lista;
    }

    @GetMapping("/{id}")
    public Pessoa buscarPessoasPorId(@PathVariable Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Pessoa criarPessoas(@RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @PutMapping("/{id}")
    public Pessoa atualizarPessoas(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        //pessoa.setId(id);
        return pessoaRepository.save(pessoa);
    }

    @DeleteMapping("/{id}")
    public void deletarPessoas(@PathVariable Long id) {
        pessoaRepository.deleteById(id);
    }
}