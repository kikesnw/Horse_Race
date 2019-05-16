package carreravagosori;

import java.util.Scanner;

class Hilo extends Thread {

	private int tiempoDormido;
        
	public Hilo(String str) {
            super(str);
	}
        
        public void dormir() throws InterruptedException{
            sleep((long)(Math.random() * 1000));
        }

        @Override
	public void run() {
            for (int i=0; i<5; i++){
                try{
                    dormir();
                    tiempoDormido++;
                    System.out.println(getName() + " ha dormido: " + tiempoDormido + " segundos"); 
                } catch(InterruptedException e){}
            }

            if(tiempoDormido == 5 && getName().equals("Nikoto")){         
                System.out.println("-- NIKOTO ha ganado --");
                System.out.println("\n");
            }

            else if(tiempoDormido == 5 && getName().equals("Pedro")){
                System.out.println("-- PEDRO ha ganado --");
                System.out.println("\n");
            }
        }
	
	public int getTiempoDormido(){
            return tiempoDormido;
	}
}