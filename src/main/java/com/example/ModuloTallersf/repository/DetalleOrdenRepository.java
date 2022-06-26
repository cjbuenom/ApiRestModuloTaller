package com.example.ModuloTallersf.repository;

import com.example.ModuloTallersf.model.DetalleOrdenServicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleOrdenRepository extends JpaRepository<DetalleOrdenServicio, Integer> {
}
