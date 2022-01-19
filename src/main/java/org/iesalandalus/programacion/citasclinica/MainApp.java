package org.iesalandalus.programacion.citasclinica;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.citasclinica.modelo.Citas;
import org.iesalandalus.programacion.citasclinica.vista.Consola;
import org.iesalandalus.programacion.citasclinica.vista.Opciones;

public class MainApp {
	private static final int NUM_MAX_CITAS=100;
	private static Citas citasClinica;
	public static void main(String[] args) throws OperationNotSupportedException {
		System.out.println("Programa para gestionar las citas de la Clínica.");
		Opciones opcion=Consola.elegirOpcion();
		do {
		Consola.mostrarMenu();
		ejecutarOpcion(opcion);
		}while(opcion!=Opciones.SALIR);
	}

		
	private static void ejecutarOpcion( Opciones opciones) throws OperationNotSupportedException {
		switch(opciones) {
		
		case INSERTAR_CITA:
			insertarCita();
			break;
		case BUSCAR_CITA:
			borrarCita();
			break;
		case BORRAR_CITA:
			borrarCita();
			break;
		case MOSTRAR_CITAS:
			mostrarCitas();
			break;
		case MOSTRAR_CITAS_DIA:
			mostrarCitasDia();
			break;
		case SALIR:
			System.out.println("Adios");
			break;
		}
		
	}
	private static void insertarCita() throws OperationNotSupportedException {
		citasClinica.insertar(Consola.leerCita());
	}
	private static void buscarCita() {
		citasClinica.buscar(Consola.leerCita());
	}
	private static void borrarCita() throws OperationNotSupportedException {
		citasClinica.borrar(Consola.leerCita());
	}
	private static void mostrarCitasDia() {
		
		System.out.println(citasClinica.getCitas(Consola.leerFecha()));
	}
	private static void  mostrarCitas() {
		
		System.out.println(citasClinica.getCitas());
	}
}
