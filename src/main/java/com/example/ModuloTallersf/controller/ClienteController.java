package com.example.ModuloTallersf.controller;


import com.example.ModuloTallersf.model.Cliente;
import com.example.ModuloTallersf.service.ClienteService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    //inyeccion de clienteservice
    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @ApiOperation(value = "Obtener todos los Clientes",
            notes = "No necesita parametros de entrada",
            responseContainer = "Clientes")
    @ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED",
            response = Cliente.class, responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 500, message = "No se encontraron Clientes en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @GetMapping
    public List<Cliente> findAll(){
        return  clienteService.findAll();
    }


    @ApiOperation(value = "Crear un Cliente",
            notes = "Se debe enviar el body objeto JSON con datos",
            response = Cliente.class,
            responseContainer = "Nuevo CLiente")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 500, message = "No se pudo crear el registro"),
            @ApiResponse(code = 200, message = "Petición OK")})

    @PostMapping
    public Cliente save(@RequestBody Cliente clientCurrent){
        return clienteService.save(clientCurrent);
    }
}
