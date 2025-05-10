package com.anaelzan.senai.Interface;

import com.anaelzan.senai.Model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
