package com.example.dao;

import com.example.model.InsurancePolicy;
import com.example.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;


public class PolicyDaoImpl implements IPolicyDao {
    Session hbSession = HibernateUtil.getSession();

    @Override
    public List<InsurancePolicy> getPageData(int pageSize, int startPos) {

        List<InsurancePolicy> resultList = null;
        try {
            Query<InsurancePolicy> query = hbSession.getNamedQuery("GET_ALL_POLICIES");
            //Pagination Settings
            //from index 4(starts from 0), means including index 4 it'll get 5 records from a table
            query.setFirstResult(startPos);
            query.setMaxResults(pageSize);
            resultList = query.getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return resultList;
    }

    @Override
    public Long getTotalRecordsCount() {
        Long count = 0l;
        try {
            Query query = hbSession.getNamedQuery("GET_POLICIES_COUNT");
            List<Long> list = query.list();
            count = list.get(0);
            System.out.println(count + "----" + count.getClass());
        } catch (HibernateException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return count;
    }
}