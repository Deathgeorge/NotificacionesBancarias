package com.asturias.patrones.notificacionesbancarias.transaccion;

import com.asturias.patrones.notificacionesbancarias.logger.LoggerService;
import com.asturias.patrones.notificacionesbancarias.model.User;
import com.asturias.patrones.notificacionesbancarias.observador.Observador;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GestorTransacciones {
    private Transaccion transaccion;

    private List<Observador> observadores = new ArrayList<>();

    public void setEstrategia(Transaccion tx){
        this.transaccion = tx;
    }

    public void ejecutar(BigDecimal monto, User usuario){
        if (transaccion == null){
            LoggerService.getInstance().info("No se realizo ningun movimiento");

        } else {
            transaccion.movimiento(monto, usuario);
        }
    }
}
