package com.anaelzan.senai.Controller;

import com.anaelzan.senai.Model.Professor;
import com.anaelzan.senai.Service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")

public class ProfessorController {

    private ProfessorService professorService;
    public ProfessorController(ProfessorService professorService){
        this.professorService = professorService;
    }
    @GetMapping
    public List<Professor> buscarProfessor(){
        return professorService.buscarProfessor();
    }
    @PostMapping
    public Professor criar(@RequestBody Professor professor){
        return professorService.salvarProfessor(professor);
    }
    @GetMapping("/{id}")
    public Professor buscar(@PathVariable Long id){
        return professorService.buscarProfessor(id);
    }
    @PutMapping("/{id}")
    public Professor atualizar(@PathVariable Long id, @RequestBody Professor novoProfessor){
        Professor professorExistente = professorService.buscarProfessor((id));
        if (professorExistente == null) return null;
        professorExistente.setNomeProfessor(novoProfessor.getNomeProfessor());
        professorExistente.setEmailProfessor(novoProfessor.getEmailProfessor());
        professorExistente.setTelefoneProfessor(novoProfessor.getTelefoneProfessor());
        return professorService.salvarProfessor(professorExistente);

    }
    @DeleteMapping("/{id}")
    public void deletar (@PathVariable Long id){
        professorService.excluirProfessor(id);

    }







}
