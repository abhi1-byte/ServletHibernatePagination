package com.example.dao;

import com.example.model.InsurancePolicy;

import java.util.List;

public interface IPolicyDao {
    public List<InsurancePolicy> getPageData(int pageSize, int startPos);

    public Long getTotalRecordsCount();
}
