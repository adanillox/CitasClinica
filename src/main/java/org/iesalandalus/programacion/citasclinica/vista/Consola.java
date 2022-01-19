package org.iesalandalus.programacion.citasclinica.vista;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.iesalandalus.programacion.citasclinica.modelo.Cita;
import org.iesalandalus.programacion.citasclinica.modelo.Paciente;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
private Consola() {
	
}
public static void mostrarMenu() {
	System.out.println(" ____________________________________________________________");
	System.out.println("|               		   Menu 	                         |");
	System.out.println("| 1-Inserta.					                             |");
	System.out.println("| 2-Buscar.                                           	     |");
	System.out.println("| 3-Borrar.							    				     |");
	System.out.println("| 4-Mostrar todas las citas. 		                         |");
	System.out.println("| 5-Mostrar las citas de una fecha.				             |");
	System.out.println("|_6- Salir.__________________________________________________|");
}


public static Opciones elegirOpcion() {
	int opcion;

	do {
		System.out.print("Introduce la opción a realizar: ");
		opcion = Entrada.entero();

	} while (opcion < 1 || opcion > 6);

	switch (opcion) {
	case 1:
		return Opciones.INSERTAR_CITA;
		
	case 2:
		return	Opciones.BUSCAR_CITA;
		
	case 3:
		return Opciones.BORRAR_CITA;
		
	case 4:
		return Opciones.MOSTRAR_CITAS;
		
	case 5:
		return Opciones.MOSTRAR_CITAS_DIA;
	
	case 6:
		return Opciones.SALIR;

		
	}
	return null;
}
public static Cita leerCita() {
	return new Cita(leerPaciente(),leerFechaHora());
}
public static Paciente leerPaciente() {
	System.out.println("Introduce el nombre del paciente");
	String nombre=Entrada.cadena();
	System.out.println("Introduce el dni del paciente");
	String dni= Entrada.cadena();
	System.out.println("Introduce el telefono del paciente");
	String telefono= Entrada.cadena();
	return new Paciente(nombre,dni,telefono);
}
public static LocalDateTime leerFechaHora() {
	System.out.println("Introduce la fecha/hora del paciente");
	System.out.println("DIA:");
    int dia = Entrada.entero();
    System.out.println("MES:");
    int mes = Entrada.entero();
    System.out.println("ANIO:");
    int anio = Entrada.entero();
    System.out.println("HORA:");
    int hora = Entrada.entero();
    System.out.println("MINUTOS:");
    int min = Entrada.entero();
    return LocalDateTime.of(anio, mes, dia, hora, min);

}
public static LocalDate leerFecha() {
	System.out.println("Introduce la fecha del paciente");
	System.out.println("DIA:");
    int dia = Entrada.entero();
    System.out.println("MES:");
    int mes = Entrada.entero();
    System.out.println("ANIO:");
    int anio = Entrada.entero();
  
    return LocalDate.of(anio, mes, dia);

}
}

