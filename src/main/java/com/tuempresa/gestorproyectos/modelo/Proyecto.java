package com.tuempresa.gestorproyectos.modelo;

import java.math.*;
import java.time.*;
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.model.*;

import lombok.*;

@Entity
@Getter
@Setter
@View(members = "nombre, fechaInicio, presupuesto, teamName, projectDescription, projectMembers, estimatedEndDate")
public class Proyecto extends Identifiable {

    @Column(length = 50)
    @Required
    private String nombre;

    private LocalDate fechaInicio;

    private BigDecimal presupuesto;

    private String teamName;

    @Stereotype("TEXT_AREA")
    private String projectDescription;

    @ElementCollection
    @ListProperties("memberName") // Cambia "memberName" por el nombre de la propiedad en tu clase de miembro del proyecto
    private List<ProyectoMember> projectMembers;

    private LocalDate estimatedEndDate;
    
    @OneToMany(mappedBy = "proyecto")
    private List<Tarea> tareas;
    
    @ElementCollection
    @ListProperties("miembro") // Cambia "miembro" por el nombre de la propiedad en tu clase de miembro del proyecto
    private List<ProyectoMember> miembros;
    
  


}
