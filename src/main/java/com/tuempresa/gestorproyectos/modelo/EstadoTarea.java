package com.tuempresa.gestorproyectos.modelo;

public enum EstadoTarea {
    POR_HACER("Por Hacer"),
    EN_PROGRESO("En Progreso"),
    HECHO("Hecho");

    private final String label;

    EstadoTarea(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
