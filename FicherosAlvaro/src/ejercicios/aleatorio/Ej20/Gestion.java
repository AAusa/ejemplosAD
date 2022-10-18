package ejercicios.aleatorio.Ej20;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import ejemplos.aleatorio.encapsulado.Persona;
/**
 * Clase que gestiona la lectura y escritura de departamentos
 * @author Álvaro
 *
 */
public class Gestion {
	private int dimensionNombre = 10;
	private int dimensionLocalidad = 20;
	/*
	 * Calculo TAMAGNOREGISTRO:
	 * Nombre: 10*2 = 20
	 * Localidad: 20*2 = 40
	 * Num: 4
	 * Total: 20+40+4 = 64 bytes
	 */
	public final static int TAMAGNOREGISTRO = 64;
	private RandomAccessFile fichero;
	private String nomFichero;
	
	
	public Gestion(String nomfichero) {
		this.nomFichero = nomfichero;
	}
	
	public void abrir() throws FileNotFoundException {
		fichero = new RandomAccessFile(nomFichero, "rw");
	}

	public void cerrar() throws IOException {
		if (fichero != null) {
			fichero.close();
		}
	}

	private int calculaposicion(int pos) {
		return (pos-1)* TAMAGNOREGISTRO;
	}

	public void escribir (Departamento registro, int pos) throws IOException {
		if (fichero != null) {
			// posiciono el puntero en el sitio que quiero ...
			fichero.seek(calculaposicion(pos));
			this.escribir(registro);
		}
	}

	public void escribir (Departamento registro) throws IOException {
		fichero.seek(calculaposicion(registro.num));
		if (fichero != null) {
			fichero.writeInt(registro.getNum());

			//Guardar en bufferN el nombre y añadirle una longitud
			StringBuffer bufferNombre= new StringBuffer(); 
			if (registro.getNombre() != null) {
				bufferNombre.append(registro.getNombre());
			}
			bufferNombre.setLength(dimensionNombre);
			fichero.writeChars(bufferNombre.toString());

			StringBuffer bufferLocalidad= new StringBuffer();
			if (registro.getLocalidad() != null) {
				bufferLocalidad.append(registro.getLocalidad());
			}
			bufferLocalidad.setLength(dimensionLocalidad);
			fichero.writeChars(bufferLocalidad.toString());
		}

	}
	
	/**
	 * Metodo encargado de modificar un registro e imprimir el antes y despues del registro
	 * @param registroNew
	 * @throws IOException
	 */
	public void modificar (Departamento registroNew) throws IOException {
		Departamento dpto = new Departamento();
		dpto = leer(registroNew.num);
		System.out.println("Antes:\n" + dpto);
		escribir(registroNew);
		dpto = leer(registroNew.num);
		System.out.println("Ahora:\n" + dpto);	
	}
	
	/**
	 * Encargado de comprobar si el registro esta vacio o no
	 * @param num
	 * @return
	 * @throws IOException
	 */
	public boolean verEstadoRegistro (int num) throws IOException {
		Departamento dpto = new Departamento();
		try {
		dpto = leer(num);
		
			if(dpto == null) {
				return false;
			}
		} catch (NullPointerException e) {
			return false;
		} catch (IOException e2) {
			System.out.println("Introduce un num. positivo");
			return false;
		}
		return true;
	}
	

	public void borrar (int num) throws IOException {
		Departamento dpto = new Departamento();
		dpto.setNum(num);
		escribir(dpto);
		System.out.println("Borrado");
	}
	
	public int contarDptos () throws IOException {
		Departamento dpto = new Departamento();
		int pos = 1, cantidad = 0;
		iniciar();
		while(fichero.getFilePointer() < fichero.length()) {
			//System.out.println("posicion: " + pos);
			//System.out.println("posicionActual: " + fichero.getFilePointer());
			dpto = leer(pos);
			if(dpto != null) {
				cantidad++;
			}
			pos++;
		}
		return cantidad;
	}


	public Departamento leer (int pos) throws IOException {

		if (fichero != null) {
			fichero.seek(calculaposicion(pos));
		}

		return leer();
	}

	public Departamento leer() {

		Departamento registro = null;

		if (fichero != null) {
			try {
				registro = new Departamento();
				
				//Edita las caracteristicas de un Departamento con el contenido del registro del fichero
				registro.setNum(fichero.readInt());		

				char campoNombre[] = new char[dimensionNombre];
				for (int i = 0; i < dimensionNombre; i++) {
					campoNombre[i] = fichero.readChar();
				}	
				registro.setNombre(new String(campoNombre));
				
				char campoLocalidad[] = new char[dimensionLocalidad];
				for (int i = 0; i < dimensionLocalidad; i++) {
					campoLocalidad[i] = fichero.readChar();
				}			
				registro.setLocalidad(new String(campoLocalidad));

			} catch (Exception e) {
				// entrar aqu� cuando haya llegado al final del fichero
				registro = null;
			}
		}

		return registro;
	}
	

	
	public void iniciar() throws IOException  {			
		fichero.seek(0);	
}

}
