public class Order {
    private static int id = 100;
    private Integer orderId;
    private Status status;

    public Order(){
        this.status = Status.PLACED;
        id++;
        this.orderId = id;
    }


    public int getOrderId(){
        return orderId;
    }

    public Status getStatus(){
        return status;
    }

    public void setStatus(Status status){
        this.status = status;
    }

}
