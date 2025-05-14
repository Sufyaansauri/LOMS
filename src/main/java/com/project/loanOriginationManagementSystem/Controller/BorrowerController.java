package com.project.loanOriginationManagementSystem.Controller;

import com.project.loanOriginationManagementSystem.Entity.Borrower;
import com.project.loanOriginationManagementSystem.Service.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/borrower")
public class BorrowerController {

    @Autowired
    private BorrowerService borrowerService;

    @GetMapping
    public List<Borrower> getAllBorrower() {
        return borrowerService.getAllBorrower();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Borrower>> getBorrowerById(@PathVariable Long id) {
        Optional<Borrower> borrower = borrowerService.getBorrowerById(id);
        if (borrower.isPresent()) {
            return ResponseEntity.ok(borrower);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrower(@PathVariable Long id) {
        borrowerService.deleteBorrower(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/createBorrower")
    public ResponseEntity<Borrower> createBorrower(@RequestBody Borrower borrower){
        Borrower borrowerCreated = borrowerService.createBorrower(borrower);
        return ResponseEntity.status(HttpStatus.CREATED).body(borrowerCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Borrower> updateBorrower(@PathVariable Long id, @RequestBody Borrower borrower) {
        Borrower updatedBorrower = borrowerService.updateBorrower(id, borrower);
        if (updatedBorrower != null) {
            return ResponseEntity.ok(updatedBorrower);
        }
        return ResponseEntity.notFound().build();
    }

}