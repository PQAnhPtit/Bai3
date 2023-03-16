import javax.jws.WebService;
import java.sql.*;

@WebService(endpointInterface = "com.example.InventoryService")
public class InventoryServiceImpl implements InventoryService {
    private Connection conn;

    public String checkInventory(String itemId, Integer quantity) {
        String result = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cardpayment", "root", "123456789");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM inventory WHERE item_id = ?");
            stmt.setString(1, itemId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int inStock = rs.getInt("quantity");
                if (quantity <= inStock) {
                    result = String.format("Sản phẩm %s có đủ hàng trong kho!", itemId);
                } else {
                    result = String.format("Sản phẩm %s chỉ còn %d sản phẩm trong kho.", itemId, inStock);
                }
            } else {
                result = String.format("Không tìm thấy mã sản phẩm %s trong kho.", itemId);
            }

            rs.close();
            stmt.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}