/**
 * Mateo Estrada Ramirez
 * Nov 9, 2020 4:09:17 PM
 * Crea una clase cliente
 */

package co.edu.uniquindio.ejercicioSockets.model;

public class Cliente 
{
	private String nombre_y_apellido;
	
	public Cliente(String nombre_y_apellido)
	{
		this.nombre_y_apellido= nombre_y_apellido;
	}

	public String getNombre_y_apellido() {
		return nombre_y_apellido;
	}

	public void setNombre_y_apellido(String nombre_y_apellido) {
		this.nombre_y_apellido = nombre_y_apellido;
	}
	
	
}
