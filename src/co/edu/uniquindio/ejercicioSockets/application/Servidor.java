package co.edu.uniquindio.ejercicioSockets.application;

import javax.swing.*;

import co.edu.uniquindio.ejercicioSockets.exceptions.ClienteDuplicadoException;
import co.edu.uniquindio.ejercicioSockets.model.ClasePrincipal;

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class Servidor  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MarcoServidor mimarco=new MarcoServidor();

		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}	
}

class MarcoServidor extends JFrame implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private	JTextArea areaTexto;

	//Para sockets
	private ServerSocket servidor;
	private Socket socket;
	private DataInputStream entrada;
	private String mensaje;
	private Thread hiloServidor;
	private ClasePrincipal clasePrincipal;
	
	public MarcoServidor(){

		setBounds(1200,300,280,350);				

		JPanel milamina= new JPanel();

		milamina.setLayout(new BorderLayout());

		areaTexto=new JTextArea();

		milamina.add(areaTexto,BorderLayout.CENTER);

		add(milamina);

		setVisible(true);
		clasePrincipal= new ClasePrincipal();
		//Iniciar el hilo del servidor
		hiloServidor= new Thread(this);
		hiloServidor.start();

	}
	@Override
	public void run() {	
		try 
		{
			servidor= new ServerSocket(1025);	
			while(true)
			{
				socket= servidor.accept();
				entrada = new DataInputStream(socket.getInputStream());
				mensaje=entrada.readUTF();
				entrada.close();
				try 
				{
					clasePrincipal.addCliente(mensaje);
					System.out.print("Se ha añadido un cliente.\n");
					areaTexto.append(mensaje+"\n");
				}
				catch (ClienteDuplicadoException e)
				{
					System.out.print(e.getMessage()+"\n");
				}
			}	
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
