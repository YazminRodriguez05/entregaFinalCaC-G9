package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import infrastructure.persistence.*;
import infrastructure.persistence.mysql.MysqlRepositoryImpl;
import models.Orador;
import mappers.OradorMapper;



@WebServlet("/oradores")
public class ProyectoFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IPersistencia sistemaPersistencia = new MysqlRepositoryImpl();
	OradorMapper mapper = new OradorMapper();
   
    public ProyectoFinal() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		ArrayList<Orador> listaOradores = sistemaPersistencia.getAll();
		String oradoresJson = mapper.toJason(listaOradores);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		response.getWriter().write(oradoresJson);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//OBTENER DATOS A GUARDAR
		String nombre = request.getParameter("nombreInput");
		String apellido = request.getParameter("apellidoInput");
		String email = request.getParameter("emailInput");
		String tema = request.getParameter("temaInput");
		String idBorrar = request.getParameter("idBorrar");
		
		//DATOS PARA MODIFICAR
		String idModificar = request.getParameter("idModificar");
		String datoModificar = request.getParameter("datoModificar");
		String nuevoDato = request.getParameter("nuevoDato");
		
		//READ
		Orador orador = new Orador(nombre, apellido, email, tema);
		sistemaPersistencia.guardarOrador(orador);
		OradorMapper mapper = new OradorMapper();
		String oradorJson = mapper.toJason(orador);
		response.getWriter().write(oradorJson);
		response.sendRedirect("index.html");
		
		
		//UPDATE
		
		sistemaPersistencia.update(idModificar, datoModificar, nuevoDato);
		
		
		//DELETE
		sistemaPersistencia.delete(idBorrar);
		
	}

}
