
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
    private static int basicID = 0;
    private int id;
    private String name;
    private String email;
    private List<Order> orderList;

    public Customer(String name, String email){
        this.name = name;
        this.email = email;
        basicID++;
        this.id = basicID;
        this.orderList = new ArrayList<>();
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public List<Order> getOrderList() {
        return orderList;
    }

    public Order getOrderById(int id){
        if(orderList.isEmpty()){
            return null;
        }
        for(Order order:orderList){
            if(order.getOrderId() == id){
                return order;
            }
        }
        return null;
    }

    public boolean returnOrderById(int id){
        Order order = getOrderById(id);
        if(order != null){
            order.setStatus(Status.RETURNED);
        //    System.out.println("The order " + id + " is marked as returned");
            return true;
        }
        //    System.out.println("The order " + id + " is not found");
        return false;
    }
}
