# Juegos en Java

Proyecto académico, juegos en java.

## Lista de Juegos.

 - Memorama
 - Gato
 - Cuatro en Raya


## Estructura de archivos

El proyecto es un proyecto desarrollado con **netbeans**, el cual contiene dos paquetes:

### Paquete: base:

Contiene los archivos básicos del juego, los cuales se en listan a continuación:

 - **Ficha.java:** Modela una ficha en especifico.
 - **Juego.java:** Contiene la lógica unificada de los juegos.
 - **Run.java  :** Es un disparador que ejecuta el juego en cuestión.

### Paquete: juegos:

Contiene la estructura de un Competidor genérico y contiene los competidores en cuestión:

 - **Competidor.java** Clase abstracta que contiene la lógica genérica de un competidor en cuestión.
 - **CuatroEnRayaMaquina.java** Lógica competidor maquina para el Cuatro en Raya.
 - **GatoMaquina.java** Lógica competidor maquina para el Gato.
 - **MemoramaMaquina.java** Lógica competidor maquina para el Memorama.


Estas ultimas 3 clases contienen la estructura para que implementen la lógica de su jugador para el juego en cuestión, el objetivo es hacer que la maquina gane.


### Evaluación final.

... Pendiente.