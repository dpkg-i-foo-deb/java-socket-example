/*
 * mateo
 * Nov 9, 2020 4:14:38 PM
 */
package co.edu.uniquindio.ejercicioSockets.exceptions;

public class ClienteDuplicadoException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ClienteDuplicadoException()
	{
		super("El cliente ya existe en el servidor.");
	}
	
}
