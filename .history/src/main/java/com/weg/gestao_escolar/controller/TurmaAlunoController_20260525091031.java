package com.weg.gestao_escolar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weg.gestao_escolar.service.turmaAluno.TurmaAlunoService;

@RestController
@RequestMapping("/turmaAlunos")
public class TurmaAlunoController {
    
    private TurmaAlunoService turmaAlunoService;

    
}
