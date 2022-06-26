package com.example.ModuloTallersf.service;



import com.example.ModuloTallersf.exception.ModelNotFoundException;


import java.util.List;

public interface ICRUD <T> {

    List<T> findAll();

    T leerPorId(Integer id) throws ModelNotFoundException;

    T save(T t);

    T modificar(T obj);

    boolean eliminar(Integer id);


}
