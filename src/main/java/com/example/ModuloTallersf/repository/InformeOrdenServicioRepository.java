package com.example.ModuloTallersf.repository;

import com.example.ModuloTallersf.model.InformeOrdenServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InformeOrdenServicioRepository extends JpaRepository<InformeOrdenServicio, Integer> {


    @Query(value = "select * from informe_orden_servicio", nativeQuery = true)
    List<Object[]> listarCliente();

}
