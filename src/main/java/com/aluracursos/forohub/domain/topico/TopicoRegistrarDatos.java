package com.aluracursos.forohub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicoRegistrarDatos(@NotBlank
                                   String titulo,
                                   @NotBlank @NotNull
                                   String nombreCurso,
                                   @NotBlank @NotNull
                                   String mensaje,
                                   @NotNull
                                   Long idUsuario) {
}
