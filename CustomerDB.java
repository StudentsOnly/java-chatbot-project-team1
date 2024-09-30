import java.util.ArrayList;
import java.util.List;

public class CustomerDB {
    private List<Customer> customerList;

    public CustomerDB(){
        this.customerList = new ArrayList<>();
    }

    public List<Customer> getCustomerList(){
        return customerList;
    }

    public Customer getCustomerById(int id){
        if(customerList.isEmpty()){
        //    System.out.println("The list of customers is empty");
            return null;
        }
        for(Customer customer:customerList){
            if(customer.getId() == id){
                return customer;
            }
        }
        //    System.out.println("Customer with id" + id + " not found.");
        return null;
    }

    public boolean addCustomer(Customer customer){
        return customerList.add(customer);
    }

    public void deleteCustomer(Customer customer){
        Customer findCustomer = getCustomerById(customer.getId());
        if(findCustomer != null){
            customerList.remove(findCustomer);
        //    System.out.println("Customer " + customer.getId() + " deleted.");
        }else{
            System.out.println("Customer " + customer.getId() + " not found");
        }
    }
}
