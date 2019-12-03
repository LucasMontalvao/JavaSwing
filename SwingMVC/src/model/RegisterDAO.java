package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.DatabaseConnection;

public class RegisterDAO extends DatabaseConnection implements IServiceBase<RegisterModel>{
	
	@Override
	public RegisterModel getUser(RegisterModel form) {
		String sql = "select id, nome, sobrenome, email, cpf, rg, senha, usuario from"
				+ " cadastro where"
				+ "id = ? and"
				+ "nome = ? and"
				+ "sobrenome = ? and"
				+ "email = ? and"
				+ "cpf = ? and"
				+ "rg = ? and"
				+ "senha = ? and"
				+ "usuario = ?";
		RegisterModel formulario = null;
		try {
			try(Connection conn = getConnection();
					PreparedStatement p = conn.prepareStatement(sql)){
						p.setInt(1, form.getId());
						p.setString(2, form.getFirstName());
						p.setString(3, form.getLastName());
						p.setString(4, form.getEmail());
						p.setString(5, form.getCpf());
						p.setString(6, form.getRg());
						p.setString(7, form.getPassword());
						p.setString(8, form.getUser());
						p.execute();
						
						
						ResultSet resultSet = p.executeQuery();
						if(resultSet.next()) {
							formulario = new RegisterModel();
							formulario.setId(resultSet.getInt(1));
							formulario.setFirstName(resultSet.getString(2));
							formulario.setLastName(resultSet.getString(3));
							formulario.setEmail(resultSet.getString(4));
							formulario.setCpf(resultSet.getString(5));
							formulario.setRg(resultSet.getString(6));
							formulario.setPassword(resultSet.getString(7).toCharArray());
							formulario.setUser(resultSet.getString(8));
						}
					}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return formulario;
		
	}

	@Override
	public ArrayList<RegisterModel> getAllUsers() {
		String sql = "select * from cadastros";
		ArrayList<RegisterModel> cadastros = new ArrayList<RegisterModel>();
		try {
			try(Connection conn = getConnection();
					PreparedStatement p = conn.prepareStatement(sql)){
				ResultSet resultSet = p.executeQuery();
				while(resultSet.next()) {
					RegisterModel formulario = new RegisterModel();
					formulario = new RegisterModel();
					formulario.setId(resultSet.getInt(1));
					formulario.setFirstName(resultSet.getString(2));
					formulario.setLastName(resultSet.getString(3));
					formulario.setEmail(resultSet.getString(4));
					formulario.setCpf(resultSet.getString(5));
					formulario.setRg(resultSet.getString(6));
					formulario.setPassword(resultSet.getString(7).toCharArray());
					formulario.setUser(resultSet.getString(8));
					
					cadastros.add(formulario);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cadastros;
	}

	@Override
	public void DeleteUser(int id) {
		String sql = "delete from Cadastro where id = ?";
		
		try {
			try(Connection conn = getConnection();
					PreparedStatement p = conn.prepareStatement(sql)){
						p.setInt(1, id);
						p.execute();
					}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addUser(RegisterModel form) {
		String sql = "insert into Cadastro(nome, sobrenome, email, cpf, rg, "
				+ "senha, usuario, dt_nascimento) values(?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			try(Connection conn = getConnection();
					PreparedStatement p = conn.prepareStatement(sql)){
				p.setString(1, form.getFirstName());
				p.setString(2, form.getLastName());
				p.setString(3, form.getEmail());
				p.setString(4, form.getCpf());
				p.setString(5, form.getRg());
				p.setString(6, form.getPassword());
				p.setString(7, form.getUser());
				p.setString(8, form.getBirthDate());
				p.execute();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	};
}
