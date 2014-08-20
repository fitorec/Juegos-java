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
 - **<i style='color:red'>CuatroEnRayaMaquina.java</i>** Lógica competidor maquina para el Cuatro en Raya.
 - **<i style='color:red'>GatoMaquina.java</i>** Lógica competidor maquina para el Gato.
 - **<i style='color:red'>MemoramaMaquina.java</i>** Lógica competidor maquina para el Memorama.

Estas ultimas 3 clases **en rojo** contienen la estructura para que implementen la lógica de su jugador para el juego en cuestión, con estos archivos van a estar trabajando ustedes y su objetivo es hacer que la maquina gane.


### Evaluación final.

La intensión en la evaluación final, es poner a prueba la lógica que decidieron agregarle al su _competidor_ respecto al juego en cuestión, asi como sus habilidades en implementar dicha lógica.

#### 40% Competencia de Código.

La evaluación consistirá en poner a competir su código, con algún otro código que presente ese día. A partir del numero de veces que logre ganar el juego en un determinado margen de tiempo(aprox. 5mins), sera parte de su resultado de evaluación **40%**.

#### 20% Competencia con humano:
A su vez también se va a competir contra una persona, realizando 2 partidas, procurando ganar.


#### 20% Documentación de su Juego:

Van a entregarme una documentación breve, respecto a la estrategia(s) que siguieron.

#### 20% Simple Test.

Se realizara un pequeño test de preguntas con opción múltiple.

> Sin mas a jugar, **right now!**.

 