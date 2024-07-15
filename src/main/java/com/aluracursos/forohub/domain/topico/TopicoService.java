package com.aluracursos.forohub.domain.topico;

import com.aluracursos.forohub.domain.topico.Topico;
import com.aluracursos.forohub.domain.topico.TopicoActualizarDatos;
import com.aluracursos.forohub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    TopicoRepository topicoRepository;

    public Topico createTopico(TopicoRegistrarDatos datos) {
        topicoRepository.findByTituloAndMensaje(datos.titulo(), datos.mensaje())
                .ifPresent(existingTopico -> {
                    throw new IllegalArgumentException("Un tópico con el mismo título y mensaje ya existe.");
                });

        Topico topico = new Topico(datos);
        return topicoRepository.save(topico);
    }

    public Topico updateTopico(Long id, TopicoActualizarDatos datos) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);

        if (optionalTopico.isPresent()) {
            Topico existingTopico = optionalTopico.get();

            // Verificar si hay otro tópico con el mismo título y mensaje
            if (datos.titulo() != null && !datos.titulo().isBlank() && datos.mensaje() != null && !datos.mensaje().isBlank()) {
                topicoRepository.findByTituloAndMensaje(datos.titulo(), datos.mensaje())
                        .ifPresent(otherTopico -> {
                            if (!otherTopico.getId().equals(id)) {
                                throw new IllegalArgumentException("Otro tópico con el mismo título y mensaje ya existe.");
                            }
                        });
            }

            /*
            // Actualizar solo los campos no nulos ni en blanco
            if (datos.titulo() != null && !datos.titulo().isBlank()) {
                existingTopico.setTitulo(datos.titulo());
            }
            if (datos.nombreCurso() != null && !datos.nombreCurso().isBlank()) {
                existingTopico.setNombreCurso(datos.nombreCurso());
            }
            if (datos.mensaje() != null && !datos.mensaje().isBlank()) {
                existingTopico.setMensaje(datos.mensaje());
            }
            if (datos.idUsuario() != null) {
                existingTopico.setIdUsuario(datos.idUsuario());
            }
            */
            if (datos.titulo() != "") {
                existingTopico.setTitulo(datos.titulo());
            }
            if (datos.nombreCurso() != "") {
                existingTopico.setNombreCurso(datos.nombreCurso());
            }
            if (datos.mensaje() != "") {
                existingTopico.setMensaje(datos.mensaje());
            }
            if (datos.idUsuario() != null) {
                existingTopico.setIdUsuario(datos.idUsuario());
            }

            return topicoRepository.save(existingTopico);
        } else {
            throw new IllegalArgumentException("El tópico con ID " + id + " no existe.");
        }
    }

    public void deleteTopico(Long id) {

        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (optionalTopico.isPresent()) {
            topicoRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("El tópico con ID " + id + " no existe.");
        }

    }

}
