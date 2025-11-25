package com.asturias.patrones.notificacionesbancarias.observador;

import com.asturias.patrones.notificacionesbancarias.model.User;

import java.math.BigDecimal;

public interface Observador {
    void actualizar(BigDecimal amountTransacction, User usuario);
}
