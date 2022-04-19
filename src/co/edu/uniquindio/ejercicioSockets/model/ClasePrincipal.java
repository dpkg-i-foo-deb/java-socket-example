/**
 * Mateo Estrada Ramirez
 * Nov 9, 2020 4:10:48 PM
 * Contiene n clientes
 */
package co.edu.uniquindio.ejercicioSockets.model;

import java.util.ArrayList;

import co.edu.uniquindio.ejercicioSockets.exceptions.ClienteDuplicadoException;

public class ClasePrincipal
{
	private ArrayList<Cliente>clientes;
	
	public ClasePrincipal()
	{
		clientes= new ArrayList<Cliente>();
	}
	
	public void addCliente(String nombre_y_apellido) throws ClienteDuplicadoException
	{
		Cliente cliente= new Cliente(nombre_y_apellido);
		verificarDuplicado(cliente);
		clientes.add(cliente);
		
	}
	
	public void verificarDuplicado(Cliente cliente) throws ClienteDuplicadoException
	{
		for(int contador=0; contador<clientes.size();contador++)
		{
			if(clientes.get(contador).getNombre_y_apellido().equals(cliente.getNombre_y_apellido()))
			{
				throw new ClienteDuplicadoException();
			}
		}
	}
}
