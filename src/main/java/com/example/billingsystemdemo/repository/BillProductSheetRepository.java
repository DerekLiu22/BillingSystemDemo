package com.example.billingsystemdemo.repository;

import com.example.billingsystemdemo.entity.BillProductSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillProductSheetRepository extends JpaRepository<BillProductSheet, Long> {
}
