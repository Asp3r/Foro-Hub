package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.domain.topico.Topico;
import com.aluracursos.forohub.domain.topico.TopicoRegistradoRespuesta;
import com.aluracursos.forohub.domain.topico.TopicoRegistrarDatos;
import com.aluracursos.forohub.domain.topico.TopicoActualizarDatos;
import com.aluracursos.forohub.domain.topico.TopicoRepository;
import com.aluracursos.forohub.validaciones.ErrorResponse;
import com.aluracursos.forohub.domain.topico.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    TopicoService topicoService;

    @PostMapping
    public ResponseEntity<?> createTopico(@RequestBody @Valid TopicoRegistrarDatos datos) {
        try {
            Topico topico = topicoService.createTopico(datos);
            TopicoRegistradoRespuesta respuesta =
                    new TopicoRegistradoRespuesta(topico.getTitulo(), topico.getIdUsuario());
            return ResponseEntity.ok(respuesta);
        } catch (IllegalArgumentException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTopico(@PathVariable Long id, @RequestBody @Valid TopicoActualizarDatos datos) {
        try {
            Topico topico = topicoService.updateTopico(id, datos);
            TopicoRegistradoRespuesta respuesta =
                    new TopicoRegistradoRespuesta(topico.getTitulo(), topico.getIdUsuario());
            return ResponseEntity.ok(respuesta);
        } catch (IllegalArgumentException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity mostrarTopicoEspecifico(@PathVariable Long id){

        if (topicoRepository.existsById(id)){
            return ResponseEntity.ok(topicoRepository.findById(id));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("id incorrecto");
        }


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTopico(@PathVariable Long id) {
        try {
            topicoService.deleteTopico(id);
            return ResponseEntity.ok("Borrado con éxito");
        } catch (IllegalArgumentException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @GetMapping
    public List<Topico> listadoTopicos() {
        return topicoRepository.findAll();
    }
}
