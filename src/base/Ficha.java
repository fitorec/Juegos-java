/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package base;

/**
 *
 * @author fitorec
 */
public class Ficha {
	public Character valor = ' ';
	public boolean activa  = false;
	public int fila        = 0;
	public int columna     = 0;
        /**
	 * Control para el Memorama
	 */
	public Character valorMemorama = ' ';   // valor en caso que sea el memorama
	public boolean vista         = false; // Por defecto 

	/**
	 * Constructor de la ficha
	 * 
	 * @param f el número de fila
	 * @param c el número de columna
	 */
	public Ficha(int f, int c) {
		this.fila = f;
		this.columna = c;
	}
}
