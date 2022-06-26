package com.example.ModuloTallersf.repository;

import com.example.ModuloTallersf.model.UserSys;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UserSys, Integer> {
    UserSys findOneByNombre(String username);
}
