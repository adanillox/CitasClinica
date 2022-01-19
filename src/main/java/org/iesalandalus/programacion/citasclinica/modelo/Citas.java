package org.iesalandalus.programacion.citasclinica.modelo;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.gestionclientes.modelo.dominio.Cliente;

public class Citas {
	
private int capacidad=100;
private int tamano=0;
private Cita[] coleccionCitas;

public Citas(int cita) {
	;
}
public Cita[] getCitas() {
	return coleccionCitas;
}

public Cita[] getCitas(LocalDate fecha) {
	Cita[] citaTiempo= new Cita[0];
	int tam;
	for (int i = 0; i < citaTiempo.length; i++) {
		tam=citaTiempo.length;
		if(fecha==coleccionCitas[i].getFechaHora().toLocalDate()) {
			citaTiempo=Arrays.copyOf(citaTiempo, tam+1);
			citaTiempo[tam]=coleccionCitas[i];
			
		}
	}
	
	return citaTiempo ;
}
public int getTamano() {
	return tamano;
}
public int getCapacidad() {
	return capacidad;
}
public void insertar(Cita cita) throws OperationNotSupportedException {
	
		if (cita == null) {
			throw new IllegalArgumentException("No se puede insertar un cita nulo.");
		}else {if (buscarIndice(cita)!=tamano+1) {
			throw new OperationNotSupportedException("El cliente ya existe.");
		} else {
			int N=coleccionCitas.length;
			coleccionCitas=Arrays.copyOf(coleccionCitas,N+1);
			coleccionCitas[N+1]=cita;
}	
		}
		
}
private int buscarIndice(Cita cita) {
	
	for (int i = 0; i < coleccionCitas.length; i++) {
		if(coleccionCitas[i]==cita) {
			return i;
			
		}
	}
	return tamano+1;
	
}
private boolean tamanoSuperado(int tamano)  {
	
	if(tamano>capacidad) {
		return true;
	}
	else {
		return false;
	}
	
}
private boolean capacidadSuperado(int capacidad)   {
	
	if(tamano>capacidad) {
	return true;
	}
	else {
		return false;
	}
}
public Cita buscar(Cita cita) { 
	if(buscarIndice(cita)==tamano+1) {
		throw new IllegalArgumentException("No se puede buscar una cita que no existe");
	} else {
		return coleccionCitas[buscarIndice(cita)];
	}
}

public void borrar(Cita cita) throws OperationNotSupportedException {
desplazarUnaPosicionHaciaIzquierda(buscarIndice(cita));}

private void desplazarUnaPosicionHaciaIzquierda(int posicion) {
	for (int i = posicion; i < coleccionCitas.length; i++) {
		coleccionCitas[i]=coleccionCitas[i+1];
	}
	
	}
}

