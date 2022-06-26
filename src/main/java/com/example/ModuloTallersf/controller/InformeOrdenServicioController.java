package com.example.ModuloTallersf.controller;

import com.example.ModuloTallersf.dto.FiltroClienteDTO;
import com.example.ModuloTallersf.exception.ModelNotFoundException;
import com.example.ModuloTallersf.model.Cliente;
import com.example.ModuloTallersf.model.InformeOrdenServicio;
import com.example.ModuloTallersf.service.InformeOdenServicioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/informeordenservicio")
public class InformeOrdenServicioController {

    private final InformeOdenServicioService informeOdenServicioService;

    @Autowired
    public InformeOrdenServicioController(InformeOdenServicioService informeOdenServicioService) {
        this.informeOdenServicioService = informeOdenServicioService;
    }

//    @GetMapping
//    public List<InformeOrdenServicio> findAll(){
//        return informeOdenServicioService.findAll();
//    }


    @ApiOperation(value = "Obtener todos los Informes de Clientes",
            notes = "No necesita parametros de entrada",
            responseContainer = "Informes")
    @ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED",
            response = InformeOrdenServicio.class, responseContainer = "List"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 500, message = "No se encontraron Informes de Clientes en la BD"),
            @ApiResponse(code = 200, message = "Petición OK")})
    @GetMapping
    public ResponseEntity<List<InformeOrdenServicio>> findAll() {
        List<InformeOrdenServicio> lista = informeOdenServicioService.findAll();
        return new ResponseEntity<List<InformeOrdenServicio>>(lista, HttpStatus.OK);
    }

    @ApiOperation(value = "Crear un Informe de Cliente",
            notes = "Se debe enviar el body objeto JSON con datos",
            response = InformeOrdenServicio.class,
            responseContainer = "Nuevo Informe")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 500, message = "No se pudo crear el registro"),
            @ApiResponse(code = 200, message = "Petición OK")})


    @ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED",
            response = InformeOrdenServicio.class, responseContainer = "List"
    )


    @PostMapping
    public InformeOrdenServicio save(@RequestBody InformeOrdenServicio informeOrdenServicioCurrent){
        return informeOdenServicioService.save(informeOrdenServicioCurrent);
    }


    @ApiOperation(value = "Actualizar un Informe de Cliente",
            notes = "Se debe enviar el body objeto JSON con datos",
            response = InformeOrdenServicio.class,
            responseContainer = "Update Informe")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 500, message = "No se pudo crear el registro"),
            @ApiResponse(code = 200, message = "Petición OK")})


    @ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED",
            response = InformeOrdenServicio.class, responseContainer = "List"
    )


    @PutMapping("/{id}")
    public InformeOrdenServicio update(@RequestBody InformeOrdenServicio informeOrdenServicio, @PathVariable("id") Integer id){
        return informeOdenServicioService.modificar(informeOrdenServicio);
    }

//    @DeleteMapping("/{id}")
//    public boolean delete(@PathVariable("id") Integer id){
//        return informeOdenServicioService.eliminar(id);
//    }


    @ApiOperation(value = "Eliminar un Informe de Cliente",
            notes = "Se debe enviar el body objeto JSON con datos",
            response = InformeOrdenServicio.class,
            responseContainer = "Delete Informe")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 500, message = "No se pudo crear el registro"),
            @ApiResponse(code = 200, message = "Petición OK")})


    @ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED",
            response = InformeOrdenServicio.class, responseContainer = "List"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<InformeOrdenServicio> delete(@PathVariable("id") Integer id) {
        InformeOrdenServicio obj = informeOdenServicioService.leerPorId(id);


                if (obj.getIdDetalleInforme() == null) {
                    throw new ModelNotFoundException("ID NO ENCONTRADO" + id);
                }else{
                    informeOdenServicioService.eliminar(id);
                    return new ResponseEntity<InformeOrdenServicio>(obj,HttpStatus.OK);
                }



    }


    @GetMapping(value = "/listCliente")
    public ResponseEntity<List<FiltroClienteDTO>> listarCliente() {
        List<FiltroClienteDTO> clientes = new ArrayList<>();
        clientes = informeOdenServicioService.listarCliente();
        return new ResponseEntity<List<FiltroClienteDTO>>(clientes, HttpStatus.OK);
    }



}
