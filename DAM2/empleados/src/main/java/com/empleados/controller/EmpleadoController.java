package com.empleados.controller;


import com.empleados.entity.Empleados;
import com.empleados.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
public class EmpleadoController {
    @Autowired
    private EmpleadoRepository empleadoRepository;


    @GetMapping("/empleados")
    public List<Empleados> obtenerTodosLosEmpleados(){
        return empleadoRepository.findAll();
    }


    @PostMapping("/empleados/nuevo")
    public Empleados agregarEmpleado(@RequestBody Empleados empleado){
        return empleadoRepository.save(empleado);
    }


    @PatchMapping("/empleados/editar/{id}")
    public Empleados editarEmpleado(@PathVariable Integer id, @RequestBody Empleados empleado){
        Optional<Empleados> empleadoExistente = empleadoRepository.findById(id);
        if (empleadoExistente.isPresent()) {
            Empleados empleadoActual = empleadoExistente.get();
            empleadoActual.setNombre(empleado.getNombre());
            empleadoActual.setApellido(empleado.getApellido());
            empleadoActual.setEmail(empleado.getEmail());
            return empleadoRepository.save(empleadoActual);
        }
        return null;
    }


    @GetMapping("/empleados/{id}")
    public Empleados obtenerEmpleadoPorId(@PathVariable Integer id){
        return empleadoRepository.findById(id).orElse(null);
    }


    @DeleteMapping("/empleados/{id}")
    public void eliminarEmpleado(@PathVariable Integer id){
        empleadoRepository.deleteById(id);
    }
}