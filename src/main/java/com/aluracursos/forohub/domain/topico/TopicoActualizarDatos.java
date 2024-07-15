package com.aluracursos.forohub.domain.topico;

import jakarta.annotation.Nullable;

public record TopicoActualizarDatos(
        @Nullable String titulo,
        @Nullable String nombreCurso,
        @Nullable String mensaje,
        @Nullable Long idUsuario) {
}
