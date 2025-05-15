package com.example.service;

import com.example.dto.InsurancePolicyDTO;
import com.example.model.InsurancePolicy;

import java.util.List;

public interface IPolicyService {
    public Long fetchPagesCount(int pageSize);

    public List<InsurancePolicyDTO> fetchPageData(int pageSize, int pageNo);

}
