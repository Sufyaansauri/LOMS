package com.project.loanOriginationManagementSystem.Controller;

import com.project.loanOriginationManagementSystem.Entity.SystemParameters;
import com.project.loanOriginationManagementSystem.Service.SystemParametersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/systemParameters")
public class SystemParametersController {

    private final SystemParametersService systemParametersService;

    @Autowired
    public SystemParametersController(SystemParametersService systemParametersService) {
        this.systemParametersService = systemParametersService;
    }

        @GetMapping
        public List<SystemParameters> getAllParameters() {
            return systemParametersService.getAllParameters();
        }

    @GetMapping("/{id}")
    public ResponseEntity<SystemParameters> getParameterById(@PathVariable Long id) {
        return systemParametersService.getParameterById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SystemParameters> createParameter(@RequestBody SystemParameters parameter) {
        SystemParameters createdParameter = systemParametersService.createParameter(parameter);
        return ResponseEntity.ok(createdParameter);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SystemParameters> updateParameter(@PathVariable Long id, @RequestBody SystemParameters parameterDetails) {
        SystemParameters updatedParameter = systemParametersService.updateParameter(id, parameterDetails);
        return ResponseEntity.ok(updatedParameter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParameter(@PathVariable Long id) {
        systemParametersService.deleteParameter(id);
        return ResponseEntity.noContent().build();
    }
}