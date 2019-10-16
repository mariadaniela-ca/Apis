package ar.com.ada.api.simulacrochallenge.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.simulacrochallenge.entities.Categoria;
import ar.com.ada.api.simulacrochallenge.entities.Empleado;
import ar.com.ada.api.simulacrochallenge.repo.EmpleadoRepository;

/**
 * EmpleadoService
 */
@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository empleadoRepo;

    @Autowired
    CategoriaService categoriaService;

    public void saveEmpleado(Empleado empleado) {
        empleadoRepo.save(empleado);

    }

    public Empleado registrarEmpleado(String nombre, int edad, int id, BigDecimal sueldo, String estado) {
        Categoria c = categoriaService.buscarCategoriaPorId(id);

        Empleado empleado = new Empleado();
        empleado.setNombre(nombre);
        empleado.setEdad(edad);
        empleado.setSueldo(sueldo);
        empleado.setEstado(estado);
        empleado.setFechaAlta(new Date());
        empleado.setCategoria(c);

        empleadoRepo.save(empleado);

        return empleado;

    }

    public List<Empleado> getEmpleados() {

        return empleadoRepo.findAll();
    }

    public Empleado buscarEmpleadoPorId(int id) {
        Optional<Empleado> e = empleadoRepo.findById(id);

        if (e.isPresent())
            return e.get();
        return null;

    }


    public Empleado actualizarEmpleadoporId(int id, String nombre, int edad, int categoriaId){

        Categoria c= categoriaService.buscarCategoriaPorId(categoriaId);

        Empleado e = buscarEmpleadoPorId(id);
        e.setNombre(nombre);
        e.setEdad(edad);
        e.setCategoria(c);

        empleadoRepo.save(e);

        return e;
    }

    public Empleado actualizarSueldoporId(int id, BigDecimal sueldo){

        Empleado e = buscarEmpleadoPorId(id);
        e.setSueldo(sueldo);

        empleadoRepo.save(e);

        return e;
    }

    public Empleado darDeBajaEmpleado(int id){

        Empleado e = buscarEmpleadoPorId(id);
        e.setEstado("baja");
        e.setFechaBaja(new Date());

        empleadoRepo.save(e);

        return e;
    }
}