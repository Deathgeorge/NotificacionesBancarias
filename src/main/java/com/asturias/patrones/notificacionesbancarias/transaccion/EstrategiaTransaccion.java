package com.asturias.patrones.notificacionesbancarias.transaccion;

import com.asturias.patrones.notificacionesbancarias.model.User;
import com.asturias.patrones.notificacionesbancarias.observador.Observador;
import com.asturias.patrones.notificacionesbancarias.observador.Sujeto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EstrategiaTransaccion implements  Sujeto {
    private Transaccion transaccion;
    private static final Logger logger = LogManager.getLogger(EstrategiaTransaccion.class);

    private List<Observador> observadores = new ArrayList<>();

    public void setEstrategia(Transaccion tx){
        this.transaccion = tx;
    }

    public void ejecutar(BigDecimal monto, User usuario){
        if (transaccion == null){
            logger.info("No se realizo ningun movimiento");

        } else {
            transaccion.movimiento(monto, usuario);
            notificarObservadores(monto, usuario);
        }
    }

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
