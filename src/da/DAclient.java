package da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.client;
import util.dbutil;

public class DAclient implements DAIclient {
	private Connection connection;
	
	public DAclient() {
		connection = dbutil.getConnection();
	}
	
	@Override
	public void addClient (client client){
		try {
			String Query = "INSERT INTO public.client (phone_client,mail_client,client_id,l_name,f_name) VALUES (?,?,?,?,?)"; 
			PreparedStatement preparedstatement = connection.prepareStatement(Query);
			preparedstatement.setLong(1, client.getPhone_client());
			preparedstatement.setString(2, client.getMail_client());
			preparedstatement.setInt(3, client.getClient_id());
			preparedstatement.setString(4, client.getL_name());
			preparedstatement.setString(5, client.getF_name());
			
			preparedstatement.executeQuery();
			preparedstatement.close();
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public List <client> getAllClient(){
		List <client> client = new ArrayList <client> ();
		
		try
		{
			String Query = "SELECT * FROM public.client";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(Query);
			
			while (rs.next()){
				client c = new client ();
				c.setPhone_client(rs.getInt("phone_client"));
				c.setMail_client(rs.getString("mail_client"));
				c.setClient_id(rs.getInt("client_id"));
				c.setL_name(rs.getString("l_name"));
				c.setF_name(rs.getString("f_name"));

				client.add(c);
			}
			rs.close();
			statement.close();
			
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return client;
	}
	
	@Override
	public client getClientById (int clientid){
		client c = new client ();
		
		try{
			String Query = "SELECT * FROM public.client WERHE client_id = ?";
			PreparedStatement preparedstatement = connection.prepareStatement(Query);
			preparedstatement.setInt(1, clientid);
			
			ResultSet rs = preparedstatement.executeQuery();
			
			while(rs.next()){
				c.setPhone_client(rs.getInt("phone_client"));
				c.setMail_client(rs.getString("mail_client"));
				c.setClient_id(rs.getInt("client_id"));
				c.setL_name(rs.getString("l_name"));
				c.setF_name(rs.getString("f_name"));
			}
			rs.close();
			preparedstatement.close();
			
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return c;
	}
	
	@Override
	public void delete (int clientid){
		try{
		String Query = "DELETE FORM public.client WHERE client_id = ?";
		PreparedStatement preparedstatement = connection.prepareStatement(Query);
		preparedstatement.setInt(1, clientid);
		preparedstatement.executeUpdate();
		preparedstatement.close();
		
		}
		catch (SQLException e){
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void update (client client){
		try
		{
		String Query = "UPDATE public.client SET phone_client= ?, mail_client= ?,client_id= ?,l_name= ?,f_name= ?";
		PreparedStatement preparedstatement = connection.prepareStatement(Query);
		preparedstatement.setLong(1, client.getPhone_client());
		preparedstatement.setString(2, client.getMail_client());
		preparedstatement.setInt(3, client.getClient_id());
		preparedstatement.setString(4, client.getL_name());
		preparedstatement.setString(5, client.getF_name());
		
		preparedstatement.executeUpdate();
		preparedstatement.close();
		
			
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		}
		
		
	}


