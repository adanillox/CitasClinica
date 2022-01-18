package org.iesalandalus.programacion.citasclinica.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
//Crear atributos
public class Cita {
	private static final String FORMATO_FECHA_HORA=("hh: mm: ss a dd-MMMM-aaaa");
	private Paciente paciente;
	private LocalDateTime fechaHora= LocalDateTime.now();
	

	
	
//Crear Constructor	
	public Cita(Paciente paciente,LocalDateTime fechahora) {
		setPaciente(paciente);
		setFechaHora(fechaHora);
	}
//Crear Constructor copia
	public Cita(Cita objCita) {
		if (objCita == null) {
			throw new IllegalArgumentException("No se puede copiar un paciente nulo.");
		}else {
		setPaciente(objCita.paciente);
		setFechaHora(objCita.fechaHora);
		}
	}
//Mostrar contenido Paciente
	public Paciente getPaciente() {
		return paciente;
	}

// Modificar Paciente
	private void setPaciente(Paciente paciente) {
		if (paciente == null) {
			throw new IllegalArgumentException("Los datos paciente no pueden ser nulos.");
		}
		this.paciente = paciente;
	}
	//Mostar fecha
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	
	//Añadir fecha y modificarla en un formato.
	public void setFechaHora(LocalDateTime fechaHora) {
		if (fechaHora == null) {
			throw new IllegalArgumentException("Los datos fechaHora no pueden ser nulos.");
		}
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMATO_FECHA_HORA);
        String formatDateTime = fechaHora.format(formatter);
        
		this.fechaHora = LocalDateTime.parse(formatDateTime);
	}
	@Override
	public int hashCode() {
		return Objects.hash(paciente, fechaHora);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cita other = (Cita) obj;
		return Objects.equals(paciente, other.paciente) && Objects.equals(fechaHora, other.fechaHora);
	}
	@Override
	public String toString() {
		return "Paciente=" + paciente + ", fechaHora=" + fechaHora;
	}
	
	
}
