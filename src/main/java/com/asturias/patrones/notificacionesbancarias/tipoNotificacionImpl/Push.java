package com.asturias.patrones.notificacionesbancarias.tipoNotificacionImpl;

import com.asturias.patrones.notificacionesbancarias.Notificacion;
import com.asturias.patrones.notificacionesbancarias.model.User;
import com.asturias.patrones.notificacionesbancarias.observador.Observador;

import java.math.BigDecimal;

public class Push implements Notificacion, Observador {
    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando Mensaje Push: " + mensaje);
    }
    @Override
    public void actualizar(BigDecimal amountTransacction, User usuario) {

        enviar("Senor "+ usuario.getName() + " detectamos un movimiento por " + amountTransacction);
    }

}
