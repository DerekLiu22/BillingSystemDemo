package com.example.billingsystemdemo;

import com.example.billingsystemdemo.entity.Bill;
import com.example.billingsystemdemo.entity.BillProductSheet;
import com.example.billingsystemdemo.entity.Customer;
import com.example.billingsystemdemo.entity.Product;
import com.example.billingsystemdemo.repository.BillProductSheetRepository;
import com.example.billingsystemdemo.repository.BillRepository;
import com.example.billingsystemdemo.repository.CustomerRepository;
import com.example.billingsystemdemo.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class BillingSystemDemoApplicationTests {

    @Autowired
    private ProductRepository pr;

    @Autowired
    private CustomerRepository cr;

    @Autowired
    private BillProductSheetRepository bpsr;

    @Autowired
    private BillRepository br;

    @Test
    void contextLoads() {
    }

    @Test
    void testProduct() {
        Product book = new Product();
        book.setProductName("book");
        book.setInventory(99);
        book.setCost(10);
        pr.save(book);
        pr.count();
    }

    @Test
    void testCustomer(){
        Customer derek = new Customer();
        derek.setLastName("Liu");
        derek.setFirstName("Derek");
        cr.save(derek);
    }

    @Test
    @Transactional
    void testBillProductSheet(){
        Product tv = new Product();
        tv.setProductName("book");
        tv.setInventory(90);
        tv.setCost(11);
        pr.save(tv);

        Customer customer = new Customer();
        customer.setLastName("Liu");
        customer.setFirstName("Freddy");
        cr.save(customer);

        BillProductSheet bps = new BillProductSheet();
        bps.setProduct(tv);
        bps.setProductQuantity(20);
        bpsr.save(bps);
        System.out.println("Product Cost is " + bps.getProductCost());
    }

    @Test
    void testBill(){

        Product tv = new Product();
        tv.setProductName("book");
        tv.setInventory(90);
        tv.setCost(11);
        pr.save(tv);

        Customer customer = new Customer();
        customer.setLastName("Liu");
        customer.setFirstName("Freddy");
        cr.save(customer);

        BillProductSheet bps = new BillProductSheet();
        bps.setProduct(tv);
        bps.setProductQuantity(20);
        System.out.println(bps.getProductCost());
        bpsr.save(bps);

        Bill bill = new Bill();
        bill.setBillTimeStamp(LocalDateTime.now());
        bill.setCustomer(customer);
        bill.setBillProductSheets(List.of(new BillProductSheet[]{bps}));
        br.save(bill);
        System.out.println(bill.getBillBalance());
    }
}
