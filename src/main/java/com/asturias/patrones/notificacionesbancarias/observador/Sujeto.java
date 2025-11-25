package com.asturias.patrones.notificacionesbancarias.observador;

import com.asturias.patrones.notificacionesbancarias.model.User;

import java.math.BigDecimal;

public interface Sujeto {
    // Sujeto
    void agregarObservador(Observador o);
    void eliminarObservador(Observador o);
    void notificarObservadores(BigDecimal amountTx, User usuario);
}
