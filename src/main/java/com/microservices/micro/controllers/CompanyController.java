package com.microservices.micro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.microservices.micro.models.Company;
import com.microservices.micro.requests.CreateCompanyRequest;
import com.microservices.micro.responses.BasicResponse;
import com.microservices.micro.services.CompanyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    @Autowired

    private CompanyService companyService;

    // create function
    @PostMapping(path ="/")
    public @ResponseBody ResponseEntity<?> insert(@RequestBody @Valid CreateCompanyRequest input) {
        Company company = companyService.create(input);// call function in services
        return new ResponseEntity<>(new BasicResponse("created successfully", "000", company), HttpStatus.OK);
    }

    // updae function
    @PutMapping("/{companyId}")
    public @ResponseBody ResponseEntity<?> update(@PathVariable("companyId") Long companyId,  @RequestBody  CreateCompanyRequest input) {
        Company result = companyService.update(input,companyId);

        if(result ==null){
        return new ResponseEntity<>(new BasicResponse("canot update ", "1234", result), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(new BasicResponse("update successfully", "000", result), HttpStatus.OK);
        }
    }

    // delete function
    @DeleteMapping("/{companyId}")
    public @ResponseBody ResponseEntity<?> deleteBook(@PathVariable("companyId") long companyId) {
        companyService.delete(companyId);
        return new ResponseEntity<>(new BasicResponse("deleted successfully", "111", null), HttpStatus.OK);

    }


}
