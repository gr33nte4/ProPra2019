package propra.grpproj.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import propra.grpproj.quiz.Socket.SocketServer;
import propra.grpproj.quiz.SocketDataObjects.*;


////////////////////////////////////////////////////////////////////////////
// Handle all the user related actions (login, logout, delete, register)
// 
// @author: Marius Discher & Stanislav Miushev
//
//
//
//


public class UserHandling 
{
	
	
	/**
	 * Method to register a user in the database
	 * Calls the function user_register in the DatabaseManager
	 * @throws SQLException 
	 * 
	 */ 
	public void user_register(String username, String email, String passwd, UserType usertype) throws SQLException 
	{
		
		DatabaseManager db = new DatabaseManager();
		RegisterUser registeruser = new RegisterUser(username,email,passwd,usertype);
		
		boolean success_reg = false;
		
		
		
		if ( db.registerUser(username, email, passwd, usertype) == true ) {
			
			user_login(username, passwd);
			registeruser.setRegisterProg(true);
			SocketServer.getInstance().sendObject(registeruser, username);
			
			
		} else if(success_reg == false) {
			
			registeruser.setRegisterProg(success_reg);
			registeruser.setRegisterProg(false);
			SocketServer.getInstance().sendObject(registeruser, username);
		}
		  
		
		
	}
	
	




	/**   
	 *  Method to log a user in the quiz system
	 *  Calls the function inside the DatabaseManager
	 *  
	 */
	public void user_login(String username, String passwd) throws SQLException 
	{
		
		
		DatabaseManager db = new DatabaseManager();
		boolean success_login; 
		
		success_login = db.login(username,passwd); 
		
		UserType usertype = db.getUserType(username);
		
		if (!success_login == true) {
			usertype = UserType.ERROR;
		} else {
		
		Login login = new Login(username,passwd);
		
		login.setLogged(true);
		
		SocketServer.getInstance().sendObject(login, username);
		}
		// Send object to GUI 
		// Case 1: login successfully
		// Case 2: password incorrect 
		// Case 3: Email wrong
		// For 1 boolean = true, 2 = false and 3 = false

	}
	
	
	// Method to create a temp user
	public void createTempUser () throws SQLException 
	{
		DatabaseManager db = new DatabaseManager();
		db.registerUser("temp", "temp", "temp", UserType.DEFAULT);
		db.login("temp", "temp");
	}
	
	
	// log the user out
	public void logout (String username) {
		Login login = null;
		login.setLogged(false);
		SocketServer.getInstance().sendObject(login, username);
		
	}
	
	
	// delete the user after successfully authenticated
	// checks if user exist then deletes from Database
	// sends DeleteUser back to Gui
	public boolean deleteUser (String username, String passwd) throws SQLException 
	{
		
		boolean del_check = true;
		DatabaseManager db= new DatabaseManager();
		db.deleteUser(username, passwd);
		//Authorize
		return del_check;
		
		
		
	}
}
