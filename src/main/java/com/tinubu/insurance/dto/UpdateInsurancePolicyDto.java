package com.tinubu.insurance.dto;

import com.tinubu.insurance.model.PolicyStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


/**
 * DTO utilisé uniquement pour mettre à jour une police d’assurance existante.
 *
 * Pourquoi ne pas réutiliser CreateDto ?
 * - À la mise à jour, on peut vouloir rendre certains champs optionnels.
 * - Le `nullValuePropertyMappingStrategy.IGNORE` de MapStruct permet d'ignorer les champs nulls pour faire des mises à jour partielles.
 * - Clarifie les intentions : ce DTO ne crée pas d'objet, il modifie un objet existant (souvent attaché au contexte JPA).
 * - Évite les erreurs où un champ non renseigné en update (null) écraserait des données existantes.
 */
public record UpdateInsurancePolicyDto(
        @NotBlank String name,
        @NotNull PolicyStatus status,
        @NotNull LocalDate startDate,
        @NotNull LocalDate endDate
) {}
