package exercicio1;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {
		
		int permicoes = 1;
		Semaphore semaforo = new Semaphore(permicoes);
		
		for(int idOperacao=0;idOperacao<21;idOperacao++) {
			Thread t = new ThreadOperacoes(idOperacao,semaforo);
			t.start();
		}
		
	}

}
