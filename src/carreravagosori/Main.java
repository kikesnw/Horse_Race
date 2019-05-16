/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carreravagosori;

import java.util.Scanner;

/**
 *
 * @author Nikoto
 */
public class Main {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        Hilo niko;
        Hilo pedro;

        int saldo = 100;
        int apuesta = 0;
        
        niko = new Hilo("Nikoto");
        pedro = new Hilo("Pedro");
        
        System.out.println("-- ¡EMPIEZA LA CARRERA EN BREVES! --");
        
        System.out.println("Para quien quieres apostar? -> Nikoto || Pedro <-");
        String jugadorApostado = teclado.next();
        
        System.out.println("Cuanto quieres apostar? Tienes: " + saldo + "€");
        apuesta = teclado.nextInt();
        
        //Controlamos que no puedan apostar más del dinero que tienen
        while(apuesta > saldo){
            System.out.println("Lo siento vuelve a probar:");
            apuesta = teclado.nextInt();
        }
        
        niko.start();
        pedro.start();

        //Control de interrupciones + Apuestas
        while(!Hilo.interrupted()){
            if(niko.getTiempoDormido()==5){
                //si gana Niko, paramos a pedro
                pedro.interrupt();
                if(jugadorApostado.equals("Nikoto")){
                    int nuevoSaldo = saldo + apuesta*2;
                    System.out.println("¡Has ganado " + apuesta*2 + "€! Tu nuevo saldo es " + nuevoSaldo + "€");
                }else{
                    int nuevoSaldo = saldo - apuesta;
                    System.out.println("Has perdido la apuesta ): te quedan: " + nuevoSaldo + "€");
                }
                System.exit(0); //Para cerrar la ejecución del programa en cuanto gane uno
            }

            else if (pedro.getTiempoDormido()==5){
                //si gana Pedro, paramos a Niko
                niko.interrupt();
                if(jugadorApostado.equals("Pedro")){
                    int nuevoSaldo = saldo + apuesta*2;
                    System.out.println("¡Has ganado " + apuesta*2 + "€! Tu nuevo saldo es " + nuevoSaldo + "€");
                }else{
                    int nuevoSaldo = saldo - apuesta;
                    System.out.println("Has perdido la apuesta ): te quedan: " + nuevoSaldo + "€");
                }
                System.exit(0); //Para cerrar la ejecución del programa en cuanto gane uno
            }
        }
    }
}