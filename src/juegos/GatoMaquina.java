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
public class GatoMaquina extends Competidor {

	/**
	 * Constructor
	 */
	public GatoMaquina(Character valor) {
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
                    f = Juego.randFila();
                    c = Juego.randColumna();
		} while (Juego.fichaActiva(f, c));
		return Juego.ficha(f, c);
	}


}
