package exercicio1;

import java.util.concurrent.Semaphore;

public class ThreadOperacoes extends Thread {
	
	private int idOperacao;
	private Semaphore semaforo;
	
	public ThreadOperacoes(int idOperacao, Semaphore semaforo) {
		this.idOperacao=idOperacao;
		this.semaforo=semaforo;
	}
	
	@Override
	public void run() {
		if(idOperacao%3==1) {
			calculosMod1();
			try {
				semaforo.acquire();
				bdMod1();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				semaforo.release();
			}
			calculosMod1();
			try {
				semaforo.acquire();
				bdMod1();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				semaforo.release();
			}
			System.out.println("######"+idOperacao+ " já fez todas as tarefas");
		}else if(idOperacao%3==2) {
			calculosMod2();
			try {
				semaforo.acquire();
				bdMod2e3();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				semaforo.release();
			}
			calculosMod2();
			try {
				semaforo.acquire();
				bdMod2e3();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				semaforo.release();
			}
			calculosMod2();
			try {
				semaforo.acquire();
				bdMod2e3();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				semaforo.release();
			}
			System.out.println("######"+idOperacao+ " já fez todas as tarefas");
		}else if(idOperacao%3==0) {
			calculosMod3();
			try {
				semaforo.acquire();
				bdMod2e3();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				semaforo.release();
			}
			calculosMod3();
			try {
				semaforo.acquire();
				bdMod2e3();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				semaforo.release();
			}
			calculosMod3();
			try {
				semaforo.acquire();
				bdMod2e3();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				semaforo.release();
			}
			System.out.println("######"+idOperacao+ " já fez todas as tarefas");
		}
	}
	
	private void calculosMod3() {
		// TODO Auto-generated method stub
		int tempo = (int) ((Math.random()*1001)+1000);
		System.out.println("thread #"+idOperacao + " está fazendo os cálculos... Aguarde");
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("thread #"+idOperacao+" finalizou os Cálculos");
	}

	private void bdMod2e3() {
		// TODO Auto-generated method stub
		int tempo = 1500;
		System.out.println("thread #"+idOperacao+" esta Fazendo Transação de BD... Aguarde");
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("thread #"+idOperacao+": Transação de BD finalizada");
	}

	private void calculosMod2() {
		// TODO Auto-generated method stub
		int tempo = (int) ((Math.random()*1001)+500);
		System.out.println("thread #"+idOperacao + " está fazendo os cálculos... Aguarde");
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("thread #"+idOperacao+" finalizou os Cálculos");
	}

	private void calculosMod1() {
		
		int tempo = (int) ((Math.random()*801)+200);
		System.out.println("thread #"+idOperacao + " está fazendo os cálculos... Aguarde");
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("thread #"+idOperacao+" finalizou os Cálculos");
	}
	

	private void bdMod1() {
		int tempo = 1000;
		System.out.println("thread #"+idOperacao+" esta Fazendo Transação de BD... Aguarde");
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("thread #"+idOperacao+": Transação de BD finalizada");
	}
	
	
	
}

	

