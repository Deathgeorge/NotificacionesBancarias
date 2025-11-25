package com.asturias.patrones.notificacionesbancarias.tipoNotificacionImpl.creador;

import com.asturias.patrones.notificacionesbancarias.Notificacion;
import com.asturias.patrones.notificacionesbancarias.tipoNotificacionImpl.Email;

public class CreadorEMail extends CreadorNotificacion {
    @Override
    public Notificacion crearNotificacion() {
        return new Email();
    }
}
