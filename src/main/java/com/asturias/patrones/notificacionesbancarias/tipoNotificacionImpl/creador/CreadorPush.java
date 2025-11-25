package com.asturias.patrones.notificacionesbancarias.tipoNotificacionImpl.creador;

import com.asturias.patrones.notificacionesbancarias.Notificacion;
import com.asturias.patrones.notificacionesbancarias.tipoNotificacionImpl.Push;

public class CreadorPush extends CreadorNotificacion {
    @Override
    public Notificacion crearNotificacion() {
        return new Push();
    }
}
