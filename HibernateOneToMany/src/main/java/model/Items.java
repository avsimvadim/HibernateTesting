package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ItemsTable")
public class Items extends IdAutoGeneratedEntity{

    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE", nullable = false)
    private Date date;

    public Items(){}

    public Items(Cart cart, Date date) {
        this.cart = cart;
        this.date = date;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Items2{" +
                "cart=" + cart +
                ", date=" + date +
                '}';
    }
}
