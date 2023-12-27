package com.PlacementProject.Placement.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PlacementProject.Placement.Model.CompanyDetails;
import com.PlacementProject.Placement.Repository.CompanyRepository;

@Service
public class CompanyService {
    @Autowired
    private  CompanyRepository companyRepository;

    public String addCompanyDetails( CompanyDetails companyDetails) {

        companyRepository.save(companyDetails);
        return "DETAILS_ARE_INSERTED";
    }

    public CompanyDetails getCompanyDetailsById(Long id) {
        return companyRepository.findById(id).get();
    }

    public List<CompanyDetails> getAllCompanyDetails() {
    
        List<CompanyDetails> details=companyRepository.findAll();

         return details;
    }

    public String updateCompanyDetails(Long id, CompanyDetails companyDetails) {

        Optional<CompanyDetails> companyDetails2=companyRepository.findById(id);
        CompanyDetails comw=companyDetails2.get();


        if(Objects.nonNull(companyDetails.getCompanyName()) && " ".equalsIgnoreCase(companyDetails.getCompanyName()))
        {
           comw.setCompanyName(companyDetails.getCompanyName());
        }

          if(Objects.nonNull(companyDetails.getLocation()) && " ".equalsIgnoreCase(companyDetails.getLocation()))
        {
           comw.setLocation(companyDetails.getLocation());
        }

          if(Objects.nonNull(companyDetails.getDescription()) && " ".equalsIgnoreCase(companyDetails.getDescription()))
        {
           comw.setDescription(companyDetails.getDescription());
        }

          if(Objects.nonNull(companyDetails.getSalary()) && " ".equalsIgnoreCase(companyDetails.getSalary()))
        {
           comw.setSalary(companyDetails.getSalary());
        }
         if(Objects.nonNull(companyDetails.getStudentsRequired()) && " ".equalsIgnoreCase(companyDetails.getStudentsRequired()))
        {
           comw.setStudentsRequired(companyDetails.getStudentsRequired());
        }
        
        companyRepository.save(companyDetails); 

        return "Updated";
    }

    public String deletecompanyDetails(Long id) {
        companyRepository.deleteById(id);
        return "deleted";
    }






}
