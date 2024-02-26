package test;
import java.sql.*;
public class UpdateProductDAO {
	public int k=0;
	public int update(ProductBean pb) {
		try {
			Connection con =DBConnection.getcon();
			PreparedStatement ps = con.prepareStatement("Update Product54 set price=?,qty=? where code=?");
			ps.setFloat(1, pb.getpPrice());
			ps.setInt(2,pb.getpQty());
			ps.setString(3,pb.getpCode());
			k = ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}

}
