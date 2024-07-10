package ru.aoNTT.testTask_NTT.service;

import ru.aoNTT.testTask_NTT.models.entity.GenDir;
import ru.aoNTT.testTask_NTT.models.entity.HeadOrganization;

import java.util.List;

/**
 * Entity service interface head of organization
 *
 * @author Строев Д.В.
 * @version 1.0
 */
public interface HeadOrgService {

    /**
     * Method of preserving the essence of the head of the organization
     *
     * @param headOrganization entity head of the organization
     * @return entity head of organization
     */
    HeadOrganization save(HeadOrganization headOrganization);

    /**
     * Method returning all entities of the head of the organization
     *
     * @return list of entities head of organization
     */
    List<HeadOrganization> findAll();

    /**
     * Method returning all entities of the head of the organization by keyword
     *
     * @param query query keyword
     * @return entities of the head of the organization by keyword
     */
    List<HeadOrganization> searchHeadOrganization(String query);

    /**
     * Method returning entity head of organization by id
     *
     * @param id entity id head of the organization
     * @return entity head of organization
     */
    HeadOrganization findById(Long id);

    /**
     * Method for updating the entity head of the organization
     *
     * @param id entity id head of the organization
     * @param headOrganization head of the organization
     * @return the updated entity head of the organization
     */
    HeadOrganization updateHeadOrg(Long id, HeadOrganization headOrganization);

    /**
     * Method for deleting the entity head of an organization
     * @param id entity id head of the organization
     */
    void deleteById(Long id);

    /**
     * Entity head of the organization creation method
     *
     * @param headOrganization entity head of the organization
     * @return entity head of the organization
     */
    HeadOrganization createHeadOrganization(HeadOrganization headOrganization);
}
