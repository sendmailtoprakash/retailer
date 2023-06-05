package com.retailer.reward.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Retailer {
    @Id
    @Column(name="Id", unique = true,nullable = false)
    @GeneratedValue
    private Long id;

    @Column(name="customer_id")
    private Long customerId;

    @Column(name="transaction_amount")
    private Double transactionAmount;

    @Column(name="reward_points")
    private Integer rewardPoints;

    @Column(name="transaction_date")
    private Date transactionDate;

    public Retailer(){}

    public Retailer(Long id, Long customerId, Double transactionAmount, Integer rewardPoints, Date transactionDate){
        this.customerId=customerId;
        this.rewardPoints=rewardPoints;
        this.transactionAmount=transactionAmount;
        this.transactionDate=transactionDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Integer getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(Integer rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public Date getTransactionDate(Date date) {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
