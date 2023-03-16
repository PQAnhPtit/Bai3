import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(name = "InventoryService.java")
public interface InventoryService {
    @WebMethod(operationName = "checkInventory")
    public String checkInventory(@WebParam(name = "itemId") String itemId,
                                 @WebParam(name = "quantity") Integer quantity);
}