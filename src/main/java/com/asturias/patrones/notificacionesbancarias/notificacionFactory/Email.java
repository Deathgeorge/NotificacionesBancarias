package com.asturias.patrones.notificacionesbancarias.notificacionFactory;

import com.asturias.patrones.notificacionesbancarias.model.User;
import com.asturias.patrones.notificacionesbancarias.observador.Observador;

import java.math.BigDecimal;

public class Email implements Notificacion, Observador {
    @Override
    public void enviar(String mensaje) {
        System.out.println("------- Notificacion EMAIL ---> : \n"  + mensaje);
    }

    @Override
    public void actualizar(BigDecimal amountTransacction, User usuario) {

        enviar("Senor "+ usuario.getName() + " detectamos un movimiento por " + amountTransacction);
    }
}
