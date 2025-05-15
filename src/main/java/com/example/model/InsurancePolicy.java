package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "premiuminsurancepolicy")
@NamedQuery(name = "GET_POLICIES_COUNT", query = "select count(*) from InsurancePolicy")
// count type from database is bigInt so in java handle it's long
@NamedQuery(name = "GET_ALL_POLICIES", query = "from InsurancePolicy")
public class InsurancePolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid")
    private Integer policyId;
    @Column(name = "pname", length = 45)
    private String policyName;
    @Column(name = "ptype")
    private String policyType;
    @Column(name = "tenure")
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
        return "InsurancePolicy [policyId=" + policyId + ", policyName=" + policyName
                + ", ptype=" + policyType + ", tenure=" + tenure + "]";
    }
}
