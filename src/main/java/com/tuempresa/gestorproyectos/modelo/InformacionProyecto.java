package com.tuempresa.gestorproyectos.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.model.*;

import lombok.*;

@Entity
@Getter
@Setter
public class InformacionProyecto extends Identifiable {

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @DescriptionsList(
        descriptionProperties = "nombre",
        order = "nombre asc"
    )
    private Proyecto proyecto;

    @Column(length = 100)
    @ReadOnly
    private String tareas;

    @Column(length = 50)
    @ReadOnly
    private String progreso;

    @Column(length = 50)
    @ReadOnly
    private String eficacia;

    // Otros atributos y métodos de la clase...

    @RowAction("GuardarProyecto")
    public void guardarProyecto() {
        // Lógica para guardar el proyecto

        // Obtener el número de tareas relacionadas con el proyecto
        int numeroTareas = 0;
        if (proyecto != null && proyecto.getTareas() != null) {
            numeroTareas = proyecto.getTareas().size();
            tareas = String.valueOf(numeroTareas);
        }

        // Recalcular progreso y eficiencia si una tarea cambió a "Hecho"
        if (proyecto != null && proyecto.getTareas() != null) {
            int tareasHechas = 0;

            for (Tarea tarea : proyecto.getTareas()) {
                if (tarea.getEstado() == EstadoTarea.HECHO) {
                    tareasHechas++;
                }
            }

            // Lógica de cálculo: (Tareas Hechas / Total Tareas) * 100
            double porcentajeProgreso = ((double) tareasHechas / numeroTareas) * 100;
            progreso = String.format("%.2f", porcentajeProgreso) + "%";

            // Lógica de cálculo de eficiencia
            // (Esto es solo un ejemplo, puedes ajustar la lógica según tus necesidades)
            double eficaciaCalculada = porcentajeProgreso * 0.8; // Ejemplo arbitrario
            eficacia = String.format("%.2f", eficaciaCalculada) + "%";
        }
    }
}
