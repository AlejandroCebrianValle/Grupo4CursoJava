package com.readit4me.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.readit4me.Scripdef;

@WebServlet("/BDActualizar")
public class BDActualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;

	public BDActualizar() {
		super();
		// Paso 1: Cargar el driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No se ha encontrado el driver para MySQL");
			return;
		}
		System.out.println("Se ha cargado el Driver de MySQL");

		// Paso 2: Establecer conexi�n con la base de datos
		String cadenaConexion = "jdbc:mysql://localhost:3306/READIT4ME";
		String user = "root";
		String pass = "Azf$2069";

		try {
			con = DriverManager.getConnection(cadenaConexion, user, pass);
		} catch (SQLException e) {
			System.out.println("No se ha podido establecer la conexi�n con la BD");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Se ha establecido la conexi�n con la Base de datos");
		System.out.println("Estamos en el constructor");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws FileNotFoundException {
		HttpSession sesion = request.getSession();
		
		System.out.println("recibiendo requerimiento");
		String notas = request.getParameter("notas");
		//String notas1 = session.getParameter("notas");
		String tags = request.getParameter("tags");
		String nombre = request.getParameter("nombre");
		//String idF = request.getParameter("idF");
		//String idU = request.getParameter("idU");
		String fichero = request.getParameter("fichero");
		//String nameFichero = request.getParameter("fichero");
		
		int user = (int) sesion.getAttribute("codUser");
		//String nameFichero = "C:/Becquer.txt";
		
		System.out.println(notas+tags);
		System.out.println("parametros recogidos");
		// Paso 3: Interactuar con la BD
		try {
			con.setAutoCommit(false);
			Statement sentencia = con.createStatement();
		//	int codFile = 204;
		//	int codUser = 204;
			
			//TO DO
			//String nameUser = "Nombre de prueba";
			//String contrase�a = "Contrase�adeprueba";
			//int valor = 1;
			//String ultimavisita = "2222/02/02";

			//String nameFile = "archivo de prueba";
			//String tagProyecto = "tag de prueba";
			//String anotacion = "muchisimas anotaciones de prueba";
			Statement sentencias = con.createStatement();
			ResultSet rs = sentencias.executeQuery(
					"SELECT MAX(codFile) as codFile from archivo");
			rs.first();
			int file = rs.getInt("codFile")+1;
			String sql = "INSERT INTO ARCHIVO VALUES (" + file + ",'" + nombre + "', '" + tags + "', '"
					+ notas + "');";
			System.out.println(sql);
			sentencia.executeUpdate(sql);
	//		sql = "INSERT INTO USER VALUES (" + codUser + ",'" + nameUser + "', '" + contrase�a + "', " + valor + ","
	//				+ "'" + ultimavisita + "');";
	//		System.out.println(sql);
	//		sentencia.executeUpdate(sql);
			// String codUser = request.getParameter("id");
			sql = "INSERT INTO POSEE (CodUser, CodFile) VALUES (" + user + "," + file + ");";
			System.out.println(sql);
			sentencia.executeUpdate(sql);
			
			
			
			TreeMap<String, Integer> dicWords = Scripdef.lecturaFichero(fichero);
			Set<String> keys = dicWords.keySet();
			
			int c = 0;
			for (String key : keys) {
				if (c>0){
				sql = "INSERT INTO PALABRA (palabra, codFile, repeticiones) VALUES ('" + key + "',"+ file+", " + dicWords.get(key) + ");";
				System.out.println(sql);
				sentencia.executeUpdate(sql);
				
				
				}
				c++;
			}

			//sentencia.executeUpdate(sql); // est� hecho aposta
			con.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Ha ocurrido un error al actualizar los datos");
			System.out.println(e.getMessage());
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		try {
			response.sendRedirect("principal.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		// Paso 4: Cerrar la conexi�n
		try {
			con.close();
		} catch (SQLException e) {
			System.out.println("No se ha podido cerrar la conexi�n con la BD");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("Estamos en el m�todo destroy");
		super.destroy();
	}
}