package com.tinubu.insurance.mapper;

import com.tinubu.insurance.dto.CreateInsurancePolicyDto;
import com.tinubu.insurance.dto.InsurancePolicyDto;
import com.tinubu.insurance.dto.UpdateInsurancePolicyDto;
import com.tinubu.insurance.model.InsurancePolicy;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * Mapper MapStruct pour transformer entre entité JPA {@link InsurancePolicy}
 * et ses différents DTOs (Data Transfer Objects).
 *
 * Pourquoi utiliser MapStruct ?
 * - Évite le code boilerplate manuel entre entités et objets API
 * - Garde le code métier propre et maintenable
 *
 * Ce mapper est enregistré comme un bean Spring grâce à `componentModel = "spring"`.
 */
@Mapper(componentModel = "spring")
public interface InsurancePolicyMapper {

    /**
     * Convertit une entité {@link InsurancePolicy} vers un DTO de lecture {@link InsurancePolicyDto}.
     * Utilisé principalement pour les réponses envoyées par l'API.
     *
     * @param entity L'entité JPA
     * @return Le DTO exposé à l'API
     */
    InsurancePolicyDto toDto(InsurancePolicy entity);

    /**
     * Convertit un DTO de création {@link CreateInsurancePolicyDto} vers une nouvelle entité {@link InsurancePolicy}.
     * Utilisé lors de la création d’une police d’assurance.
     *
     * @param dto Le DTO contenant les données de création
     * @return Une nouvelle entité à sauvegarder en base
     */
    InsurancePolicy toEntity(CreateInsurancePolicyDto dto);

    /**
     * Met à jour une entité existante {@link InsurancePolicy} en modifiant uniquement les champs non-nuls
     * du DTO {@link UpdateInsurancePolicyDto}.
     *
     * Pourquoi cette méthode ?
     * - En JPA, on modifie généralement des entités déjà existantes et attachées au contexte.
     * - Le paramètre `@MappingTarget` permet de modifier l’objet existant en place.
     * - L’option `nullValuePropertyMappingStrategy = IGNORE` garantit que les champs `null`
     *   dans le DTO ne remplacent pas les valeurs existantes dans l’entité.
     *
     * Ne crée pas une nouvelle entité, modifie uniquement l'existante.
     *
     * @param dto    DTO contenant les champs à mettre à jour
     * @param entity L'entité cible à modifier
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(UpdateInsurancePolicyDto dto, @MappingTarget InsurancePolicy entity);
}
