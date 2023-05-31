package eapli.base.order.dto;

import java.util.Date;

public class Product_OrderDTOComplete {

    public int id;
    public Date registration_time;
    public String customer_name;
    public double total_amount;
    public double totalweight;
    public double totalvolume;

    public Product_OrderDTOComplete(int id, Date registration_time, String customer_name, double total_amount, double totalweight, double totalvolume) {
        this.id = id;
        this.registration_time = registration_time;
        this.customer_name = customer_name;
        this.total_amount = total_amount;
        this.totalweight = totalweight;
        this.totalvolume = totalvolume;
    }

    @Override
    public String toString() {
        return "id=" + id +
                "\n registration_time=" + registration_time +
                "\n customer_name='" + customer_name + '\'' +
                "\n total_amount=" + total_amount +"\n";
    }
}
