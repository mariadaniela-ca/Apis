package ar.com.ada.api.simulacrochallenge.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.simulacrochallenge.entities.Categoria;
import ar.com.ada.api.simulacrochallenge.repo.CategoriaRepository;

/**
 * CategoriaService
 */
@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepo;

    public void saveCategoria(Categoria categoria) {
        categoriaRepo.save(categoria);
    }

    public Categoria registrarCategoria(String nombre, BigDecimal sueldoBase) {
        Categoria categoria = new Categoria();
        categoria.setNombre(nombre);
        categoria.setSueldoBase(sueldoBase);

        categoriaRepo.save(categoria);

        return categoria;
    }

    public Categoria buscarCategoriaPorId(int id) {
        Optional<Categoria> c = categoriaRepo.findById(id);

        if (c.isPresent())
            return c.get();
        return null;
    }

    public List<Categoria> getCategorias() {

        return categoriaRepo.findAll();
    }

    public Categoria buscarCategoriaPorNombre(String nombre) {
        return categoriaRepo.findByNombre(nombre);
    }

}