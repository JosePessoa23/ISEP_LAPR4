package eapli.base.order.domain;


public enum State {
    Registered("Registered") ,
    Payment_pending("Payment pending"),
    To_be_prepared("To_be_prepared") ,
    Being_prepared_on_the_warehouse("Being prepared on the warehouse"),
    Ready_for_packaging("Ready for packaging") ,
    Ready_for_carrier_dispatching (" Ready for carrier dispatching") ,
    Dispatched("Dispatched") ,
    Delivered_by_carrier ("Delivered by carrier");

    private String descricao;

    State(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
