package main.java.model;

public class Espiral {

	private int[][] matriz;
	private int dimension;
	private int[] centro;
	private int actualX;
	private int actualY;
	private int almacenarSumaEstrellas; // Variable que almacena la suma de las estrellas

	public Espiral(int[][] matriz) {
		super();
		this.matriz = matriz;
		this.dimension = matriz.length;
		this.centro = calcularCentro();
	}

	public int[] calcularCentro() {
		int filas = this.matriz.length;
		int columnas = this.matriz[0].length;
		int[] centro;

		centro = new int[] { (int) filas / 2, (int) columnas / 2 };
		return centro;
	}

	public void sumarEstrellas(int x, int y) {
		int sumar = 0;
		if (x >= 0 && x < dimension && y >= 0 && y < dimension) {
			sumar += matriz[x][y];
		}
		almacenarSumaEstrellas += sumar;
	}

	public void comenzarSumatorio() {
		actualX = centro[0];
		actualY = centro[1];
		sumarEstrellas(actualX, actualY);

		int numPaso = 0;
		while (actualX >= 0 && actualX < dimension && actualY >= 0) {
			numPaso++;
			// Cada 4 veces se ejecuta cada 1 de los metodos
			if (numPaso % 4 == 1) {
				desplazarArriba(numPaso);
			} else if (numPaso % 4 == 2) {
				desplazarDerecha(numPaso);
			} else if (numPaso % 4 == 3) {
				desplazarAbajo(numPaso);
			} else if (numPaso % 4 == 0) {
				desplazarIzquierda(numPaso);
			}
		}
	}

	public void desplazarArriba(int numPaso) {
		for (int i = 0; i < numPaso; i++) {
			actualY--;
			sumarEstrellas(actualX, actualY);
		}
	}

	public void desplazarIzquierda(int numPaso) {
		for (int i = 0; i < numPaso; i++) {
			actualX--;
			sumarEstrellas(actualX, actualY);
		}
	}

	public void desplazarAbajo(int numPaso) {
		for (int i = 0; i < numPaso; i++) {
			actualY++;
			sumarEstrellas(actualX, actualY);
		}
	}

	public void desplazarDerecha(int numPaso) {
		for (int i = 0; i < numPaso; i++) {
			actualX++;
			sumarEstrellas(actualX, actualY);
		}
	}

	public int[][] getMatriz() {
		return matriz;
	}

	public void setMatriz(int[][] matriz) {
		this.matriz = matriz;
	}

	public int getDimension() {
		return dimension;
	}

	public int[] getCentro() {
		return centro;
	}

	@Override
	public String toString() {
		String resultado = "Dimension: " + dimension + "x" + dimension + "\n";
		resultado += "Centro: (" + centro[0] + ", " + centro[1] + ")\n";
		resultado += "Suma de estrellas: " + almacenarSumaEstrellas + "\n";
		resultado += "Matriz:\n";

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				resultado += matriz[i][j] + " ";
			}
			resultado += "\n";
		}
		return resultado;
	}

	public int getAlmacenarSumaEstrellas() {
		return almacenarSumaEstrellas;
	}

	public void setAlmacenarSumaEstrellas(int almacenarSumaEstrellas) {
		this.almacenarSumaEstrellas = almacenarSumaEstrellas;
	}

	public void setCentro(int[] centro) {
		this.centro = centro;
	}

	public void setAxtualX(int valor) {
		this.actualX = valor;
	}

	public void setActualY(int valor) {
		this.actualY = valor;
	}

}
