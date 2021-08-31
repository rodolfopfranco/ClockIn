package com.dio.clockIn.service;

import com.dio.clockIn.model.Company;
import com.dio.clockIn.repository.CompanyRepository;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    public Company saveCompany(Company company){
        return companyRepository.save(company);
    }

    public void deleteCompany(Company company){
        companyRepository.deleteById(company.getId());
    }

    public List<Company> listCompany(){
        return companyRepository.findAll();
    }

    public Optional<Company> getCompanyById(Long id){
        return companyRepository.findById(id);
    }

    public Company updateCompany(Company company){
        return companyRepository.save(company);
    }



}
