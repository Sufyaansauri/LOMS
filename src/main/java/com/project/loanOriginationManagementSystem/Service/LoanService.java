package com.project.loanOriginationManagementSystem.Service;

import com.project.loanOriginationManagementSystem.DTO.LoanDTO;
import com.project.loanOriginationManagementSystem.DTO.LoanResponseDTO;
import com.project.loanOriginationManagementSystem.Entity.Borrower;
import com.project.loanOriginationManagementSystem.Entity.CoBorrower;
import com.project.loanOriginationManagementSystem.Entity.Loan;
import com.project.loanOriginationManagementSystem.Entity.LoanProduct;
import com.project.loanOriginationManagementSystem.Repository.BorrowerRepository;
import com.project.loanOriginationManagementSystem.Repository.LoanProductRepository;
import com.project.loanOriginationManagementSystem.Repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private LoanProductRepository loanProductRepository;

    @Autowired
    private BorrowerRepository borrowerRepository;

    public List<LoanResponseDTO> getAllLoan(){
        List<Loan> allLoan = loanRepository.findAll();
        return allLoan.stream().map(this::convertToDTO).toList();
    }

    public LoanResponseDTO getAllLoanById(Long id){
       Optional<Loan> loan = loanRepository.findById(id);
       return convertToDTO(loan.get());
    }


    public void deleteLoan(Long id){
        loanRepository.deleteById(id);
    }

    public LoanResponseDTO createLoan(LoanDTO loanDTO){
        Borrower borrower = borrowerRepository.findById(loanDTO.getBorrowerId())
                .orElseThrow(() -> new RuntimeException("Borrower not found"));

        LoanProduct loanProduct = loanProductRepository.findById(loanDTO.getLoanProductId())
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        Loan loan = new Loan();
          loan.setBorrower(borrower);
          loan.setLoanProduct(loanProduct);
          loan.setPrincipalAmount(loanDTO.getPrincipalAmount());
          loan.setInterestRate(loanDTO.getInterestRate());
          loan.setTenureMonths(loanDTO.getTenureMonths());
          loan.setDisbursalDate(loanDTO.getDisbursalDate());
          loan.setStatus(loanDTO.getStatus());
          loan.setHasCoBorrowers(loanDTO.getHasCoBorrowers());
          loan.setTotalLiabilitySplit(loanDTO.getTotalLiabilitySplit());

          Loan loanObject = loanRepository.save(loan);
          return convertToDTO(loanObject);
    }

    public LoanResponseDTO updateLoan(Long id, Loan updatedLoan){
        Optional<Loan> optionalLoan = loanRepository.findById(id);

        if (optionalLoan.isPresent()){
            Loan existing = optionalLoan.get();

            existing.setPrincipalAmount(updatedLoan.getPrincipalAmount());
            existing.setInterestRate(updatedLoan.getInterestRate());
            existing.setTenureMonths(updatedLoan.getTenureMonths());
            existing.setDisbursalDate(updatedLoan.getDisbursalDate());
            existing.setStatus(updatedLoan.getStatus());
            existing.setHasCoBorrowers(updatedLoan.getHasCoBorrowers());
            existing.setTotalLiabilitySplit(updatedLoan.getTotalLiabilitySplit());
            existing.setCreatedAt(updatedLoan.getCreatedAt());
            existing.setUpdatedAt(updatedLoan.getUpdatedAt());

            Loan loanObject = loanRepository.save(existing);
            return convertToDTO(loanObject);
        }
        // If borrower not found, return null
        return null;
    }




    private LoanResponseDTO convertToDTO(Loan loanObject){
        return LoanResponseDTO.builder().
                loanId(loanObject.getLoanId()).
                borrowerId(loanObject.getBorrower().getBorrowerId()).
                loanProductId(loanObject.getLoanProduct().getLoanProductId()).
                principalAmount(loanObject.getPrincipalAmount()).
                interestRate(loanObject.getInterestRate()).
                tenureMonths(loanObject.getTenureMonths()).
                disbursalDate(loanObject.getDisbursalDate()).
                status(loanObject.getStatus()).
                hasCoBorrowers(loanObject.getHasCoBorrowers()).
                totalLiabilitySplit(loanObject.getTotalLiabilitySplit()).
                createdAt(loanObject.getCreatedAt()).
                updatedAt(loanObject.getUpdatedAt()).
                build();
    }

}
