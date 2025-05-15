package com.example.dto;

import java.io.Serializable;

public class InsurancePolicyDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer policyId;
    private String policyName;
    private String policyType;
    private Integer tenure;

    public Integer getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Integer policyId) {
        this.policyId = policyId;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public Integer getTenure() {
        return tenure;
    }

    public void setTenure(Integer tenure) {
        this.tenure = tenure;
    }

    @Override
    public String toString() {
        return "InsurancePolicy [policyId=" + policyId + ", policyName=" + policyName + ", policyType=" + policyType
                + ", tenure=" + tenure + "]";
    }

}
