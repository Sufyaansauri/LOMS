package com.project.loanOriginationManagementSystem.Service;

import com.project.loanOriginationManagementSystem.Entity.LoanProduct;
import com.project.loanOriginationManagementSystem.Repository.LoanProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanProductService {

    @Autowired
    private LoanProductRepository loanProductRepository;

     public List<LoanProduct> getAllLoanProduct(){
         return loanProductRepository.findAll();
     }

     public Optional<LoanProduct> getLoanProductById(Long id){
         return loanProductRepository.findById(id);
     }

     public LoanProduct createLoanProduct(LoanProduct loanProduct){
         return loanProductRepository.save(loanProduct);
     }

     public void deleteLoanProduct(Long id){
         loanProductRepository.deleteById(id);
     }

     public LoanProduct updateLoanProduct(Long id, LoanProduct updatedLoanProduct){
         Optional<LoanProduct> existingLoanProduct = loanProductRepository.findById(id);

         if(existingLoanProduct.isPresent()){
             LoanProduct loanProduct = existingLoanProduct.get();
             loanProduct.setProductCode(updatedLoanProduct.getProductCode());
             loanProduct.setProductName(updatedLoanProduct.getProductName());
             loanProduct.setDescription(updatedLoanProduct.getDescription());
             loanProduct.setInterestRate(updatedLoanProduct.getInterestRate());
             loanProduct.setMaxTenureMonths(updatedLoanProduct.getMaxTenureMonths());
             loanProduct.setAllowCoBorrowers(updatedLoanProduct.isAllowCoBorrowers());

            return loanProductRepository.save(loanProduct);
         }

         return null;
     }
}
