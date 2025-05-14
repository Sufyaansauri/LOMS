package com.project.loanOriginationManagementSystem.Controller;

import com.project.loanOriginationManagementSystem.DTO.LoanDTO;
import com.project.loanOriginationManagementSystem.DTO.LoanResponseDTO;
import com.project.loanOriginationManagementSystem.Entity.Loan;
import com.project.loanOriginationManagementSystem.Service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping
    public List<LoanResponseDTO> getAllLoan(){
        return loanService.getAllLoan();
    }

    @GetMapping("/{id}")
    public LoanResponseDTO getAllLoanById(@PathVariable Long id){
        return loanService.getAllLoanById(id);
    }


    @PostMapping("/createLoan")
    public ResponseEntity<LoanResponseDTO> createLoan(@RequestBody LoanDTO loanDTO) {
        LoanResponseDTO createdLoan = loanService.createLoan(loanDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLoan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoanResponseDTO> updateLoan(@PathVariable Long id, @RequestBody Loan loanDetails) {
        LoanResponseDTO updatedLoan = loanService.updateLoan(id, loanDetails);
        return ResponseEntity.ok(updatedLoan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        loanService.deleteLoan(id);
        return ResponseEntity.noContent().build();
    }

}
