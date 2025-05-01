package com.tinubu.insurance.dto;

import com.tinubu.insurance.mapper.InsurancePolicyMapper;
import com.tinubu.insurance.model.PolicyStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

/**
 * DTO principal pour l'exposition de données liées à une police d’assurance.
 *
 * Ce DTO est utilisé pour retourner une représentation complète et lisible d'une entité {@link com.tinubu.insurance.model.InsurancePolicy}
 * au client via l’API REST.
 *
 * Il contient tous les champs utiles pour la lecture : identifiant, dates, statut, nom de la police,
 * ainsi que les dates d’audit.
 *
 * Pourquoi un DTO de lecture ?
 * - Permet de ne pas exposer directement l’entité JPA (bonne pratique de découplage)
 * - Contrôle les données réellement envoyées côté client
 * - Facilite l’évolution de l’API indépendamment du modèle de données interne
 *
 * Ce DTO peut être produit via {@link InsurancePolicyMapper}.
 *
 * @param id         Identifiant unique de la police
 * @param name       Nom de la police d’assurance
 * @param status     Statut de la police (ACTIVE ou INACTIVE)
 * @param startDate  Date de début de couverture
 * @param endDate    Date de fin de couverture
 * @param createdAt  Date de création (audit)
 * @param updatedAt  Date de dernière mise à jour (audit)
 */
public record InsurancePolicyDto(
        Long id,
        @NotBlank String name,
        @NotNull PolicyStatus status,
        @NotNull LocalDate startDate,
        @NotNull LocalDate endDate,
        LocalDate createdAt,
        LocalDate updatedAt
) {}
