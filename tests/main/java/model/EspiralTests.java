package main.java.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class EspiralTests {

	private Espiral espiral;
	private int[][] matriz;

	@BeforeEach
	void setUp() {
		// Inicializamos una matriz 3x3 para las pruebas
		matriz = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		espiral = new Espiral(matriz);
	}

	// Pruebas para el constructor
	@Test
	void testConstructor() {
		assertNotNull(espiral);
		assertEquals(3, espiral.getDimension());
	}

	// Pruebas para calcularCentro
	@Test
	void testCalcularCentro() {
		// Aquí verificamos que el centro se calcula correctamente para una matriz 3x3
		espiral.calcularCentro();
		assertEquals(1, espiral.getCentro()[0]);
		assertEquals(1, espiral.getCentro()[1]);
	}

	// Pruebas para sumarEstrellas
	@Test
	void testSumarEstrellas() {
		espiral.sumarEstrellas(0, 0); // Suma el valor 1
		assertEquals(1, espiral.getAlmacenarSumaEstrellas());

		espiral.sumarEstrellas(2, 2); // Suma el valor 9
		assertEquals(10, espiral.getAlmacenarSumaEstrellas());

		// Fuera de los límites de la matriz
		espiral.sumarEstrellas(-1, -1); // No debe sumar nada
		assertEquals(10, espiral.getAlmacenarSumaEstrellas());
	}

	// Pruebas para comenzarSumatorio
	@Test
	void testComenzarSumatorio() {
		// Verificamos que el sumatorio comienza correctamente
		espiral.comenzarSumatorio();
		assertEquals(0, espiral.getAlmacenarSumaEstrellas()); // Suponiendo que empieza en 0
	}

	// Pruebas para desplazarArriba
	@Test
	void testDesplazarArriba() {
		// Desplazamos el centro de la espiral hacia arriba
		espiral.desplazarArriba(1); // Desplazamos una vez hacia arriba
		assertEquals(0, espiral.getCentro()[0]); // El centro debería moverse a la fila 0
		assertEquals(1, espiral.getCentro()[1]); // La columna debería permanecer igual

		// Desplazamos el centro de nuevo hacia arriba, fuera de la matriz
		espiral.desplazarArriba(1); 
		assertEquals(0, espiral.getCentro()[0]); // No debe moverse más allá de la fila 0
	}

	// Pruebas para desplazarDerecha
	@Test
	void testDesplazarDerecha() {
        espiral.desplazarDerecha(2);
        assertEquals(5, espiral.getCentro()[0]);
        assertEquals(3, espiral.getCentro()[1]);
	}

	// Pruebas para desplazarAbajo
	@Test
	void testDesplazarAbajo() {
        espiral.desplazarAbajo(2);
        assertEquals(3, espiral.getCentro()[0]);
        assertEquals(5, espiral.getCentro()[1]);
	}

	// Pruebas para desplazarIzquierda
	@Test
	void testDesplazarIzquierda() {
        espiral.desplazarIzquierda(2);
        assertEquals(1, espiral.getCentro()[0]);
        assertEquals(3, espiral.getCentro()[1]);
	}

	// Pruebas para getMatriz y setMatriz
	@Test
	void testGetSetMatriz() {
		int[][] nuevaMatriz = new int[][] { { 9, 8, 7 }, { 6, 5, 4 }, { 3, 2, 1 } };
		espiral.setMatriz(nuevaMatriz);
		assertArrayEquals(nuevaMatriz, espiral.getMatriz());
	}

	// Pruebas para getDimension
	@Test
	void testGetDimension() {
		assertEquals(3, espiral.getDimension());
	}

	// Pruebas para getCentro
	@Test
	void testGetCentro() {
		// Verificamos que el centro devuelto sea el que se espera
		assertArrayEquals(new int[] { 1, 1 }, espiral.getCentro()); // Suponiendo que el centro inicial es (1,1)
	}

	// Pruebas para toString		
		 @Test
		    public void testToString() {
		        // Matriz de ejemplo 3x3
		        int[][] matrizEjemplo = {
		            {1, 2, 3},
		            {4, 5, 6},
		            {7, 8, 9}
		        };

		        Espiral espiral = new Espiral(matrizEjemplo);
		        espiral.setAlmacenarSumaEstrellas(15); // Ejemplo suma
		        String esperado = "Dimension: 3x3\n" +
		                          "Centro: (2, 2)\n" +  // Centro matriz
		                          "Suma de estrellas: 15\n" +
		                          "Matriz:\n" +
		                          "1 2 3 \n" +
		                          "4 5 6 \n" +
		                          "7 8 9 \n";

		        // Si es correcto
		        assertEquals(esperado, espiral.toString());
		    }

	// Pruebas para getAlmacenarSumaEstrellas y setAlmacenarSumaEstrellas
	@Test
	void testGetSetAlmacenarSumaEstrellas() {
		espiral.setAlmacenarSumaEstrellas(100);
		assertEquals(100, espiral.getAlmacenarSumaEstrellas());
	}
}
