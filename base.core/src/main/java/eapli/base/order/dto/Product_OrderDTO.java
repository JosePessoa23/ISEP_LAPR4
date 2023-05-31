package eapli.base.order.dto;

import java.util.Date;

public class Product_OrderDTO {

    public int id;
    public Date registration_time;

    public Product_OrderDTO(int id, Date registration_time) {
        this.id = id;
        this.registration_time = registration_time;
    }
}
