package com.aluracursos.forohub.domain.topico;

public class TopicoRegistradoRespuesta {
    private String titulo;
    private Long idUsuario;

    public TopicoRegistradoRespuesta(String titulo, Long idUsuario) {
        this.titulo = titulo;
        this.idUsuario = idUsuario;
    }

    // Getters y setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
