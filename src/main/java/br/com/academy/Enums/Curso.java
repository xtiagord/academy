package br.com.academy.Enums;

public enum Curso {
    
    ADMINISTRACAO("Administração"),
    INFORMTAICA("Informatica"),
    CONTABILIDADE("Contabilidade"),
    PROGRAMCAO("Programação");

    private String curso;
    
    private Curso(String curso){
        this.curso=curso;
    }
}
