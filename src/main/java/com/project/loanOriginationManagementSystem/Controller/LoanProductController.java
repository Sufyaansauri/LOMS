package com.project.loanOriginationManagementSystem.Controller;

import com.project.loanOriginationManagementSystem.Entity.LoanProduct;
import com.project.loanOriginationManagementSystem.Service.LoanProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/loanProduct")
public class LoanProductController {

    @Autowired
    private LoanProductService loanProductService;

    @GetMapping
    public List<LoanProduct> getAllLoanProduct(){
        return loanProductService.getAllLoanProduct();
    }

    @GetMapping("/{id}")
    public Optional<LoanProduct> getLoanProductById(@PathVariable Long id){
        return loanProductService.getLoanProductById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoanProduct(@PathVariable Long id) {
        loanProductService.deleteLoanProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/createLoanProduct")
    public ResponseEntity<LoanProduct> createLoanProduct(@RequestBody LoanProduct loanProduct){
        LoanProduct loanProductCreated = loanProductService.createLoanProduct(loanProduct);
        return ResponseEntity.status(HttpStatus.CREATED).body(loanProductCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoanProduct> updateLoanProduct(@PathVariable Long id, @RequestBody LoanProduct loanProduct) {
        LoanProduct updatedLoanProduct = loanProductService.updateLoanProduct(id, loanProduct);
        if (updatedLoanProduct != null) {
            return ResponseEntity.ok(updatedLoanProduct);
        }
        return ResponseEntity.notFound().build();
    }
}
