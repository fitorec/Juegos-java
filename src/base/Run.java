package base;


/**
 *
 * @author fitorec
 */
public class Run {
    public static void main(String[] args) {
        //Run.jugarGato();
        //Run.jugarMemorama();
        Run.jugarCuatroEnRaya();
    }

    /**
     * Probando el juego para gato
     * 
     * Notar que mandamos a competir a
     *    GatoMaquina('o')   VS  GatoMaquina('x') 
     */
    public static void jugarGato() {
        Juego.iniciar(
            "gato",
            new juegos.GatoMaquina('o'),
            new juegos.GatoMaquina('x')
        );
    }

    /**
     * Probando el juego para gato
     * 
     * Notar que mandamos a competir a
     *    CuatroEnRayaMaquina('o')   VS   CuatroEnRayaMaquina('x') 
     */
    public static void jugarCuatroEnRaya() {
        Juego.iniciar(
            "cuatro-en-raya",
            new juegos.CuatroEnRayaMaquina('o'),
            new juegos.CuatroEnRayaMaquina('x')
        );
    }

    /**
     * Probando el juego para Memorama
     * 
     * Notar que mandamos a competir a
     *    MemoramaMaquina('o')   VS   MemoramaMaquina('x') 
     */
    public static void jugarMemorama() {
        juegos.MemoramaMaquina jug1 = new juegos.MemoramaMaquina('o');
        juegos.MemoramaMaquina jug2 = new juegos.MemoramaMaquina('x');
        Juego.iniciar("memorama" , jug1 , jug2);
        System.out.println("Jugador1 "+ jug1.valor+ " aciertos = " + jug1.turnosAcertados);
        System.out.println("Jugador2 "+ jug2.valor+ " aciertos = " + jug2.turnosAcertados);
    }
}
