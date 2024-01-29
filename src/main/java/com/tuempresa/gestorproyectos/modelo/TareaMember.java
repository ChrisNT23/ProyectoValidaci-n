package com.tuempresa.gestorproyectos.modelo;

import javax.persistence.*;

import lombok.*;

@Embeddable
@Getter
@Setter
public class TareaMember {

    @Column(length = 50)
    private String miembro;

    // Puedes agregar más propiedades según sea necesario para los miembros de la tarea
}
