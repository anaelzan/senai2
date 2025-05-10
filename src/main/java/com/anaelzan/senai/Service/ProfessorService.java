package com.anaelzan.senai.Service;

import com.anaelzan.senai.Interface.ProfessorRepository;
import com.anaelzan.senai.Model.Professor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    private ProfessorRepository professorRepository;
    public  ProfessorService(ProfessorRepository professorRepository){
        this.professorRepository= professorRepository;
    }
    public List<Professor> buscarProfessor(){
        return professorRepository.findAll();
    }
    public Professor salvarProfessor (Professor professor){
        return professorRepository.save(professor);
    }
    public void excluirProfessor (Long id){
        professorRepository.deleteById(id);
    }
    public Professor buscarProfessor (Long id){
        return  professorRepository.findById(id).orElse(null);
    }
}
