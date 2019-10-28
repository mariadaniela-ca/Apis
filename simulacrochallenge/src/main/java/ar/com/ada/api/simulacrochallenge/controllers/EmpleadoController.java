package ar.com.ada.api.simulacrochallenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.simulacrochallenge.entities.Empleado;
import ar.com.ada.api.simulacrochallenge.models.request.EmpleadoRequest;
import ar.com.ada.api.simulacrochallenge.models.response.EmpleadoResponse;
import ar.com.ada.api.simulacrochallenge.services.EmpleadoService;

/**
 * EmpleadoController
 */
@RestController
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    @PostMapping("empleados")
    public EmpleadoResponse postRegistroEmpleado(@RequestBody EmpleadoRequest req) {

        EmpleadoResponse r = new EmpleadoResponse();
        
        empleadoService.registrarEmpleado(req.nombre, req.edad, req.categoriaId, req.sueldo, req.estado);

        r.message = "Empleado registrado con exito";

        return r;

    }

    @GetMapping("/empleados")
    public List<Empleado> getEmpleados() {

        List<Empleado> listaEmpleados = empleadoService.getEmpleados();

        return listaEmpleados;
    }

    @GetMapping("/empleados/{id}")
    public Empleado getEmpleadoById(@PathVariable int id) {

        Empleado e = empleadoService.buscarEmpleadoPorId(id);
        return e;
    }

    @GetMapping("/empleados/categorias/{categoriaId}")
        public List<Empleado> getEmpleadosPorCategoriaId(@PathVariable int categoriaId){
        
            List<Empleado> listaEmpleados = empleadoService.getEmpleadoPorCategorias(categoriaId);
            return listaEmpleados;
    

        }


    @PutMapping("empleados/{id}")
    public EmpleadoResponse putActualizarDatosEmpleado(@PathVariable int id, @RequestBody EmpleadoRequest req) {

        EmpleadoResponse r = new EmpleadoResponse();

        empleadoService.actualizarEmpleadoporId(id, req.nombre, req.edad, req.categoriaId);

        r.message = "Empleado actualizado con éxito";

        return r;

    }
    @PutMapping("empleados/{id}/sueldos")
    public EmpleadoResponse putActualizarSueldoEmpleado(@PathVariable int id, @RequestBody EmpleadoRequest req){

        EmpleadoResponse r = new EmpleadoResponse();

       empleadoService.actualizarSueldoporId(id, req.sueldo);

        r.message = "El sueldo ha sido actualizado ";

        return r;
    }

    @DeleteMapping("empleados/{id}")
    public Empleado darDeBajaEmpleadoPorId(@PathVariable int id){

        Empleado e = empleadoService.darDeBajaEmpleado(id);

        return e;
    }



}