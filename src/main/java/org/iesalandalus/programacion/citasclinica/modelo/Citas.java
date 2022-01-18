package org.iesalandalus.programacion.citasclinica.modelo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.naming.OperationNotSupportedException;

public class Citas {
	
private int capacidad;
private int tamano;
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
public void insertar(Cita cita) {
	
}
private int buscarIndice(Cita coleccionCita) {
	return coleccionCita ;
}
private boolean tamanoSuperado(int tamano) throws OperationNotSupportedException {
	
	if(tamano>capacidad) {
		throw new IllegalArgumentException("Se ha superado el tamano maximo.");
	}
	else {
		this.tamano=tamano;
	}
	
}
private boolean capacidadSuperado(int capacidad) throws OperationNotSupportedException  {
	
	if(tamano>capacidad) {
		throw new IllegalArgumentException("Se ha superado el tamano maximo.");
	}
	else {
		this.tamano=tamano;
	}
}
public Cita buscar(Cita coleccionCitas) { 
	int indice = coleccionCitas.indexOf(cita);
	if (indice != -1) {
		return new Cita(coleccionCitas.get(indice));
	} else {
		return null;
	}
}

public void borrar(Cita cita) throws OperationNotSupportedException {
	if (cita == null) {
		throw new IllegalArgumentException("No se puede borrar un cliente nulo.");
	}
	if (!coleccionCitas.remove(cita)) {
		throw new OperationNotSupportedException("El cliente a borrar no existe.");
	}
}
private void desplazarUnaPosicionHaciaIzquierda(int posicion) {
	
}
}
