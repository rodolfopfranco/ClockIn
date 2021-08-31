package com.dio.clockIn.controller;

import com.dio.clockIn.model.Company;
import com.dio.clockIn.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;

    @PostMapping
    public Company createCompany(@RequestBody Company company){
        return companyService.saveCompany(company);
    }

    @GetMapping("/list")
    public List<Company> getCompany(){
        return companyService.listCompany();
    }

    @GetMapping("/{idCompany}")
    public ResponseEntity<Company> getCompanyById(@PathVariable("idCompany") long id) throws Exception {
        return ResponseEntity.ok(
                companyService.getCompanyById(id).orElseThrow(()->new Exception("Company not found"))
        );
    }

    @PutMapping
    public Company updateCompany(@RequestBody Company company){
        return companyService.updateCompany(company);
    }

    @DeleteMapping("/{idCompany}")
    public ResponseEntity deleteCompanyById(@PathVariable("idCompany") long id) {
        try{
            companyService.deleteCompany(id);
        } catch(Exception e){
            System.out.println("Id não encontrado");
        }
        return (ResponseEntity<Company>) ResponseEntity.ok();
    }
}
