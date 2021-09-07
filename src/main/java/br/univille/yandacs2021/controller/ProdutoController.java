package br.univille.yandacs2021.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;

import br.univille.yandacs2021.model.Categoria;
import br.univille.yandacs2021.service.CategoriaService;
import br.univille.yandacs2021.model.Produto;
import br.univille.yandacs2021.service.ProdutoService;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping
    public ModelAndView index(){
        HashMap<String,Object> data = new HashMap<>();

        List<Produto> listaProdutos = produtoService.getAllProdutos();
        data.put("listaProdutos",listaProdutos);

        List<Categoria> listaCategorias = categoriaService.getAllCategorias();
        data.put("listaCategorias",listaCategorias);

        return new ModelAndView("produto/index", data);
    }

    @GetMapping("/novo")
    public ModelAndView novo(@ModelAttribute Produto produto){
        return new ModelAndView("produto/form");
    }

    @PostMapping(params = "form")
    public ModelAndView save(Produto produto){
        produtoService.save(produto);
        return new ModelAndView("redirect:/produto");
    }

    @GetMapping(value = "/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Produto produto){
        HashMap<String,Object> data = new HashMap<>();
        data.put("produto",produto);

        List<Categoria> listaCategorias = categoriaService.getAllCategorias();
        data.put("listaCategorias",listaCategorias);
        
        return new ModelAndView("produto/form", data);
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Produto produto){
        produtoService.delete(produto);
        return new ModelAndView("redirect:/produto");
    }

}