package com.example.billingsystemdemo.services;

import com.example.billingsystemdemo.entity.Bill;
import com.example.billingsystemdemo.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillManager {
    @Autowired
    private BillRepository br;

    public Bill getBillByID(long id) {
        return br.findById(id).get();
    }

    public double getBillCostByID(long id) {
        return br.findById(id).get().getBillBalance();
    }
}
