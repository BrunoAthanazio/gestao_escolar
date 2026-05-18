package com.weg.gestao_escolar.model;

public class Turma {

    private Long id;

    private String nome, curso_nome, professor_nome;

    private Long curso_id, professor_id;

    public Turma(Long id, String nome, Long curso_id, Long professor_id) {
        this.id = id;
        this.nome = nome;
        this.curso_id = curso_id;
        this.professor_id = professor_id;
    }

    public Turma(String nome, Long curso_id, Long professor_id) {
        this.nome = nome;
        this.curso_id = curso_id;
        this.professor_id = professor_id;
    }

    public Turma(Long id, String nome, String curso_nome, String professor_nome) {
        this.id = id;
        this.nome = nome;
        this.curso_nome = curso_nome;
        this.professor_nome = professor_nome;
    }

    public Turma() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(Long curso_id) {
        this.curso_id = curso_id;
    }

    public Long getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(Long professor_id) {
        this.professor_id = professor_id;
    }

    public String getCurso_nome() {
        return curso_nome;
    }

    public void setCurso_nome(String curso_nome) {
        this.curso_nome = curso_nome;
    }

    public String getProfessor_nome() {
        return professor_nome;
    }

    public void setProfessor_nome(String professor_nome) {
        this.professor_nome = professor_nome;
    }

    
}
