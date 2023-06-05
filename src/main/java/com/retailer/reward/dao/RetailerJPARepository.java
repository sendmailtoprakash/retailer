package com.retailer.reward.dao;

import com.retailer.reward.entity.Retailer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RetailerJPARepository extends JpaRepository<Retailer, Long> {
}
