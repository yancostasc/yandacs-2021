package br.univille.yandacs2021.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.yandacs2021.model.Categoria;
import br.univille.yandacs2021.service.CategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
    
    @Autowired
    private CategoriaService service;

    @GetMapping
    public ModelAndView index(){
        List<Categoria> listaCategoria = service.getAllCategorias();
        return new ModelAndView("categoria/index","listaCategorias",listaCategoria);
    }

}