package com.tuempresa.gestorproyectos.modelo;

import javax.persistence.*;

import lombok.*;

@Embeddable
@Getter
@Setter
public class ProyectoMember {

    @Column(length = 50)
    private String memberName;

    // Puedes agregar más propiedades según sea necesario para los miembros del proyecto
}
