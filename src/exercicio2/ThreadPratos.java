package exercicio2;

import java.util.concurrent.Semaphore;

public class ThreadPratos extends Thread {
	
	private int idPrato;
	private Semaphore semaforo;
	
	public ThreadPratos(int idPrato, Semaphore semaforo) {
		this.idPrato=idPrato;
		this.semaforo=semaforo;
	}
	
	@Override
	public void run() {
		
		cozinha();
		try {
			semaforo.acquire();
			entrega();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
		
	}

	private void entrega() {
		int tempo = 500;
		System.out.println("O prato #"+idPrato + " foi para a entrega");
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("O prato #"+idPrato + " foi entregue"+"\n##############################");
		
	}

	private void cozinha() {
		if(idPrato%2==0) {
			double porcentagem = 0;
			double tempoParcial = 0;
			double tempoTotal =(int) ((Math.random()*601)+600);
			System.out.println("#"+idPrato+" A lasanha esta sendo preparada");
			while(tempoParcial<tempoTotal) {
				tempoParcial+=100;
				porcentagem += (int)(tempoTotal/100);
				System.out.println("#"+idPrato+" ja está "+porcentagem+"% concluido");
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("#"+idPrato +": A lasanha está pronta");
		}else {
			double porcentagem = 0;
			double tempoParcial = 0;
			double tempoTotal =(int) ((Math.random()*301)+500);
			System.out.println("#"+idPrato+" A sopa de cebola esta sendo preparada");
			while(tempoParcial<tempoTotal) {
				tempoParcial+=100;
				porcentagem = (int) (tempoTotal/tempoParcial)*100;
				System.out.println("#"+idPrato+" ja está "+porcentagem+"% concluido");
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("#"+idPrato +": A lasanha está pronta");
		}
		
	}

}
