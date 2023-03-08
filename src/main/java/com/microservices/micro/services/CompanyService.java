package com.microservices.micro.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.microservices.micro.models.Company;
import com.microservices.micro.repos.CompanyRepository;
import com.microservices.micro.requests.CreateCompanyRequest;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    public Company create(CreateCompanyRequest companyRequest) {
        Company company = new Company(0, companyRequest.getName());// remember sorted in collection is important
        Company result = companyRepository.save(company);
        return result;
    }
    public Company update(CreateCompanyRequest companyRequest, long companyId) {
        Company company2 = companyRepository.findById(companyId).get();
        if (company2 == null) {
            return null;
        } else {
            company2.setName(companyRequest.getName());
            Company result = companyRepository.save(company2);
            return result;
        }
    }
    public void delete(long id) {
        companyRepository.deleteById(id);
    }
}
