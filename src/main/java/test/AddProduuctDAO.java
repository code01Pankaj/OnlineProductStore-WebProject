package test;
import java.sql.*;
public class AddProduuctDAO {
    public int k = 0;
    public int insert(ProductBean pb) {
    	try {
    		Connection con = DBConnection.getcon();
    		  //Using DB Connection
    		PreparedStatement ps = con.prepareStatement("insert into Product54 values(?,?,?,?)");
    		ps.setString(1, pb.getpCode());
    		ps.setString(2, pb.getpName());
    		ps.setFloat(3, pb.getpPrice());
    		ps.setInt(4,pb.getpQty());
    		k=ps.executeUpdate();
    		
    	}catch(Exception e) {e.printStackTrace();}
    	return k;
    }
}
