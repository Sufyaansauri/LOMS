package com.project.loanOriginationManagementSystem.Service;

import com.project.loanOriginationManagementSystem.DTO.SubSystemParametersDTO;
import com.project.loanOriginationManagementSystem.Entity.SubSystemParameters;
import com.project.loanOriginationManagementSystem.Entity.SystemParameters;
import com.project.loanOriginationManagementSystem.Repository.SubSystemParametersRepository;
import com.project.loanOriginationManagementSystem.Repository.SystemParametersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubSystemParametersService {

    public   SubSystemParametersRepository subSystemParametersRepository;
    @Autowired
    private SystemParametersRepository systemParametersRepository;

    @Autowired
    public SubSystemParametersService(SubSystemParametersRepository subSystemParametersRepository){
        this.subSystemParametersRepository = subSystemParametersRepository;
    }

    public List<SubSystemParameters> getAllParameters() {
        return subSystemParametersRepository.findAll();
    }

    public Optional<SubSystemParameters> getBySubParamId(Long subParamId) {
        return subSystemParametersRepository.findById(subParamId);
    }


    public SubSystemParameters create(SubSystemParametersDTO dto) {
        SubSystemParameters entity = new SubSystemParameters();

        if (dto.getSystemParamId() != null) {
            SystemParameters systemParam = systemParametersRepository.findById(dto.getSystemParamId())
                    .orElseThrow(() -> new RuntimeException("SystemParameter not found"));
            entity.setSystemParameter(systemParam);
        }

        entity.setKeyColumn(dto.getKeyColumn());
        entity.setValue(dto.getValue());

        return subSystemParametersRepository.save(entity);
    }

    public SubSystemParameters update(Long id, SubSystemParametersDTO dto) {
        SubSystemParameters existing = subSystemParametersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SubSystemParameter not found"));



        if (dto.getSystemParamId() != null) {
            SystemParameters systemParam = systemParametersRepository.findById(dto.getSystemParamId())
                    .orElseThrow(() -> new RuntimeException("SystemParameter not found"));
            existing.setSystemParameter(systemParam);
        }

        if (dto.getKeyColumn() != null) {
            existing.setKeyColumn(dto.getKeyColumn());
        }

        if (dto.getValue() != null) {
            existing.setValue(dto.getValue());
        }

        return subSystemParametersRepository.save(existing);
    }

    public void deleteSubParameter(Long subParamId) {
        subSystemParametersRepository.deleteById(subParamId);
    }

}



