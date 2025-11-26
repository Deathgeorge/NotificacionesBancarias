package com.asturias.patrones.notificacionesbancarias.tipoNotificacionImpl;

import com.asturias.patrones.notificacionesbancarias.Notificacion;

public class NoficacionFactory {
    public static Notificacion crearNotificacion(String tipo) {
        switch(tipo.toUpperCase()) {
            case "EMAIL": return new Email();
            case "SMS": return new SMS();
            case "PUSH": return new Push();
            default: throw new IllegalArgumentException("Tipo no válido: " + tipo);
        }
    }
}
