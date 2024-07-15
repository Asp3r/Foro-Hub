package com.aluracursos.forohub.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

//Esta clase la hice porque antes la consola me daba warning de que la respuesta de JSON
//con Page y Pageable podria ser inestable y no estaba garantizada la consistencia. Esto
//aparentemente lo soluciona y hace que la respuesta sea estable

@Configuration
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class WebConfig {
    // configuración adicional si es necesario
}

