package com.asturias.patrones.notificacionesbancarias.transaccion;

import com.asturias.patrones.notificacionesbancarias.logger.LoggerService;
import com.asturias.patrones.notificacionesbancarias.model.User;


import java.math.BigDecimal;

public class GestorTransacciones {
    private Transaccion transaccion;

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
