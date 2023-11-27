/*Pacote que o projeto pertence */
package com.api2.api2;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

/*Notação responsável por informar que esse é o arquivo de controle do projeto*/
@RestController
/*Notação responsável por mapear e nomear os aquivos */
@RequestMapping("/")

public class ControladorPrincipal {
/*@Autowired notação responsável por injetar depêndencias (Fazer o trabalho de um construtor) */
    @Autowired
    RepositorioAluno repositorioAluno;
    @Autowired
/*Comando java para utilizar uma classe existente */
    RepositorioProfessor repositorioProfessor;

/*@PostMapping responsável por informar que será usado o método POST e mapear o caminho neste caso /CadastrarAluno */
    @PostMapping ("/CadastrarAluno")

/*Trecho responsável por salvar no banco de dados um aluno */
    public ResponseEntity<Aluno> cadastrar (@RequestBody @Valid Aluno aluno, BindingResult bindingResult) {
        Aluno resposta = new Aluno();
        resposta = (repositorioAluno.save(aluno));
        return new ResponseEntity<>(resposta,HttpStatus.CREATED);
    }

    /*@PostMapping responsável por informar que será usado o método POST e mapear o caminho neste caso /CadastrarAluno */
    @PostMapping ("/CadastrarProfessor")

    /*Trecho responsável por salvar no banco de dados um professor */
    public ResponseEntity<Professor> cadastrar (@RequestBody @Valid Professor professor, BindingResult bindingResult) {
        Professor resposta = new Professor();
        resposta = (repositorioProfessor.save(professor));
        return new ResponseEntity<>(resposta,HttpStatus.CREATED);
    }
    /*Trecho responsável por listar os Alunos cadastrados utilizando o método GET */
     @GetMapping(value="ListarAluno")
    public List<Aluno> listarAlunos() {
        return repositorioAluno.findAll();
    }

    /*Trecho responsável por listar os Professores cadastrados utilizando o método POSTS */
    @PostMapping(value = "ListarProfessor")
    @CrossOrigin("*")
    public List<Professor> listarProfessor() {
        return repositorioProfessor.findAll();
    }

    /*Trecho responsável por Deletar um aluno cadastrado utilizando o método Delete */
    @DeleteMapping("DeletarAluno/{matricula}")
    /*Dentro do ResponseEntity devo botar o retorno, pode ser criada uma classe de resposta  */
    public ResponseEntity<Long> deletarAluno(@PathVariable Long matricula) {

       boolean alunoo = repositorioAluno.existsById(matricula);

       if(alunoo) {
           repositorioAluno.deleteById(matricula);
           return new ResponseEntity<>(matricula, HttpStatus.OK);
       }

       return new ResponseEntity<>(matricula, HttpStatus.NO_CONTENT);
    }

     /*Trecho responsável por Deletar um professor cadastrado utilizando o método Delete */
    @DeleteMapping("DeletarProfessor/{matricula}")
    /*Dentro do ResponseEntity devo botar o retorno, pode ser criada uma classe de resposta  */
    public ResponseEntity<Long> deletarProfessor(@PathVariable Long matricula) {

       boolean prof = repositorioProfessor.existsById(matricula);

       if(prof) {
           repositorioProfessor.deleteById(matricula);
           return new ResponseEntity<>(matricula, HttpStatus.OK);
       }

       return new ResponseEntity<>(matricula, HttpStatus.NO_CONTENT);
    }

    /*Trecho responsável atualizar aluno */
     @PutMapping("AtualizaAluno/{matricula}")
    public ResponseEntity<Aluno> atualizaAluno (@PathVariable Long matricula, @RequestBody Aluno aluno) {
       Optional<Aluno> existingAluno = repositorioAluno.findById(matricula);

       if (existingAluno.isPresent()) {
           Aluno atualizaAluno = existingAluno.get();
           atualizaAluno.nome = aluno.nome;
           atualizaAluno.sobrenome = aluno.sobrenome;
           atualizaAluno.cpf = aluno.cpf;
           atualizaAluno.nota = aluno.nota;
           repositorioAluno.save(atualizaAluno);
           return new ResponseEntity<>(atualizaAluno, HttpStatus.OK);
       }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*Trecho responsável atualizar professor */
     @PutMapping("AtualizaProfessor/{matricula}")
    public ResponseEntity<Professor> atualizaProfessor (@PathVariable Long matricula, @RequestBody Professor professor) {
       Optional<Professor> existingProfessor = repositorioProfessor.findById(matricula);

       if (existingProfessor.isPresent()) {
           Professor atualizaprof = existingProfessor.get();
           atualizaprof.nome = professor.nome;
           atualizaprof.sobrenome = professor.sobrenome;
           atualizaprof.cpf = professor.cpf;
           atualizaprof.disciplina = professor.disciplina;
           repositorioProfessor.save(atualizaprof);
           return new ResponseEntity<>(atualizaprof, HttpStatus.OK);
       }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
