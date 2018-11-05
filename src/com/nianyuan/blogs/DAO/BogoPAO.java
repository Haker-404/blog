package com.nianyuan.blogs.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.nianyuan.blogs.PO.Bogo;

public class BogoPAO {
	
	private Statement state;
	private Connection conn;
	private ResultSet rs;	
	/**
	 * Add data to Database 
	 * @param l
	 */
	public void add(Bogo l){

		try{
			// get connection
			conn=DBtools.getConnection();
			
			state= conn.createStatement();
		
			String sql="INSERT INTO logo VALUES( "+getMAX()+",'"+l.getLname()+"','"+l.getLemail()+"',now(),'"+l.getLtitle()+"','"+l.getLcontent()+"')";
			
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
	 * get the Max Key
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
			String sql = "Select MAX(lid) max from logo";
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
	 * get all data from Database SQL
	 * @return al
	 */
	public ArrayList<Bogo> getAllLogo(String sql)
	{
		ArrayList<Bogo> al = new ArrayList<Bogo>();
		try{
			conn = DBtools.getConnection();
			state = conn.createStatement();
			rs = state.executeQuery(sql);			
			while(rs.next()){
				
				Bogo p = new Bogo();
				
				p.setLid(rs.getInt("lid"));
				p.setLname(rs.getString("lname"));
				p.setLemail(rs.getString("lemail"));
				p.setLdate(rs.getString("ldate"));
				p.setLtitle(rs.getString("ltitle"));
				p.setLcontent(rs.getString("lcontent"));
				
				p.setViews(rs.getString("views"));
				
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
	 * ͨQuery data from Database by id
	 * @param sql
	 * @return
	 */
	public Bogo findlogoById(int id){
		
		Bogo p = new Bogo();
		try{
			
			conn = DBtools.getConnection();
			
			state = conn.createStatement();
			
			String sql="select * from logo_copy1 where lid="+id;
			rs = state.executeQuery(sql);
			
			if(rs.next()){

				p.setLid(id);
				p.setLname(rs.getString("lname"));
				p.setLemail(rs.getString("lemail"));
				p.setLdate(rs.getString("ldate"));
				p.setLtitle(rs.getString("ltitle"));
				p.setLcontent(rs.getString("lcontent"));
								
				
				p.setViews(rs.getString("views"));
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
	/**
	 * delete data from Database by id
	 * @param id
	 */
	public void deleteById(int id){
		
		try{
			conn=DBtools.getConnection();
			
			state= conn.createStatement();
		
			String sql="delete from logo where lid="+id;
			
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
	 * update data by id 
	 * @param p
	 */
	public void updateById(Bogo p){
		
		try{
			
			conn=DBtools.getConnection();
			
			state= conn.createStatement();
		
			String sql="update logo t set t.lname='"+p.getLname()+"',t.lemail='"+p.getLemail()+"',t.ltitle='"+p.getLtitle()+"',t.lcontent='"+p.getLcontent()+"',t.ldate=now() where t.lid="+p.getLid();
			
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
	 * get total roles
	 * @return
	 */
	public int totalRoles(){
		Connection conn =null;
		Statement state = null;
		ResultSet rs = null;
		
		int num = 0;
		try{
			conn = DBtools.getConnection();
			state = conn.createStatement();
			String sql ="select count(lid) nu from logo";
			rs = state.executeQuery(sql);
			
			if(rs.next()){			
				num = rs.getInt("nu");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			
			DBtools.cloaeResultSet(rs);
			DBtools.cloaeState(state);
			DBtools.cloaeConn(conn);
		}
		return num;
	}
}
