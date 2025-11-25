package com.asturias.patrones.notificacionesbancarias;

import com.asturias.patrones.notificacionesbancarias.model.User;
import com.asturias.patrones.notificacionesbancarias.tipoNotificacionImpl.Email;
import com.asturias.patrones.notificacionesbancarias.tipoNotificacionImpl.Push;
import com.asturias.patrones.notificacionesbancarias.tipoNotificacionImpl.SMS;
import com.asturias.patrones.notificacionesbancarias.tipoNotificacionImpl.creador.CreadorEMail;
import com.asturias.patrones.notificacionesbancarias.tipoNotificacionImpl.creador.CreadorNotificacion;
import com.asturias.patrones.notificacionesbancarias.tipoNotificacionImpl.creador.CreadorPush;
import com.asturias.patrones.notificacionesbancarias.tipoNotificacionImpl.creador.CreadorSMS;
import com.asturias.patrones.notificacionesbancarias.transaccion.Consignacion;
import com.asturias.patrones.notificacionesbancarias.transaccion.EstrategiaTransaccion;
import com.asturias.patrones.notificacionesbancarias.transaccion.Retiro;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);


    public static void main(String[] args){

        boolean ejecutando = true;


        CreadorNotificacion creadorNotificacionMail = new CreadorEMail();
        Notificacion notEmail =  creadorNotificacionMail.crearNotificacion();
        Email notiEmail = (Email) notEmail;
        CreadorNotificacion creadorNotificacionPush = new CreadorPush();
        Notificacion notPush = creadorNotificacionPush.crearNotificacion();
        Push notiPush = (Push) notPush;
        CreadorNotificacion creadorNotificacion = new CreadorSMS();
        Notificacion notSMS = creadorNotificacion.crearNotificacion();
        SMS notiSMS = (SMS) notSMS;


        Scanner scanner = new Scanner(System.in);
        logger.info("Bienvenido a las Notificaciones Bancarias Jorge Castro");
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

        EstrategiaTransaccion tx = new EstrategiaTransaccion();
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
                            tx.agregarObservador(notiSMS);
                            break;
                        case 2:
                            tx.eliminarObservador(notiSMS);
                            break;
                        case 3:
                            tx.agregarObservador(notiEmail);
                            break;
                        case 4:
                            tx.eliminarObservador(notiEmail);
                            break;
                        case 5:
                            tx.agregarObservador(notiPush);
                            break;
                        case 6:
                            tx.eliminarObservador(notiPush);
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

//        notEmail.enviar("Retiraste " + usuario.getAmount());




    }
}
