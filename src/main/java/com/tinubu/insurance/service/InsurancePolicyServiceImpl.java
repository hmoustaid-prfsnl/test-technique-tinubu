package com.tinubu.insurance.service;

import com.tinubu.insurance.dto.*;
import com.tinubu.insurance.mapper.InsurancePolicyMapper;
import com.tinubu.insurance.model.InsurancePolicy;
import com.tinubu.insurance.repository.InsurancePolicyRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class InsurancePolicyServiceImpl implements InsurancePolicyService {

    private final InsurancePolicyRepository repository;
    private final InsurancePolicyMapper mapper;

    @Override
    public InsurancePolicyDto createPolicy(CreateInsurancePolicyDto dto) {
        InsurancePolicy policy = mapper.toEntity(dto);
        InsurancePolicy saved = repository.save(policy);
        return mapper.toDto(saved);
    }

    @Override
    public InsurancePolicyDto updatePolicy(Long id, UpdateInsurancePolicyDto dto) {
        InsurancePolicy existing = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("InsurancePolicy not found with id: " + id));

        // MapStruct va mettre à jour les champs non nuls
        mapper.updateEntityFromDto(dto, existing);

        // Les changements sont automatiquement détectés car l'entité est attachée
        return mapper.toDto(existing);
    }

    @Override
    @Transactional(readOnly = true)
    public InsurancePolicyDto getPolicyById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("InsurancePolicy not found with id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<InsurancePolicyDto> getAllPolicies(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toDto);
    }
}
