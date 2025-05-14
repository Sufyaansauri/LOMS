package com.project.loanOriginationManagementSystem.Controller;


import com.project.loanOriginationManagementSystem.DTO.SubSystemParametersDTO;
import com.project.loanOriginationManagementSystem.Entity.SubSystemParameters;
import com.project.loanOriginationManagementSystem.Service.SubSystemParametersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subSystemParameters")
public class SubSystemParametersController {

    public   SubSystemParametersService subSystemParametersService;

    @Autowired
    public SubSystemParametersController(SubSystemParametersService subSystemParametersService) {
        this.subSystemParametersService = subSystemParametersService;
    }

    @GetMapping
    public List<SubSystemParameters> getAllParameters() {
        return subSystemParametersService.getAllParameters();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubSystemParameters> getParameterById(@PathVariable Long id) {
        return subSystemParametersService.getBySubParamId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<SubSystemParameters> create(@RequestBody SubSystemParametersDTO dto) {
        SubSystemParameters created = subSystemParametersService.create(dto);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubSystemParameters> update(
            @PathVariable Long id,
            @RequestBody SubSystemParametersDTO dto) {
        SubSystemParameters updated = subSystemParametersService.update(id, dto);
        return ResponseEntity.ok(updated);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParameter(@PathVariable Long id) {
        subSystemParametersService.deleteSubParameter(id);
        return ResponseEntity.noContent().build();
    }
}
