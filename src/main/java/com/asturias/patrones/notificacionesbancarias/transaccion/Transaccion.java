package com.asturias.patrones.notificacionesbancarias.transaccion;

import com.asturias.patrones.notificacionesbancarias.model.User;

import java.math.BigDecimal;

public interface Transaccion {
    void movimiento(BigDecimal monto, User usuario);
}
