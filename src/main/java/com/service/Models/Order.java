package com.service.Models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "UserID", nullable = false)
    private Long userId;

    @Column(name = "PhoneID", nullable = false)
    private Long phoneId;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "TotalPrice", nullable = false)
    private Double totalPrice;

    @Column(name = "PostingDate", nullable = false)
    private LocalDate postingDate;

    @ManyToOne
    @JoinColumn(name = "UserID", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "PhoneID", insertable = false, updatable = false)
    private Phone phone;


    public Order() {
    }

    public Order(Long userId, Long phoneId, Integer quantity, LocalDate postingDate) {
        this.userId = userId;
        this.phoneId = phoneId;
        this.quantity = quantity;
        this.postingDate = postingDate;
        calculateTotalPrice();
    }


    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Long phoneId) {
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

    public LocalDate getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(LocalDate postingDate) {
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
