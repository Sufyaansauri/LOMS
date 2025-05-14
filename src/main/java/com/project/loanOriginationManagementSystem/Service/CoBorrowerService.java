package com.project.loanOriginationManagementSystem.Service;

import com.project.loanOriginationManagementSystem.DTO.CoBorrowerDTO;
import com.project.loanOriginationManagementSystem.DTO.CoBorrowerResponseDTO;
import com.project.loanOriginationManagementSystem.Entity.Borrower;
import com.project.loanOriginationManagementSystem.Entity.CoBorrower;
import com.project.loanOriginationManagementSystem.Repository.BorrowerRepository;
import com.project.loanOriginationManagementSystem.Repository.CoBorrowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CoBorrowerService {

    @Autowired
    private CoBorrowerRepository coBorrowerRepository;

    @Autowired
    private BorrowerRepository borrowerRepository;

    public List<CoBorrowerResponseDTO> getAllCoBorrowers(){
        List<CoBorrower> allCoBorrowers = coBorrowerRepository.findAll();
        return allCoBorrowers.stream().map(this::convertToDTO).toList();

    }

    public CoBorrowerResponseDTO getCoBorrowerById(Long id){
        Optional<CoBorrower> coBorrower = coBorrowerRepository.findById(id);
        return convertToDTO(coBorrower.get());
    }

    public CoBorrowerResponseDTO createCoBorrower(CoBorrowerDTO coBorrowerDTO) {
        // Fetch the borrower from the repository
        Borrower borrower = borrowerRepository.findById(coBorrowerDTO.getBorrowerId())
                .orElseThrow(() -> new RuntimeException("Borrower not found"));

        // Create a new CoBorrower
        CoBorrower coBorrower = new CoBorrower();
        coBorrower.setBorrower(borrower); // Ensure this is not null
        coBorrower.setCoBorrowerType(coBorrowerDTO.getCoBorrowerType());
        coBorrower.setFirstName(coBorrowerDTO.getFirstName());
        coBorrower.setLastName(coBorrowerDTO.getLastName());
        coBorrower.setBusinessName(coBorrowerDTO.getBusinessName());
        coBorrower.setNationalIdNumber(coBorrowerDTO.getNationalIdNumber());
        coBorrower.setEmail(coBorrowerDTO.getEmail());
        coBorrower.setPhone(coBorrowerDTO.getPhone());
        coBorrower.setAddress(coBorrowerDTO.getAddress());
        coBorrower.setRelationshipToBorrower(coBorrowerDTO.getRelationshipToBorrower());

        // Save the CoBorrower and return it
        CoBorrower coBorrowerObject = coBorrowerRepository.save(coBorrower);
        return convertToDTO(coBorrowerObject);
    }

    public void deleteCoBorrower(Long id){
         coBorrowerRepository.deleteById(id);
    }

    public CoBorrowerResponseDTO updateCoBorrower(Long id, CoBorrower updatedData) {
        Optional<CoBorrower> optionalCoBorrower = coBorrowerRepository.findById(id);

        if (optionalCoBorrower.isPresent()) {
            CoBorrower existing = optionalCoBorrower.get();

            existing.setCoBorrowerType(updatedData.getCoBorrowerType());
            existing.setFirstName(updatedData.getFirstName());
            existing.setLastName(updatedData.getLastName());
            existing.setBusinessName(updatedData.getBusinessName());
            existing.setNationalIdNumber(updatedData.getNationalIdNumber());
            existing.setEmail(updatedData.getEmail());
            existing.setPhone(updatedData.getPhone());
            existing.setAddress(updatedData.getAddress());
            existing.setRelationshipToBorrower(updatedData.getRelationshipToBorrower());
            existing.setCreationDate(updatedData.getCreationDate());
            existing.setLastModifiedDate(LocalDateTime.now());

            CoBorrower coBorrowerObject = coBorrowerRepository.save(existing);
            return convertToDTO(coBorrowerObject);
        }
        // If borrower not found, return null
        return null;
    }

    private CoBorrowerResponseDTO convertToDTO(CoBorrower coBorrowerObject){

        return CoBorrowerResponseDTO.builder().
                coBorrowerId(coBorrowerObject.getCoBorrowerId()).
                coBorrowerType(coBorrowerObject.getCoBorrowerType()).
                borrowerId(coBorrowerObject.getBorrower().getBorrowerId()).
                firstName(coBorrowerObject.getFirstName()).
                lastName(coBorrowerObject.getLastName()).
                businessName(coBorrowerObject.getBusinessName()).
                nationalIdNumber(coBorrowerObject.getNationalIdNumber()).
                email(coBorrowerObject.getEmail()).
                phone(coBorrowerObject.getPhone()).
                address(coBorrowerObject.getAddress()).
                relationshipToBorrower(coBorrowerObject.getRelationshipToBorrower()).
                creationDate(coBorrowerObject.getCreationDate()).
                lastModifiedDate(coBorrowerObject.getLastModifiedDate()).
                build();
    }
}
