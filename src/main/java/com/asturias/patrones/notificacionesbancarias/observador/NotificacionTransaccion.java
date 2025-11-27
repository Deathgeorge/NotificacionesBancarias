package com.asturias.patrones.notificacionesbancarias.observador;

import com.asturias.patrones.notificacionesbancarias.model.User;
import com.asturias.patrones.notificacionesbancarias.observador.Observador;
import com.asturias.patrones.notificacionesbancarias.observador.Sujeto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NotificacionTransaccion implements Sujeto {

    private List<Observador> observadores = new ArrayList<>();


    @Override
    public void agregarObservador(Observador o) {
        observadores.add(o);
    }
    @Override
    public void eliminarObservador(Observador o) {
        observadores.remove(o);

    }
    @Override
    public void notificarObservadores(BigDecimal amountTx, User usuario) {
        for (Observador o : observadores) {
            o.actualizar(amountTx, usuario);
        }
    }

}
