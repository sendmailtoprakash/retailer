package com.retailer.reward.controller;

import com.retailer.reward.entity.Retailer;
import com.retailer.reward.service.RetailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/retailer/customer")
public class RewardController {

    private RetailerService retailerService;

    private RewardController(){}

    @Autowired
    private RewardController(RetailerService retailerService){
        this.retailerService=retailerService;
    }

    @GetMapping(value="/addTransaction")
    public String addTransaction(@RequestParam("customerId") Long customerId,
                                 @RequestParam("transactionAmount") Double transactionAmount ){
        return retailerService.addTransaction(customerId, transactionAmount);
    }

    @GetMapping(value="/getMonthlyRewardPoints")
    public Integer getMonthlyRewardPoints(@RequestParam("customerId") Long customerId,
                                          @RequestParam("year") int year,
                                          @RequestParam("month") int month){
        return retailerService.getMonthlyRewardPoints(customerId,year,month);
    }

    @GetMapping(value="/getRewardPointsBetweenDates")
    public Integer getRewardPointsBetweenDates(Long customerid, Date startDate, Date endDate){
        return retailerService.getRewardPointsBetweenDates(customerid, startDate,endDate);
    }

    @GetMapping(value="/getYearlyRewardPoints")
    public Integer getYearlyRewardPoints(@RequestParam("customerId") Long customerId,
                                         @RequestParam("year") int year){
        return retailerService.getYearlyRewardPoints(customerId,year);
    }

    @GetMapping(value="/getYearlyTransactions", produces = "application/json")
    public List<Retailer> getYearlyTransactions(Long customerid, int year){
        return retailerService.getYearlyTransactions(customerid, year);
    }
    @GetMapping(value="/getMonthlyTransactions", produces = "application/json")
    public List<Retailer> getMonthlyTransactions(Long customerid, int year, int month){
        return retailerService.getMonthlyTransactions(customerid, year, month);
    }
    @GetMapping(value="/getCurrentMonthRewardPoints")
    public Integer getCurrentMonthRewardPoints(Long customerid){
        return retailerService.getCurrentMonthRewardPoints(customerid);
    }
    @GetMapping(value="/getCurrentYearRewardPoints")
    public Integer getCurrentYearRewardPoints(Long customerid){
        return retailerService.getCurrentYearRewardPoints(customerid);
    }

}
