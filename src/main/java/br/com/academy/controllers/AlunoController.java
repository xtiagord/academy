package br.com.academy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import br.com.academy.dao.AlunoDao;
import br.com.academy.model.Aluno;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AlunoController {

    @Autowired
    private AlunoDao alunorepositorio;


    @GetMapping("/inserirAlunos")
    public ModelAndView InsertAlunos(Aluno aluno) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Aluno/formAluno");
        mv.addObject("aluno", new Aluno());
        return mv;

    }

    @PostMapping("InsertAlunos")
    public ModelAndView inserirAluno (Aluno aluno) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/alunos-adicionados");
        alunorepositorio.save(aluno);
        return mv;
        
    }

    @GetMapping("alunos-adicionados")
    public ModelAndView listagemAlunos() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Aluno/listAlunos");
        Iterable<Aluno> listaDeAlunos = alunorepositorio.findAll();    
        mv.addObject("listaDeAlunos", listaDeAlunos);    
        return mv;
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Integer id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Aluno/alterar");
        Aluno aluno = alunorepositorio.findById(id).orElse(null);
        mv.addObject("aluno", aluno);
    
        return mv;
    }

    @PostMapping("/alterar")
    public ModelAndView alterar (Aluno aluno){
        ModelAndView mv = new ModelAndView();
        alunorepositorio.save(aluno);
        mv.setViewName("redirect:/alunos-adicionados");
        return mv;
    }

    @GetMapping("/excluir/{id}")
    public String excluirAluno (@PathVariable("id") Integer id){
        alunorepositorio.deleteById(id);
        return "redirect:/alunos-adicionados";
    }
    }
