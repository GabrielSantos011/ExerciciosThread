package exercicio2;

import java.util.concurrent.Semaphore;


public class Pratos {
	public static void main(String[] args) {
		
		
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int idPrato=0; idPrato<5; idPrato++) {
			Thread t = new ThreadPratos(idPrato, semaforo);
			t.start();
		
		}

	}
}
