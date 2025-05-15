package com.example.service;

import com.example.dao.IPolicyDao;
import com.example.dao.PolicyDaoImpl;
import com.example.dto.InsurancePolicyDTO;
import com.example.model.InsurancePolicy;

import java.util.ArrayList;
import java.util.List;

public class PolicyServiceImpl implements IPolicyService {
    IPolicyDao dao;

    public PolicyServiceImpl() {
        dao = new PolicyDaoImpl();
    }

    @Override
    public Long fetchPagesCount(int pageSize) {
        Long totalRecords = dao.getTotalRecordsCount();
        Long pageCount = totalRecords / pageSize; // 8/3 -> 2
        if (totalRecords % pageSize != 0) // 8%3 = 1(which is not equal to 0)
            pageCount++; // 2++ = 3
        return pageCount; // 3
    }

    @Override
    public List<InsurancePolicyDTO> fetchPageData(int pageSize, int pageNo) {
        int startPos = (pageNo * pageSize) - pageSize;
        List<InsurancePolicyDTO> list = new ArrayList();
        List<InsurancePolicy> entities = dao.getPageData(pageSize, startPos);
        entities.forEach(entity ->
        {
            InsurancePolicyDTO dto = new InsurancePolicyDTO();
            dto.setPolicyId(entity.getPolicyId());
            dto.setPolicyName(entity.getPolicyName());
            dto.setPolicyType(entity.getPolicyType());
            dto.setTenure(entity.getTenure());
            list.add(dto);
        });
        return list;
    }

   /* public int[] getStartPosition(int pageCount,int pageSize){
        int startPos[] = new int[pageCount];
        int pageNumber = 1;
        for(int i = 0;i<startPos.length;i++){
            startPos[i] = (pageNumber * pageSize)-pageSize;
            pageNumber++;
        }
        return startPos;
    }*/
}
