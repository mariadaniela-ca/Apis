package ar.com.ada.api.simulacrochallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.simulacrochallenge.entities.Categoria;
import ar.com.ada.api.simulacrochallenge.models.request.CategoriaRequest;
import ar.com.ada.api.simulacrochallenge.models.response.CategoriaResponse;
import ar.com.ada.api.simulacrochallenge.services.CategoriaService;

/**
 * CategoriaController
 */
@RestController
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping("categorias")
    public CategoriaResponse postRegistroCategoria(@RequestBody CategoriaRequest req){


        CategoriaResponse r = new CategoriaResponse();
        categoriaService.registrarCategoria(req.nombre, req.sueldoBase);

        r.message = "Categoria registrada con exito";

        return r;
        
    }

    @GetMapping("/categorias")
    public List<Categoria> getCategorias() {

        List<Categoria> listaCategorias = categoriaService.getCategorias();

        return listaCategorias;
    }  

    @GetMapping("/categorias/{id}")
    public Categoria getCategoriaById(@PathVariable int id) {

        Categoria c = categoriaService.buscarCategoriaPorId(id);
        return c;
    }

}