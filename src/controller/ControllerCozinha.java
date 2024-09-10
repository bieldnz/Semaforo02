package controller;

import java.util.concurrent.Semaphore;

public class ControllerCozinha extends Thread{

	private int threadId;
	Semaphore semaforo;
	
	public ControllerCozinha(int threadId, Semaphore semaforo) {
		this.threadId = threadId;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		cozinhar();
		try {
			semaforo.acquire();
			pronto();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}
	
	private void cozinhar() {
		int tempo, cont = 0;
		if(threadId%2 == 0) {
			System.out.println("A lasanha e bolonhesa esta sendo preparada");
			tempo = (int)((Math.random()*600)+600);
		}else {
			System.out.println("A sopa de cebola esta sendo preparada");
			tempo = (int)((Math.random()*300)+500);
		}
		while(cont <= tempo) {
			cont += 100;
			System.out.println("#"+threadId+" "+(cont/(tempo/100))+"%");
		}
	}
	
	private void pronto() {
		System.out.println("O prato #"+threadId+" está pronto");
	}
	
}
