package com.asturias.patrones.notificacionesbancarias.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class LoggerService {
    private static LoggerService instance;
    private final Logger logger;

    private LoggerService() {
        this.logger = LogManager.getLogger("SistemaBancario");
    }

    public static LoggerService getInstance() {
        if (instance == null) {
            instance = new LoggerService();
        }
        return instance;
    }

    public void info(String mensaje) {
        logger.info(mensaje);
    }

    public void error(String mensaje) {
        logger.error(mensaje);
    }

    public void warn(String mensaje) {
        logger.warn(mensaje);
    }
}
