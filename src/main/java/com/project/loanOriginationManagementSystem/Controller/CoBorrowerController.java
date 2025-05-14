package com.project.loanOriginationManagementSystem.Controller;

import com.project.loanOriginationManagementSystem.DTO.CoBorrowerDTO;
import com.project.loanOriginationManagementSystem.DTO.CoBorrowerResponseDTO;
import com.project.loanOriginationManagementSystem.Entity.Borrower;
import com.project.loanOriginationManagementSystem.Entity.CoBorrower;
import com.project.loanOriginationManagementSystem.Service.CoBorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/coBorrower")
public class CoBorrowerController {

    @Autowired
    private CoBorrowerService coBorrowerService;

    @GetMapping
    public List<CoBorrowerResponseDTO> getAllCoBorrowers() {
        return coBorrowerService.getAllCoBorrowers();
    }

    @GetMapping("/{id}")
    public CoBorrowerResponseDTO getCoBorrowersById(@PathVariable Long id) {
        return coBorrowerService.getCoBorrowerById(id);
    }



    @PostMapping("/createCoBorrower")
    public ResponseEntity<CoBorrowerResponseDTO> createCoBorrower(@RequestBody CoBorrowerDTO coBorrowerDTO) {
        CoBorrowerResponseDTO createdCoBorrower = coBorrowerService.createCoBorrower(coBorrowerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCoBorrower);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoBorrowerResponseDTO> updateCoBorrower(@PathVariable Long id, @RequestBody CoBorrower coBorrowerDetails) {
        CoBorrowerResponseDTO updatedCoBorrower = coBorrowerService.updateCoBorrower(id, coBorrowerDetails);
        return ResponseEntity.ok(updatedCoBorrower);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoBorrower(@PathVariable Long id) {
        coBorrowerService.deleteCoBorrower(id);
        return ResponseEntity.noContent().build();
    }
}