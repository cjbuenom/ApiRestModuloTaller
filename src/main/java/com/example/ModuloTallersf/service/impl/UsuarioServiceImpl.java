package com.example.ModuloTallersf.service.impl;

import com.example.ModuloTallersf.exception.ModelNotFoundException;
import com.example.ModuloTallersf.model.UserSys;
import com.example.ModuloTallersf.repository.UsuarioRepository;
import com.example.ModuloTallersf.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UserDetailsService, UsuarioService {

    private final UsuarioRepository usuarioRepository;





    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserSys usuario = usuarioRepository.findOneByNombre(username);

        if(usuario == null) {
            throw new UsernameNotFoundException(String.format("Usuario no existe", username));
        }

        List<GrantedAuthority> roles = new ArrayList<>();

        usuario.getRoles().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        });

        UserDetails ud = new User(usuario.getNombre(), usuario.getClave(), roles);

        return ud;
    }


    @Override
    public List<UserSys> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public UserSys leerPorId(Integer id) throws ModelNotFoundException {
        return null;
    }

    @Override
    public UserSys save(UserSys userSys) {
        return usuarioRepository.save(userSys);
    }

    @Override
    public UserSys modificar(UserSys obj) {
        return null;
    }

    @Override
    public boolean eliminar(Integer id) {
        return false;
    }



}
