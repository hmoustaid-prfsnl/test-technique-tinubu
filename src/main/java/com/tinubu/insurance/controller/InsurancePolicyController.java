package com.tinubu.insurance.controller;

import com.tinubu.insurance.dto.*;
import com.tinubu.insurance.service.InsurancePolicyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/policies")
@RequiredArgsConstructor
public class InsurancePolicyController {

    private final InsurancePolicyService policyService;

    @PostMapping
    public InsurancePolicyDto createPolicy(@RequestBody @Valid CreateInsurancePolicyDto dto) {
        return policyService.createPolicy(dto);
    }

    @GetMapping("/{id}")
    public InsurancePolicyDto getPolicyById(@PathVariable Long id) {
        return policyService.getPolicyById(id);
    }

    @PutMapping("/{id}")
    public InsurancePolicyDto updatePolicy(
            @PathVariable Long id,
            @RequestBody @Valid UpdateInsurancePolicyDto dto
    ) {
        return policyService.updatePolicy(id, dto);
    }

    @GetMapping
    public Page<InsurancePolicyDto> getAllPolicies(Pageable pageable) {
        return policyService.getAllPolicies(pageable);
    }
}
