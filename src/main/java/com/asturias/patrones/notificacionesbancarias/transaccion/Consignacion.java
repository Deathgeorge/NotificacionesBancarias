package com.asturias.patrones.notificacionesbancarias.transaccion;

import com.asturias.patrones.notificacionesbancarias.model.User;

import java.math.BigDecimal;

public class Consignacion implements Transaccion {
    @Override
    public void movimiento(BigDecimal monto, User usuario) {
        usuario.setAmount(usuario.getAmount().add(monto));
    }


}
