package com.retailer.reward.service;

import com.retailer.reward.dao.RetailerRepository;
import com.retailer.reward.entity.Retailer;
import com.retailer.reward.dao.RetailerJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class RetailerService {
    private RetailerRepository retailerRepository;
    private RetailerJPARepository retailerJPARepository;

    public RetailerService(){}

    @Autowired
    public RetailerService(RetailerRepository retailerRepository, RetailerJPARepository retailerJPARepository){
        this.retailerRepository=retailerRepository;
        this.retailerJPARepository=retailerJPARepository;
    }

    public String addTransaction(Long customerId, Double transactionAmount){
        Retailer r=new Retailer();
        r.setCustomerId(customerId);
        r.setTransactionAmount(transactionAmount);
        LocalDateTime now=LocalDateTime.now();
        r.setTransactionDate(new Date());
        Integer rewardPoints=0;
        if(transactionAmount > 100){
            rewardPoints=2*(transactionAmount.intValue() - 100);
            rewardPoints=rewardPoints+50;
            System.out.println("rewardPoints >100 #########: "+rewardPoints);
        }else if(transactionAmount > 50){
            rewardPoints = transactionAmount.intValue() - 50;
            System.out.println("rewardPoints >50 #########: "+rewardPoints);
        }
        r.setRewardPoints(rewardPoints);
        retailerJPARepository.save(r);
        return "Success";
    }

    public Integer getMonthlyRewardPoints(Long customerId, int year, int month){
       return retailerRepository.getMonthlyRewardPoints(customerId, year,month);
    }

    public Integer getYearlyRewardPoints(Long customerId, int year){
        return retailerRepository.getYearlyRewardPoints(customerId, year);
    }

    public Integer getRewardPointsBetweenDates(Long customerid, Date startDate, Date endDate){
        return retailerRepository.getRewardPointsBetweenDates(customerid, startDate,endDate);
    }

    public List<Retailer> getYearlyTransactions(Long customerid, int year){
        return retailerRepository.getYearlyTransactions(customerid, year);
    }

    public List<Retailer> getMonthlyTransactions(Long customerid, int year, int month){
        return retailerRepository.getMonthlyTransactions(customerid, year, month);
    }

    public Integer getCurrentMonthRewardPoints(Long customerid){
        return retailerRepository.getCurrentMonthRewardPoints(customerid);
    }

    public Integer getCurrentYearRewardPoints(Long customerid){
        return retailerRepository.getCurrentYearRewardPoints(customerid);
    }
    /*public Integer getYearlyRewardPoints(Long customerId, int year){
        List<Retailer> resObjs=retailerRepository.findRetailerByCustomerIdAndTransactionDate_Year(customerId, year);
        return resObjs.stream()
                .mapToInt(Retailer::getRewardPoints)
                .reduce(0, (value1, value2) -> value1 + value2);

    }*/

   /* public Integer getRewardPointsBetweenDates(Long customerId, Date startdate, Date enddate){
        List<Retailer> resObjs=retailerRepository.findRetailerByCustomerIdAndTransactionDateBetween(customerId, startdate, enddate);
        return resObjs.stream()
                .mapToInt(Retailer::getRewardPoints)
                .reduce(0, (value1, value2) -> value1 + value2);
    }*/

    /*public List<Retailer> getMonthlyTransactions(Long customerId, int year, int month){
        List<Retailer> resObjs=retailerRepository.findRetailerByCustomerId(customerId);
        return null;
    }

    public List<Retailer> getYearlyTransactions(Long customerId, int year){
        retailerRepository.findRetailerByCustomerId(customerId);
                return null;
    }*/
}
