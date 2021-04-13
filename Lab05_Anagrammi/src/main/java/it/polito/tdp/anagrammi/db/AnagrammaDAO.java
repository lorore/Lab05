package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnagrammaDAO {

	public boolean isCorrect(String anagramma) {
		
		String sql="SELECT nome "
				+ "FROM parola "
				+ "WHERE nome=? ";
		
	
		try {
			Connection conn=DBConnect.getConnection();
			PreparedStatement st=conn.prepareStatement(sql);
			st.setString(1, anagramma);
			
			ResultSet rs=st.executeQuery();
			
			if(rs.first()) {
				rs.close();
				st.close();
				conn.close();
				return true;
			}
			else {
				rs.close();
				st.close();
				conn.close();
				return false;
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
