package com.tinubu.insurance.service;

import com.tinubu.insurance.dto.CreateInsurancePolicyDto;
import com.tinubu.insurance.dto.InsurancePolicyDto;
import com.tinubu.insurance.dto.UpdateInsurancePolicyDto;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

public interface InsurancePolicyService {

    InsurancePolicyDto createPolicy(CreateInsurancePolicyDto dto);

    InsurancePolicyDto updatePolicy(Long id, UpdateInsurancePolicyDto dto);

    InsurancePolicyDto getPolicyById(Long id);

    Page<InsurancePolicyDto> getAllPolicies(Pageable pageable);
}
