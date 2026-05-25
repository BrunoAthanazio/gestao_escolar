package com.weg.gestao_escolar.model;

public class TurmaAluno {
    private Long turma_id, aluno_id;
    private String turma_nome, aluno_nome;

    public TurmaAluno(Long turma_id, Long aluno_id) {
        this.turma_id = turma_id;
        this.aluno_id = aluno_id;
    }

    public TurmaAluno(String turma_nome, String aluno_nome) {
        this.turma_nome = turma_nome;
        this.aluno_nome = aluno_nome;
    }

    public TurmaAluno() {}

    public Long getTurma_id() {
        return turma_id;
    }

    public void setTurma_id(Long turma_id) {
        this.turma_id = turma_id;
    }

    public Long getAluno_id() {
        return aluno_id;
    }

    public void setAluno_id(Long aluno_id) {
        this.aluno_id = aluno_id;
    }

    public String getTurma_nome() {
        return turma_nome;
    }

    public void setTurma_nome(String turma_nome) {
        this.turma_nome = turma_nome;
    }

    public String getAluno_nome() {
        return aluno_nome;
    }

    public void setAluno_nome(String aluno_nome) {
        this.aluno_nome = aluno_nome;
    }

    
}
