package com.service.Models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "UserID", nullable = false)
    private Integer userId;

    @Column(name = "PhoneID", nullable = false)
    private Integer phoneId;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "TotalPrice", nullable = false)
    private Double totalPrice;

    @Column(name = "PostingDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date postingDate;

    @ManyToOne
    @JoinColumn(name = "UserID", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "PhoneID", insertable = false, updatable = false)
    private Phone phone;


    public Order() {
    }

    public Order(Integer userId, Integer phoneId, Integer quantity, Date postingDate) {
        this.userId = userId;
        this.phoneId = phoneId;
        this.quantity = quantity;
        this.postingDate = postingDate;
        calculateTotalPrice();
    }


    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
        calculateTotalPrice();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
        calculateTotalPrice();
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Date getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }


    private void calculateTotalPrice() {
        if (phone != null && quantity != null && quantity > 0) {
            totalPrice = phone.getPrice() * quantity;
        } else {
            totalPrice = 0.0;
        }
    }
}
