package com.example.billingsystemdemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDateTime billTimeStamp;


    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "bill")
    private List<BillProductSheet> billProductSheets;

    @Transient
    private double billBalance;

    private void calculateBillBalance(){
        double balance = 0;
        for (int i = 0; i < billProductSheets.size(); i++) {
            balance += billProductSheets.get(i).getProductCost();
        }
        this.billBalance = balance;
    }

    @PostLoad
    private void postLoad(){
        this.getBillProductSheets();
        this.calculateBillBalance();
    }



}
