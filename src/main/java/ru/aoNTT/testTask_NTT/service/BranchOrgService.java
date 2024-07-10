package ru.aoNTT.testTask_NTT.service;

import ru.aoNTT.testTask_NTT.models.entity.BranchOrganization;
import ru.aoNTT.testTask_NTT.models.entity.Organization;

import java.util.List;

/**
 * Organization branch entity service interface
 *
 * @author Строев Д.В.
 * @version 1.0
 */
public interface BranchOrgService {

    /**
     * Method for saving the entity of an organization's branch
     *
     * @param branchOrganization entity branch of organization
     * @return entity branch of organization
     */
    BranchOrganization save(BranchOrganization branchOrganization);

    /**
     * Method returning all entities, branches of organizations
     *
     * @return list of entities of organization branches
     */
    List<BranchOrganization> findAll();

    /**
     * Method returning all entities, branches of organizations by keyword
     *
     * @param query query keyword
     * @return branches of organizations by keyword
     */
    List<BranchOrganization> searchBranchOrg(String query);

    /**
     * Method returning entity branch of organization by id
     *
     * @param id id entity of the organization's branch
     * @return entity branch of organization
     */
    BranchOrganization findById(Long id);

    /**
     * Method for updating an organization's branch entity
     *
     * @param id organization branch entity id
     * @param branchOrganization entity branch of an organization
     * @return entity updated organization branch
     */
    BranchOrganization updateBranchOrg(Long id, BranchOrganization branchOrganization);

    /**
     * Method for deleting an organization branch entity
     *
     * @param id id of the organization's branch entity
     */
    void deleteById(Long id);

    /**
     * Method for adding entity head organization
     * CEO
     *
     * @param id id of the organization's branch entity
     * @param headOrganizationID id of the CEO entity
     */
    BranchOrganization assignHeadOrganization(Long id, Long headOrganizationID);

    /**
     * Branch of organization entity creation method
     *
     * @param branchOrganization entity branch of organization
     * @return entity branch of organization
     */
    BranchOrganization createBranchOrg(BranchOrganization branchOrganization);
}
