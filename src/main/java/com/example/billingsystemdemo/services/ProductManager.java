package com.example.billingsystemdemo.services;

import com.example.billingsystemdemo.entity.Product;
import com.example.billingsystemdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager {

    @Autowired
    private ProductRepository pr;

    public void addNewProduct(int inventory, double cost) {
        Product newProduct = new Product();
        newProduct.setInventory(inventory);
        newProduct.setCost(cost);
        pr.save(newProduct);
    }

    public Product getProductByID(long id){
        return pr.findById(id).get();
    }

    public long countProducts(){
        return pr.count();
    }

    public List<Product> getProductWithZeroInventory(){
        return pr.getProductWithNoInvent();
    }

    public int countProductWithZeroInventory(){
        return pr.getProductWithNoInvent().size();
    }

}
