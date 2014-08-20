package base;

import java.util.Random;
import java.util.Vector;
import juegos.Competidor;

/**
 *
 * @author fitorec
 */
public class Juego {
	private static Vector<Ficha> tablero = new Vector<Ficha>();
	private static int filas;
	private static int columnas;
	private static int fichasActivas = 0;
	private static String nombre = "";
	private static Competidor competidor_1;
	private static Competidor competidor_2;
	private static String turnoActual = "competidor_1";
	private static int fichasContinuasLimite = 0;

	/**
	 * Constructor
	 * 
	 **/
	public static void iniciar(String nombre_juego, Competidor c1, Competidor c2) {
		Juego.setJuego(nombre_juego);
		Juego.fichasActivas = 0;
		Juego.competidor_1 = c1;
		Juego.competidor_2 = c2;
		if( randInt(0, 1) == 0) {
			Juego.turnoActual = "competidor_1";
		} else {
			Juego.turnoActual = "competidor_2";
		}
		//Inicamos el juego
		int numIteraciones = 0;
		while(Juego.iteracion()) {
			numIteraciones++;
			System.out.println("Iteración: " + numIteraciones);
		}
	}//IniciarJuego
	
	public static void setJuego(String nombre_juego) {
		Juego.nombre = nombre_juego.toLowerCase();
                Vector<Character> mapaDomino = new Vector<Character>();
		if (null != Juego.nombre) {
                    switch (Juego.nombre) {
                    case "gato":
                        Juego.filas    = 3;
                        Juego.columnas = 3;
                        Juego.fichasContinuasLimite = 3;
                        break;
                    case "cuatro-en-raya":
                        Juego.filas    = 6;
                        Juego.columnas = 7;
                        Juego.fichasContinuasLimite = 4;
                        break;
                    case "memorama":
                        Juego.filas    = 4;
                        Juego.columnas = 4;
                        //Generamos 8 caracteris distintos para el memorama
                        char mapa[] = {
                                '$', '@' , '+',
                            '0', '<', '=' , '*'
                        };
                        mapaDomino.add('#');
                        mapaDomino.add('#');
                        for(int i=0; i<mapa.length; i++) {
                            int randIndex = randInt(0, mapaDomino.size() -1);
                            mapaDomino.add(randIndex, mapa[i]);
                            randIndex = randInt(0, mapaDomino.size() -1);
                            mapaDomino.add(randIndex, mapa[i]);
                        }
                        break;
                    }
                }
		Juego.tablero.removeAllElements();
		for(int f = 0; f < Juego.filas; f++) {
			for(int c = 0; c < Juego.columnas; c++) {
                                Ficha ficha = new Ficha(f, c);
                                if(Juego.nombre.equals("memorama")) {
                                    ficha.valorMemorama = mapaDomino.get(0);
                                    mapaDomino.remove(0);
                                }
                                Juego.tablero.add(ficha);
			}// fin for sobre columnas
		}// for sobre filas
	}

	/**
	 * Realiza una iteracion esto es darle el el tiro al turno actual y luego cambiarlo al otro
	 * 
	 * @return boolean true:  si el juego continua
	 *                 false: si el juego conclujye
	 * 
	 */
	public static boolean iteracion() {
		Juego.print();
		if(Juego.finJuego()) {
			System.out.print("El Juego concluyo");
			return false;
		}
		if (Juego.turnoActual.equals("competidor_1")) {
			Juego.competidor_1.tirar();
			Juego.turnoActual = "competidor_2";
		} else {
			Juego.competidor_2.tirar();
			Juego.turnoActual = "competidor_1";
		}
		return true;
	}


	public static void print() {
		try {
			Runtime.getRuntime().exec("cls");
	    } catch (final Exception e) {
	        //  Handle any exceptions.
	    }
		char valor = Juego.competidor_1.valor;
		if (Juego.turnoActual.equals("competidor_2") ) {
			valor = Juego.competidor_2.valor;
		}
		System.out.println("Tirador Actual : " + valor);
		for(int f = 0; f < Juego.filas; f++) {
			String saltoLinea = "";
			for(int c = 0; c < Juego.columnas; c++) {
				System.out.print(" |" + Juego.fichaValor(f,c));
				saltoLinea += "---";
				//Juego.tablero.get(arg0)(new Ficha(f, c));
			}//fin for sobre columnas
			System.out.println("\n " + saltoLinea);
		}//fin for sobre filas
	}

	public static boolean finJuego() {
		if (Juego.fichasActivas == Juego.filas * Juego.columnas) {
			return true;
		}
		if ("memorama".equals(Juego.nombre)) {
			return false;
		}
		// Revisando las filas
		int f, c;
		for(f = 0; f < Juego.filas; f++) {
			Character caracterActual = ' ';
			int numRepeticiones = 0;
			for(c = 0; c < Juego.columnas; c++) {
				Ficha ficha = Juego.tablero.get(Juego.indiceFicha(f, c));
				if (ficha.valor.equals(caracterActual) && !caracterActual.equals(' ')) {
					numRepeticiones++;
				} else {
					numRepeticiones = 1;
					caracterActual = ficha.valor;
					continue;
				}
			}//fin for sobre filas
			if(numRepeticiones >= Juego.fichasContinuasLimite) {
				return true;
			}
		}//fin for sobre filas
		// Revisando las columnas
		for(c = 0; c < Juego.columnas; c++) {
			Character caracterActual = ' ';
			int numRepeticiones = 0;
			for(f = 0; f < Juego.filas; f++) {
				Ficha ficha = Juego.tablero.get(Juego.indiceFicha(f, c));
				if (ficha.valor.equals(caracterActual) && !caracterActual.equals(' ')) {
					numRepeticiones++;
				} else {
					numRepeticiones = 1;
					caracterActual = ficha.valor;
					continue;
				}
			}//fin for sobre filas
			if(numRepeticiones >= Juego.fichasContinuasLimite) {
				return true;
			}
		}//fin for sobre columnas
		/**
		 * Revisa el numero de tiros en diagonales de forma incremental
		 */
		for(c = 0; c < Juego.columnas; c++) {
			revisarOtraFicha:
			for(f = 0; f < Juego.filas; f++) {
				Ficha ficha = Juego.tablero.get(Juego.indiceFicha(f, c));
				if(ficha.activa == false) {
					continue;
				}
				Character caracterActual = ficha.valor;
				int numRepeticiones = 0;
				for(int cL2 = c; cL2 < Juego.columnas; cL2++) {
					for(int fL2 = f; fL2 < Juego.filas; fL2++) {
						Ficha ficha2 = Juego.tablero.get(Juego.indiceFicha(f, cL2));
						if(ficha2.activa == false || ficha2.valor.equals(caracterActual)) {
							break revisarOtraFicha;
						}
						numRepeticiones++;
						if(numRepeticiones >= Juego.fichasContinuasLimite) {
							return true;
						}
					}
				}
			}
		}//fin for sobre columnas
		/**
		 * Revisa el numero de tiros en diagonales de forma incremental
		 */
		for(c = 0; c < Juego.columnas; c++) {
			revisarOtraFicha:
			for(f = 0; f < Juego.filas; f++) {
				Ficha ficha = Juego.tablero.get(Juego.indiceFicha(f, c));
				if(ficha.activa == false) {
					continue;
				}
				Character caracterActual = ficha.valor;
				int numRepeticiones = 0;
				for(int cL2 = c; cL2 >= 0; cL2--) {
					for(int fL2 = f; fL2 >= 0; fL2--) {
						Ficha ficha2 = Juego.tablero.get(Juego.indiceFicha(f, cL2));
						if(ficha2.activa == false || ficha2.valor.equals(caracterActual)) {
							break revisarOtraFicha;
						}
						numRepeticiones++;
						if(numRepeticiones >= Juego.fichasContinuasLimite) {
							return true;
						}
					}
				}
			}
		}//fin for sobre columnas
		return false;
	}

	/**
	 * El indice de la ficha correspondiente
	 * 
	 * @param f_pos posicion fila
	 * @param c_pos posicion columa
	 * @return
	 */
	public static Integer indiceFicha(int f_pos, int c_pos) {
		Integer indice = 0;
		Integer tableroSize = Juego.tablero.size();
		for(; indice < tableroSize; indice++) {
			Ficha ficha = Juego.tablero.get(indice);
			if(ficha.fila == f_pos && ficha.columna == c_pos) {
				return indice;
			}
		}
		return null;
	}

	public static Ficha ficha(int f_pos, int c_pos) {
		Integer indice = Juego.indiceFicha(f_pos, c_pos);
		if (indice != null) {
			return Juego.tablero.get(indice);
		}
		return null;
	}
	
	public static Character fichaValor(int f_pos, int c_pos) {
		Ficha ficha = Juego.ficha(f_pos, c_pos);
		if (ficha != null) {
			return ficha.valor;
		}
		return null;
	}

	public static boolean fichaActiva(int f_pos, int c_pos) {
		Integer indice = Juego.indiceFicha(f_pos, c_pos);
		if (indice != null) {
			return Juego.tablero.get(indice).activa;
		}
		return false;
	}

	public static void marcarFicha(int f_pos, int c_pos, Character valor) {
		Integer indice = Juego.indiceFicha(f_pos, c_pos);
		if (indice != null && Juego.tablero.get(indice).activa == false) {
			Juego.tablero.get(indice).valor  = valor;
			Juego.tablero.get(indice).activa = true;
			Juego.fichasActivas++;
		}
	}

	/**
	 * Regresa la cantidad de fichas activas
	 * 
	 * @return
	 */
	public static int fichasActivas() {
		return Juego.fichasActivas;
	}
	///
	public static int filas() {
		return Juego.filas;
	}
	public static int columnas() {
		return Juego.columnas;
	}
	/**
	 * Devuelve un numero areatorio en el rango [min, max]
	 * 
	 * @param min
	 * @param max
	 * @return un numero areatorio en el rango [min, max]
	 */
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}

	/**
	 * Devuelve un numero entero en el rango de las filas
	 * 
	 * @return fila [0 - Juego.filas - 1]
	 **/
	public static int randFila() {
		return Juego.randInt(0, Juego.filas - 1);
	}

	/**
	 * Devuelve un numero entero en el rango de las columnas
	 * 
	 * @return columna [0 - Juego.columnas - 1]
	 **/
	public static int randColumna() {
		return Juego.randInt(0, Juego.columnas - 1);
	}
}
