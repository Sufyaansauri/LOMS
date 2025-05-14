package com.project.loanOriginationManagementSystem.Service;

import com.project.loanOriginationManagementSystem.Entity.Borrower;
import com.project.loanOriginationManagementSystem.Repository.BorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowerService {

    @Autowired
    private BorrowerRepository borrowerRepository;

    public List<Borrower> getAllBorrower(){
        return borrowerRepository.findAll();
    }

    public Optional<Borrower> getBorrowerById(Long id){
        return borrowerRepository.findById(id);
    }

    public Borrower createBorrower(Borrower borrower){
        return borrowerRepository.save(borrower);
    }

    public void deleteBorrower(Long id){
        borrowerRepository.deleteById(id);
    }


public Borrower updateBorrower(Long id, Borrower updatedBorrower) {

    Optional<Borrower> existingBorrower = borrowerRepository.findById(id);


    if (existingBorrower.isPresent()) {
        Borrower borrower = existingBorrower.get();
        borrower.setBorrowerType(updatedBorrower.getBorrowerType());
        borrower.setFirstName(updatedBorrower.getFirstName());
        borrower.setLastName(updatedBorrower.getLastName());
        borrower.setBusinessName(updatedBorrower.getBusinessName());
        borrower.setNationalId(updatedBorrower.getNationalId());
        borrower.setTaxId(updatedBorrower.getTaxId());
        borrower.setAddress(updatedBorrower.getAddress());
        borrower.setPhone(updatedBorrower.getPhone());
        borrower.setEmail(updatedBorrower.getEmail());


        // Save and return the updated borrower
        return borrowerRepository.save(borrower);
    }

    // If borrower not found, return null
    return null;
}


}
