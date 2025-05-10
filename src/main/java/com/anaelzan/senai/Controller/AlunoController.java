//package com.anaelzan.senai.Controller;
//
//import com.anaelzan.senai.Model.Aluno;
//import com.anaelzan.senai.Service.AlunoService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//public class AlunoController {
//
//    @RestController
//
//    @RequestMapping ("/alunos")
//    public class alunoController {
//        private AlunoService AlunoService;
//
//        public alunoController(com.anaelzan.senai.Service.AlunoService alunoService) {
//            AlunoService = alunoService;
//        }
//
//
//
//        @GetMapping
//        public List<Aluno> listaDeAlunos() {
//            return AlunoService.buscarAlunos();
//        }
//
//        @PostMapping
//        public Aluno criarAluno(@RequestBody Aluno aluno) {
//            return AlunoService.salvarAluno(aluno);
//        }
//
//        @GetMapping("/id")
//        public Aluno buscarAlunosporId(@PathVariable Long id) {
//            return AlunoService.buscarAluno(id);
//        }
//
//        @DeleteMapping("/id")
//        public void deletarAluno(@PathVariable Long id) {
//            AlunoService.excluirAluno(id);
//        }
//
//        @PutMapping("/id")
//        public Aluno atualizarAluno(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
//            Aluno verificaAluno = AlunoService.buscarAluno(id);
//            if (verificaAluno == null) return null;
//            verificaAluno.setNomeAluno(alunoAtualizado.getNomeAluno());
//            verificaAluno.setEmailAluno(alunoAtualizado.getEmailAluno());
//            verificaAluno.setTelefoneAluno(alunoAtualizado.getTelefoneAluno());
//            verificaAluno.setId(alunoAtualizado.getId());
//
//            return AlunoService.salvarAluno(alunoAtualizado);
//
//        }
//
//
//    }
//}
package com.anaelzan.senai.Controller;

import com.anaelzan.senai.Model.Aluno;
import com.anaelzan.senai.Service.AlunoService;
import org.springframework.web.bind.annotation.*;

        import java.util.List;
@RestController
@RequestMapping ("/alunos")

public class AlunoController {

    private AlunoService alunoService;

    // Construtor para injeção de dependência
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    // Rota para listar todos os alunos
    @GetMapping
    public List<Aluno> listaDeAlunos() {
        return alunoService.buscarAlunos();
    }

    // Rota para criar um novo aluno
    @PostMapping
    public Aluno criarAluno(@RequestBody Aluno aluno) {
        return alunoService.salvarAluno(aluno);
    }

    // Rota para buscar aluno por ID
    @GetMapping("/{id}")
    public Aluno buscarAlunosPorId(@PathVariable Long id) {
        return alunoService.buscarAluno(id);
    }

    // Rota para deletar aluno por ID
    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable Long id) {
        alunoService.excluirAluno(id);
    }

    // Rota para atualizar aluno por ID
    @PutMapping("/{id}")
    public Aluno atualizarAluno(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
        Aluno verificaAluno = alunoService.buscarAluno(id);
        if (verificaAluno == null) return null;
        verificaAluno.setNomeAluno(alunoAtualizado.getNomeAluno());
        verificaAluno.setEmailAluno(alunoAtualizado.getEmailAluno());
        verificaAluno.setTelefoneAluno(alunoAtualizado.getTelefoneAluno());
        verificaAluno.setId(alunoAtualizado.getId());

        return alunoService.salvarAluno(alunoAtualizado);
    }
}



