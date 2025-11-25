package com.asturias.patrones.notificacionesbancarias.transaccion;

import com.asturias.patrones.notificacionesbancarias.model.User;
import com.asturias.patrones.notificacionesbancarias.observador.Observador;
import com.asturias.patrones.notificacionesbancarias.observador.Sujeto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Retiro implements Transaccion {

    @Override
    public void movimiento(BigDecimal monto, User usuario) {

        usuario.setAmount(usuario.getAmount().subtract(monto));
    }

}
