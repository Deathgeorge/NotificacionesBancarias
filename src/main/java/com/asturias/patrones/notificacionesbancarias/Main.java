package com.asturias.patrones.notificacionesbancarias;

import com.asturias.patrones.notificacionesbancarias.logger.LoggerService;
import com.asturias.patrones.notificacionesbancarias.model.User;
import com.asturias.patrones.notificacionesbancarias.notificacionFactory.*;
import com.asturias.patrones.notificacionesbancarias.observador.NotificacionTransaccion;
import com.asturias.patrones.notificacionesbancarias.transaccion.*;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {



    public static void main(String[] args){

        boolean ejecutando = true;


        NotificacionTransaccion notificador = new NotificacionTransaccion();

        Notificacion notEmail =  NoficacionFactory.crearNotificacion("EMAIL");
        Email notiEmail = (Email) notEmail;
        Notificacion notPush = NoficacionFactory.crearNotificacion("PUSH");
        Push notiPush = (Push) notPush;
        Notificacion notSMS = NoficacionFactory.crearNotificacion("SMS");
        SMS notiSMS = (SMS) notSMS;


        Scanner scanner = new Scanner(System.in);
        LoggerService.getInstance().info("Bienvenido a las Notificaciones Bancarias Jorge Castro");
        System.out.println("Bienvenido a las Notificaciones Bancarias Jorge Castro");

        System.out.println("Ingresa tu nombre");

        String nameUser = scanner.nextLine();

        System.out.println("Ingresa tu numero de cuenta");
        BigDecimal numberAccount = scanner.nextBigDecimal();

        User usuario = new User(nameUser, numberAccount);

        System.out.println("tu cuenta tiene --- >" + usuario.getAmount());
        BigDecimal amountTrans;
        int opc;
        int opcNot;

        GestorTransacciones tx = new GestorTransacciones();
        while (ejecutando){
            System.out.println("Que accion desea realizar:");
            System.out.println("1. Retirar:");
            System.out.println("2. Consignar:");
            System.out.println("3. Configurar notificaciones:");
            System.out.println("4. Salir:");
            opc = scanner.nextInt();
            switch (opc){
                case 1:

                    System.out.println("Ingresa el monto que deseas retirar");
                    amountTrans = scanner.nextBigDecimal();

                    tx.setEstrategia(new Retiro());
                    tx.ejecutar(amountTrans, usuario);
                    notificador.notificarObservadores(amountTrans, usuario);
                    break;
                case 2:

                    System.out.println("Ingresa el monto que deseas Consignar");
                    amountTrans = scanner.nextBigDecimal();
                    tx.setEstrategia(new Consignacion());
                    tx.ejecutar(amountTrans, usuario);
                    break;
                case 3:
                    System.out.println("Que accion desea realizar:");
                    System.out.println("1. Suscribirse a notificaciones SMS:");
                    System.out.println("2. Desuscribirse a notificaciones SMS:");
                    System.out.println("3. Suscribirse a notificaciones Email:");
                    System.out.println("4. Desuscribirse a notificaciones Email:");
                    System.out.println("5. Suscribirse a notificaciones Push:");
                    System.out.println("6. Desuscribirse a notificaciones Push:");
                    System.out.println("7. Salir:");
                    opcNot = scanner.nextInt();
                    switch (opcNot){
                        case 1:
                            notificador.agregarObservador(notiSMS);
                            break;
                        case 2:
                            notificador.eliminarObservador(notiSMS);
                            break;
                        case 3:
                            notificador.agregarObservador(notiEmail);
                            break;
                        case 4:
                            notificador.eliminarObservador(notiEmail);
                            break;
                        case 5:
                            notificador.agregarObservador(notiPush);
                            break;
                        case 6:
                            notificador.eliminarObservador(notiPush);
                            break;
                        case 7:
                            System.out.println("Volver al menu anterior");
                            break;
                    }
                    break;
                case 4:
                    ejecutando = false;
                    break;
                default:
                    break;
            }


            System.out.println("tu cuenta tiene --- >" + usuario.getAmount());
        }





    }
}
