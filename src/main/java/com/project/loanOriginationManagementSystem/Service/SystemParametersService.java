package com.project.loanOriginationManagementSystem.Service;
import com.project.loanOriginationManagementSystem.Entity.SystemParameters;
import com.project.loanOriginationManagementSystem.Repository.SystemParametersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
    public class SystemParametersService {

        private final SystemParametersRepository systemParametersRepository;

        @Autowired
        public SystemParametersService(SystemParametersRepository systemParametersRepository) {
            this.systemParametersRepository = systemParametersRepository;
        }

        public List<SystemParameters> getAllParameters() {
            return systemParametersRepository.findAll();
        }

        public Optional<SystemParameters> getParameterById(Long parameterId) {
            return systemParametersRepository.findById(parameterId);
        }

        public SystemParameters createParameter(SystemParameters parameter) {
            return systemParametersRepository.save(parameter);
        }

        public SystemParameters updateParameter(Long parameterId, SystemParameters parameterDetails) {
            SystemParameters existingParameter = systemParametersRepository.findById(parameterId)
                    .orElseThrow(() -> new RuntimeException("Parameter not found with id " + parameterId));
            existingParameter.setName(parameterDetails.getName());
            existingParameter.setValue(parameterDetails.getValue());
            existingParameter.setDescription(parameterDetails.getDescription());
            return systemParametersRepository.save(existingParameter);
        }

        public void deleteParameter(Long parameterId) {
            systemParametersRepository.deleteById(parameterId);
        }
    }