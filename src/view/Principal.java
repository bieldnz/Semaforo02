package view;

import java.util.concurrent.Semaphore;

import controller.ControllerCozinha;

public class Principal {
	public static void main(String[] args) {
		
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		//System.out.println("KB");
		for(int x = 1; x <= 5; x++) {
			ControllerCozinha cozinha = new ControllerCozinha(x, semaforo);
			cozinha.start();
		}
		
	}
}
