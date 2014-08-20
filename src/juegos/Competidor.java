/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package juegos;

import base.Ficha;
import base.Juego;

/**
 *
 * @author fitorec
 */
public abstract class Competidor {
	abstract public Ficha tiroGanador();
	abstract public Ficha tiroDefensa();
	abstract public Ficha tiroEstrategia();
	abstract public Ficha forzarTiro();
        protected int tiempoEspera = 1000;

	public Character valor = 'x';

	public Competidor(Character v) {
		this.valor(v);
	}

	public void tirar() {
		this.esperar();
		Ficha fichaTirada = tiroGanador(); 
		if (fichaTirada == null) {
			fichaTirada = tiroDefensa(); //Sino es tiro ganador intenta un tiro de defensa
			if (fichaTirada == null) {
				fichaTirada = tiroEstrategia(); //Sino es tiro de defensa intenta un tiro con estrategia
				if (fichaTirada == null) {
					fichaTirada = forzarTiro(); //Sino es tiro de estrategia realiza un tiro forzado
				}
			}
		}
		if (fichaTirada != null) {
			Juego.marcarFicha(fichaTirada.fila, fichaTirada.columna, this.valor);
		} else {
			System.out.println("Error tiro nulo"); 
		}
	}
	public Character valor(Character v) {
		this.valor = v;
		return this.valor();
	}
	public Character valor() {
		return this.valor;
	}
	public void esperar() {
		try {
	    	Thread.sleep(this.tiempoEspera);
	    }
	    catch(Exception es){
	    	
	    }
	}
}