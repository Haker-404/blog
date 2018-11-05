package com.nianyuan.blogs.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.nianyuan.blogs.PO.Users;

public class BlogsDAO {

	private Statement state;
	private Connection conn;
	private ResultSet rs;	
	/**
	 * add User
	 * @param l
	 */
	public void add(Users l){

		try{
			conn=DBtools.getConnection();
			
			state= conn.createStatement();
		
			String sql="INSERT INTO person_in VALUES( "+getMAX()+",'"+l.getUser()+"','"+l.getPass()+"','"+l.getSex()+"','"+l.getName()+"',DATE_FORMAT('"+l.getBirthday()+"','%y-%m-%d'))";
			
			System.out.println(sql);
			
			state.executeUpdate(sql);
		
		}catch(SQLException e){
			
			e.printStackTrace();
			
		}
		finally{
			
			DBtools.cloaeConn(conn);
			DBtools.cloaeState(state);
			
		}	
	}
	/**
	 * get MAX number
	 * @return
	 */
	private int getMAX(){
		
		Connection conn =null;
		Statement state =null;
		ResultSet rs =null;
		int max = 0;
		try{
			conn = DBtools.getConnection();
			
			state = conn.createStatement();
			String sql = "Select count(user_id) max from person_in";
			rs = state.executeQuery(sql);

			if(rs.next()){
				
				max = rs.getInt("max");
			}
	
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			
			DBtools.cloaeResultSet(rs);
			DBtools.cloaeState(state);
			DBtools.cloaeConn(conn);
			
		}
		return max+1;
	}
	/**
	 * Query Person by id 
	 * @return
	 */
	public ArrayList<Users> queryPerson(){
		
		ArrayList<Users> al = new ArrayList<Users>();
		try{
			conn = DBtools.getConnection();
			state = conn.createStatement();
			String sql = "select * from person_in order by user_id";
			rs = state.executeQuery(sql);			
			while(rs.next()){
				
				Users p = new Users();
				p.setUser(rs.getString("User_name"));
				p.setPass(rs.getString("User_pass"));
				p.setSex(rs.getString("sex"));
				p.setName(rs.getString("_name"));
				p.setBirthday(rs.getString("birthday"));
				
				al.add(p);
			}
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		finally{
			DBtools.cloaeResultSet(rs);
			DBtools.cloaeState(state);
			DBtools.cloaeConn(conn);	
		}
		return al;
	}
	/**
	 * Query Password by UserName
	 * @return
	 */
	public String queryPassByUser(String user){
		
		String p = null;
		try{
			conn = DBtools.getConnection();
			state = conn.createStatement();
			String sql = "select * from person_in where user_name ='"+user+"'";

			rs = state.executeQuery(sql);			
			if(rs.next()){
				
				p=rs.getString("User_pass");
			}
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		finally{
			DBtools.cloaeResultSet(rs);
			DBtools.cloaeState(state);
			DBtools.cloaeConn(conn);	
		}
		return p;
	}	
}
