package ru.aoNTT.testTask_NTT.service;

import ru.aoNTT.testTask_NTT.models.entity.BranchOrganization;
import ru.aoNTT.testTask_NTT.models.entity.Organization;

import java.util.List;

/**
 * Organization entity service interface
 *
 * @author Строев Д.В.
 * @version 1.0
 */
public interface OrganizationService {

    /**
     * Method of saving entity
     *
     * @param organization entity organization
     * @return entity organization
     */
    Organization save(Organization organization);

    /**
     * Method returning all entities of the organization
     *
     * @return list of entities organization
     */
    List<Organization> findAll();

    /**
     * The method returns a list of organizations by keyword
     *
     * @param query query keyword
     * @return a list of organizations by keyword
     */
    List<Organization> searchOrg(String query);

    /**
     * Method returning entities organization by id
     *
     * @param id entity id organization
     * @return entity organization
     */
    Organization findById(Long id);

    /**
     * Organization entity update method
     *
     * @param id entity id organization
     * @param organization organization
     * @return the updated organization entity
     */
    Organization updateOrganization(Long id, Organization organization);

    /**
     * Organization entity deletion method
     * @param id entity id organization
     */
    void deleteById(Long id);

    /**
     * Method for adding entity organization entity
     * CEO
     *
     * @param id entity id organization
     * @param genDirID id of the CEO entity
     */
    Organization assignGenDir(Long id, Long genDirID);

    /**
     * Method for adding entity organization entity
     * branch of the organization
     *
     * @param id organization id
     * @param branchOrganization entity branch of the organization
     */
    void addBranchOrganizations(Long id, BranchOrganization branchOrganization);

    /**
     * Organization entity creation method
     *
     * @param organization entity organization
     * @return entity organization
     */
    Organization createOrg(Organization organization);


}
