package org.iesalandalus.programacion.citasclinica.modelo;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author Adan
 *
 */
public class Paciente {
private static final String ER_DNI="\\d{8}[A-Za-z]";
private static final String ER_TELEFONO="\\d{9}";
private String nombre;
private String dni;
private String telefono;


//Creación del constructor
public Paciente(String nombre,String dni, String telefono ) {
		setNombre(nombre);
		setDni(dni);
		setTelefono(telefono);
}
//Creación del constructor copia
public Paciente( Paciente objPaciente) {
	setNombre(objPaciente.nombre);
	setDni(objPaciente.dni);
	setTelefono(objPaciente.telefono);
}

/**
 * Este método debe normalizar un nombre eliminando caracteres en blanco de sobra y poniendo en mayúsculas la primera 
 * letra de cada palabra y en minúsculas las demás.
 * 
 * Lo primero que el metodo es privado(private) y devolvera un String(correccion), el nombre pedido por el parametro,
 * sera editado sin los espacios gracias al trim(), y a continuación con el toLowerCase() lo editara para que toda la cadena,
 * sea en minuscula.
 * El siguiente paso seria eliminar los espacios de mas como "  " y lo convierta en " ", reemplazando con replaceALL().
 * Creamos la variable correccion y con el substring(0,1) seleccionaremos el primer caracter y lo convertimos en mayuscula
 * con to.UpperCase().
 * Crearemos un bucle para detectar espacios en blancos,con nombre.length sabremos el numero de caracteres que tendra la cadena
 * Con el charAt() dara un caracter de dicha posicion, si se encuentra dicho espacio el siguiente caracter sera en mayuscula
 * sino es asi se quedara tal cual, se concatenar paso a paso pasando por el bucle.
 * @param nombre
 * @return 
 */
private String formateaNombre(String nombre) {
	nombre=nombre.trim().toLowerCase();
	nombre=nombre.replaceAll("\\s+"," ");
	String correccion= nombre.substring(0,1).toUpperCase();
	for (int i = 1; i < nombre.length(); i++) {
		if(nombre.charAt(i-1)==' ')
			{
			correccion+=nombre.substring(i,i+1).toUpperCase();
			
			}
		else {
			correccion+=nombre.substring(i,i+1);
		}
			
	}
	return correccion ;
}
//Creación de metodo comprobar las letras del dni que sigan el formato correspondiente.
private boolean comprobarLetraDni(String dni) {
	
	char[]  LETRAS_DNI = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
	int numero= Integer.parseInt(dni.substring(0,8));
	 char letra= dni.charAt(8);
	if(LETRAS_DNI[numero%23]==letra) {
		return true;
	}
	else{
		return false;
	}
	
}
//Leer el atributo nombre
public String getNombre() {
	return nombre; 
}
//Añadir el atributo nombre un argumento, pero que no sea null y sin nada.
public void setNombre(String nombre) {
	if(nombre==null || nombre.trim().equals("")) {
		throw new IllegalArgumentException("El nombre no puede ser nulo o vacio");
	}
	else {
		this.nombre=formateaNombre(nombre);
			
		}
		
	
}
//Leer el atributo dni
public String getDni() {
	return dni;
}
//Añadir el atributo dni un argumento, pero que no sea null,sin nada de argumento y que siga un formato.
private void setDni(String dni) {
	if(dni==null || dni.trim().equals("")) {
		throw new IllegalArgumentException("El dni no puede ser nulo o vacio");
	}
	else {
		if(!dni.matches(ER_DNI)) {
			throw new IllegalArgumentException("El formato del dni no es correcto");
			}
		else{
		if(!comprobarLetraDni(dni)) {
			throw new IllegalArgumentException("El dni no es correcto");
			}
		else {
			this.dni=dni;
		}
		}
		
	}
	
		
}
//Leer el atributo telefono.
public String getTelefono() {
	return telefono;
}

//Añadir el atributo telefono un argumento, pero que no sea null, sin nada de argumento y que siga un formato.
public void setTelefono(String telefono) {
	if(telefono==null || telefono.trim().equals("")) {
		throw new IllegalArgumentException("El telefono no puede ser nulo o vacio");
	}
	if(!telefono.matches(ER_TELEFONO)) {
		throw new IllegalArgumentException("El formato del telefono no es correcto");
		}
	this.telefono=telefono;
}

@Override
public int hashCode() {
	return Objects.hash(dni);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Paciente other = (Paciente) obj;
	return Objects.equals(dni, other.dni);
}

private String getIniciales() {
	String ini;
	ini=getNombre().trim();
	ini=getNombre().replaceAll("\\s+"," ");
	ini=getNombre().substring(0).toUpperCase();
	for (int i = 1; i < getNombre().length(); i++) {
		if(getNombre().charAt(i-1)==' ')
			{
			ini+=getNombre().substring(i,i+1).toUpperCase();
			
			}
		else {
		}
	}
	return ini;
	
}
@Override
public String toString() {
	return "("+getIniciales()+")"+"  nombre=" + nombre + ", dni=" + dni + ", telefono=" + telefono;
}




}

