package com.empleados.repository;


import com.empleados.entity.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpleadoRepository extends JpaRepository<Empleados, Integer> {
}  