package com.readit4me.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BDConsultaDatosArchivo")
public class BDConsultaDatosArchivo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;

	public BDConsultaDatosArchivo() {
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter salida = response.getWriter();
		response.setContentType("text/html");

		System.out.println("recibiendo requerimiento");
		String id = request.getParameter("id");
		System.out.println("parabletro recogido");
	System.out.println(id);
		// Paso 3: Interactuar con la BD
		try {
			Statement sentencia = con.createStatement();
			ResultSet rs = sentencia.executeQuery(
					"SELECT * from archivo WHERE archivo.codFile = " + id);

		System.out.println("iniciando consulta");
		rs.first();
			salida.append(
					
					"<div id='texto'><label>Nombre del archivo</label>"
			+ "<p>" + rs.getNString("nameFile") + "</p>"
			+ "<label>Proyecto</label>" + "<p>" + rs.getNString("archivo.tagProyecto") + "</p>"
			+ "<label>Anotaciones</label>" + "<p>" + rs.getNString("archivo.anotacion") + "</p></div>"
					);

			System.out.println("impmiendo primera parte");
			rs = sentencia.executeQuery("SELECT * from PALABRA  WHERE palabra.codFile =  " + id);
			System.out.println("iniciando segunda consulta");
		
			salida.append("<div id='resumen'>");
			salida.append("<table><tr><th>Palabras</th> <th>Repeticiones</th>");
		boolean hayRegistros = rs.first();
		while (hayRegistros) {
			salida.append("<tr><td>"+rs.getNString("palabra")+"</td>"
						+ "<td>"+rs.getInt("repeticiones")+"</td></tr>");
			hayRegistros = rs.next();
			}
		salida.append("</table>");
		salida.append("</div>");
		}
		
		catch (SQLException e) {
			System.out.println("Ha ocurrido un error al consultar La query");
			System.out.println(e.getMessage());
			e.printStackTrace();
			// con.rollback();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
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

