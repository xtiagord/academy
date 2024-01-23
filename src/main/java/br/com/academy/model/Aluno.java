package br.com.academy.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import br.com.academy.Enums.Curso;
import br.com.academy.Enums.Status;
import nonapi.io.github.classgraph.json.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@EntityScan
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Column(name = "nome")
    private String nome;

    @Column(name = "Curso")
    private Curso curso;

    @Column(name = "turno")
    private String turno;

    @Column(name = "matricula")
    private String matricula;

    @Column(name = "status")
    private Status status;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setturno(String turno) {
        turno = turno;
    }

    public void setMatricula(String matricula) {
        matricula = matricula;
    }
    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getturno() {
        return turno;
    }

    public String getMatricula() {
        return matricula;
    }


   


}
