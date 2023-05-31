package eapli.base.order.domain;

import eapli.framework.domain.model.DomainFactory;

public class Product_OrderBuilder implements DomainFactory<Product_Order> {

    private Product_Order productOrder;

    @Override
    public Product_Order build() {
        return productOrder;
    }
}
