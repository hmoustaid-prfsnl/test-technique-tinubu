package com.tinubu.insurance.dto;

import com.tinubu.insurance.model.PolicyStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

/**
 * DTO utilisé uniquement pour la création d’une police d’assurance.
 *
 * Pourquoi un DTO spécifique ?
 * - Tous les champs sont requis à la création → on applique des contraintes strictes (@NotBlank, @NotNull)
 * - Permet d'éviter que des champs comme l'id, createdAt ou updatedAt soient renseignés côté client.
 * - Clarifie l’intention : ce DTO est fait pour créer une ressource, pas pour la modifier.
 */
public record CreateInsurancePolicyDto(
        @NotBlank String name,
        @NotNull PolicyStatus status,
        @NotNull LocalDate startDate,
        @NotNull LocalDate endDate
) {}
