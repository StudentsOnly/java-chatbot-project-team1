import java.util.ArrayList;
import java.util.List;

public class CustomerDB {
    private List<Customer> customerList;

    public CustomerDB(){
        this.customerList = new ArrayList<>();
        addCustomer(new Customer("John", "john.schwarz@gmail.com"));
        addCustomer(new Customer("Klara", "klara.wolf@gmail.com"));
        addCustomer(new Customer("Jessica", "jessica.bill@gmail.com"));
        addCustomer(new Customer("Tobias", "tobias.weiz@gmail.com"));
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
    public Customer getCustomerByName(String name){
        if(customerList.isEmpty()){
            //    System.out.println("The list of customers is empty");
            return null;
        }
        for(Customer customer:customerList){
            if(customer.getName().equals(name.toLowerCase())){
                return customer;
            }
        }
        //    System.out.println("Customer with name'" + name + "' not found.");
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
