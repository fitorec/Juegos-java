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
public class CuatroEnRayaMaquina extends Competidor {
	/**
	 * Constructor
	 */
	public CuatroEnRayaMaquina(Character valor) {
		super(valor);
	}

	/**
	 * 
	 */
	public Ficha tiroGanador() {
		return null;
	}

	/**
	 * 
	 */
	public Ficha tiroDefensa() {
		return null;
	}

	/**
	 * 
	 */
	public Ficha tiroEstrategia() {
		return null;
	}

	/**
	 * 
	 */
	public Ficha forzarTiro() {
		int c = 0;
		int f = 0;
		do {
			c = Juego.randColumna();
			for(f = Juego.filas() - 1; f>=0;  f--) {
				Ficha ficha = Juego.ficha(f, c);
				if(!ficha.activa) {
					return ficha;
				}
			}
		} while (true);
	}
}
