package infrastructure.persistence.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import infrastructure.persistence.IPersistencia;
import models.Orador;

public class MysqlRepositoryImpl implements IPersistencia {

	private Connection conexion;

	public MysqlRepositoryImpl() {
		conexion = ConexionBD.getConnection();
	}

	@Override
	public void guardarOrador(Orador newOrador) {
		String query = "INSERT INTO oradores (nombre,apellido,email,tema) VALUES (?,?,?,?)";

		try {
			PreparedStatement statement = conexion.prepareStatement(query);

			statement.setString(1, newOrador.getNombre());
			statement.setString(2, newOrador.getApellido());
			statement.setString(3, newOrador.getEmail());
			statement.setString(4, newOrador.getTema());

			statement.execute();
			
			System.out.println("Conexion establecida");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Orador getOradorById(String idOradorBuscado) {

		return null;
	}

	@Override
	public ArrayList<Orador> getAll() {

		ArrayList<Orador> oradores = new ArrayList<>();
		String query = "SELECT * FROM oradores";

		try {
			PreparedStatement statement = conexion.prepareStatement(query);
			ResultSet result = statement.executeQuery();

			while (result.next()) {

				int id = result.getInt("id");
				String nombre = result.getString("nombre");
				String apellido = result.getString("apellido");
				String email = result.getString("email");
				String tema = result.getString("tema");

				Orador orador = new Orador(id, nombre, apellido, email, tema);
				oradores.add(orador);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void update(String idModificar, String datoModificar, String nuevoDato) {

		String query = "UPDATE oradores SET" + datoModificar + "=" + nuevoDato + "WHERE id =" + idModificar;

		try {
			PreparedStatement statement = conexion.prepareStatement(query);
			statement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(String id) {
		String query = "DELETE FROM oradores WHERE id =" + id;

		try {
			PreparedStatement statement = conexion.prepareStatement(query);
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
