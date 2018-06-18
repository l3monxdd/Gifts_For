package com.gifts.entity;

import javax.persistence.*;

/**
 * Created by dell on 06.07.17.
 */
@Entity
public class CommodityCounter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int counter;

    @ManyToOne
    private Orders orders;

    @ManyToOne
    private Commodity commodity;

    public CommodityCounter() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }
}
