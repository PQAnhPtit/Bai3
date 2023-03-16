import javax.xml.ws.Endpoint;

public class InventoryServicePublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/checkInventory", new InventoryServiceImpl());
        System.out.println("Start service "+"http://localhost:9999/checkInventory?wsdl");
    }
}