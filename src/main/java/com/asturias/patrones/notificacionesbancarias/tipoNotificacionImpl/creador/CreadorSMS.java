package com.asturias.patrones.notificacionesbancarias.tipoNotificacionImpl.creador;

import com.asturias.patrones.notificacionesbancarias.Notificacion;
import com.asturias.patrones.notificacionesbancarias.tipoNotificacionImpl.SMS;

public class CreadorSMS extends CreadorNotificacion{
    @Override
    public Notificacion crearNotificacion() {
        return new SMS();
    }
}
