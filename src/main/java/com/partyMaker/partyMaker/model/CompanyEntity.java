package com.partyMaker.partyMaker.model;

import com.partyMaker.partyMaker.model.types.CompanyType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class CompanyEntity extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private CompanyType companyType;

    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }
}
