package com.tinubu.insurance.controller;

import com.tinubu.insurance.dto.*;
import com.tinubu.insurance.service.InsurancePolicyService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Créer une nouvelle police d’assurance")
    @PostMapping
    public InsurancePolicyDto createPolicy(@RequestBody @Valid CreateInsurancePolicyDto dto) {
        return policyService.createPolicy(dto);
    }

    @Operation(summary = "Récupérer une police d’assurance par ID")
    @GetMapping("/{id}")
    public InsurancePolicyDto getPolicyById(@PathVariable Long id) {
        return policyService.getPolicyById(id);
    }

    @Operation(summary = "Mettre à jour une police d’assurance existante")
    @PutMapping("/{id}")
    public InsurancePolicyDto updatePolicy(
            @PathVariable Long id,
            @RequestBody @Valid UpdateInsurancePolicyDto dto
    ) {
        return policyService.updatePolicy(id, dto);
    }

    @Operation(summary = "Lister toutes les polices d’assurance avec pagination et tri")
    @GetMapping
    public Page<InsurancePolicyDto> getAllPolicies(Pageable pageable) {
        return policyService.getAllPolicies(pageable);
    }
}
