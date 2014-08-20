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
public class MemoramaMaquina extends Competidor {

    public int turnosAcertados = 0;

    /**
     * Constructor
     */
    public MemoramaMaquina(Character valor) {
        super(valor);
        this.tiempoEspera = 500;
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
        Ficha ficha1 = null;
        Ficha ficha2 = null;
        do {
            f = Juego.randFila();
            c = Juego.randColumna();
            ficha1 = Juego.ficha(f, c);
        } while (ficha1.activa);
        ficha1.vista = true;
        ficha1.valor = ficha1.valorMemorama;
        //Imprimimos y nos esperamos
        Juego.print();
        this.esperar();
        //Buscamos la ficha 2, diferente en posicion la ficha1
        do {
            f = Juego.randFila();
            c = Juego.randColumna();
            ficha2 = Juego.ficha(f, c);
        } while ((c == ficha1.columna && f == ficha1.fila) || ficha2.activa);
        ficha2.vista = true;
        ficha2.valor = ficha2.valorMemorama;
        Juego.print();
        this.esperar();
        if (ficha2.valor == ficha1.valor) {
            System.out.println(
                    "Las Fichas f1(" + ficha2.fila + "," + ficha2.columna + ")= " + ficha2.valor
                    + " y  f2(" + ficha1.fila + "," + ficha1.columna + ")= " + ficha1.valor + " Coinciden "
                    + " Tiro jugador " + this.valor
            );
            Juego.marcarFicha(ficha2.fila, ficha2.columna, ficha2.valor);
            Juego.marcarFicha(ficha1.fila, ficha1.columna, ficha1.valor);
            Juego.print();
            this.turnosAcertados++;
            this.esperar();
            this.esperar();
        } else {
            ficha1.valor = ' ';
            ficha2.valor = ' ';
        }
        return null;
    }
}
