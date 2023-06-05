package com.retailer.reward.dao;

import com.retailer.reward.entity.Retailer;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RetailerRepository{
    @PersistenceContext
    private EntityManager entityManager;

    public Integer getCurrentMonthRewardPoints(Long customerid){
        String query="SELECT sum(reward_points) FROM retailer WHERE customer_id= "+customerid+" and YEAR(transaction_date) = YEAR(CURRENT_DATE()) AND MONTH(transaction_date) = MONTH(CURRENT_DATE())";
        Query nativeQuery = entityManager.createNativeQuery(query);
        Object obj=nativeQuery.getSingleResult();
        return Integer.parseInt(obj.toString());
    }

    public Integer getCurrentYearRewardPoints(Long customerid){
        String query="SELECT sum(reward_points) FROM retailer WHERE customer_id= "+customerid+" and YEAR(transaction_date) = YEAR(CURRENT_DATE())";
        Query nativeQuery = entityManager.createNativeQuery(query);
        Object obj=nativeQuery.getSingleResult();
        return Integer.parseInt(obj.toString());
    }

    public Integer getMonthlyRewardPoints(Long customerid, int year, int month){
        String query="SELECT sum(reward_points) FROM retailer WHERE customer_id= "+customerid+" " +
                "and  YEAR(transaction_date) = "+year+" AND MONTH(transaction_date) = "+month;
        Query nativeQuery = entityManager.createNativeQuery(query);
        Object obj=nativeQuery.getSingleResult();
        return Integer.parseInt(obj.toString());
    }

    public Integer getYearlyRewardPoints(Long customerid, int year){
        String query="SELECT sum(reward_points) FROM retailer WHERE customer_id= "+customerid+" " +
                     "and  YEAR(transaction_date) = "+year;
        Query nativeQuery = entityManager.createNativeQuery(query);
        Object obj=nativeQuery.getSingleResult();
        return Integer.parseInt(obj.toString());
    }

    public Integer getRewardPointsBetweenDates(Long customerid, Date startDate, Date endDate){
        String query="SELECT * FROM retailer WHERE transaction_date between '"+startDate+"' AND '"+endDate+"'";
        Query nativeQuery = entityManager.createNativeQuery(query);
        Object obj=nativeQuery.getSingleResult();
        return Integer.parseInt(obj.toString());
    }

    public List<Retailer> getYearlyTransactions(Long customerid, int year){
        String query="SELECT * FROM retailer WHERE customer_id= "+customerid+" " +
                "and  YEAR(transaction_date) = "+year;
        Query nativeQuery = entityManager.createNativeQuery(query, Retailer.class);
        return nativeQuery.getResultList();
    }

    public List<Retailer>  getMonthlyTransactions(Long customerid, int year, int month){
        String query="SELECT * FROM retailer WHERE customer_id= "+customerid+" " +
                "and  YEAR(transaction_date) = "+year+" AND MONTH(transaction_date) = "+month;
        Query nativeQuery = entityManager.createNativeQuery(query, Retailer.class);
        return nativeQuery.getResultList();
    }


    /*@Query(value = "SELECT sum(reward_points) FROM retailer WHERE customer_id= :customerid and YEAR(transaction_date) = YEAR(CURRENT_DATE()) AND MONTH(transaction_date) = MONTH(CURRENT_DATE())", nativeQuery = true)
    public Integer getCurrentMonthRewardPoints(@Param("customerid") Long customerid);

    @Query(value = "SELECT sum(reward_points) FROM retailer WHERE customer_id= :customerid and  YEAR(transaction_date) = YEAR(CURRENT_DATE())", nativeQuery = true)
    public Integer getCurrentYearRewardPoints(@Param("customerid") Long customerid);

    @Query(value = "SELECT sum(reward_points) FROM retailer WHERE customer_id= :customerid and  YEAR(transaction_date) = :year AND MONTH(transaction_date) = :month", nativeQuery = true)
    public Integer getMonthlyRewardPoints(@Param("year") int year,@Param("month") int month,@Param("customerid") Long customerid);

    @Query(value = "SELECT sum(reward_points) FROM retailer WHERE customer_id= :customerid and  YEAR(transaction_date) = :year", nativeQuery = true)
    public Integer getYearlyRewardPoints(@Param("year") int year, @Param("customerid") Long customerid);

    @Query(value = "SELECT sum(reward_points) FROM retailer WHERE customer_id= :customerid and  YEAR(transaction_date) = :year", nativeQuery = true)
    public Integer getRewardPointsBetweenDates(@Param("startdate") Date startdate, @Param("enddate") Date enddate, @Param("customerid") Long customerid);

    @Query(value = "SELECT * FROM retailer WHERE customer_id= :customerid and  YEAR(transaction_date) = :year AND MONTH(transaction_date) = :month", nativeQuery = true)
    List<Retailer> getMonthlyTransactions(@Param("year") int year, @Param("month") int month, @Param("customerid") Long customerid);

    @Query(value = "SELECT * FROM retailer WHERE customer_id= :customerid and  YEAR(transaction_date) = :year", nativeQuery = true)
    List<Retailer>  getYearlyTransactions(@Param("year") int year, @Param("customerid") Long customerid);
    */

}
