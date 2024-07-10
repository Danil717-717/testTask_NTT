package ru.aoNTT.testTask_NTT.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aoNTT.testTask_NTT.models.entity.BranchOrganization;
import ru.aoNTT.testTask_NTT.models.entity.GenDir;
import ru.aoNTT.testTask_NTT.models.entity.Organization;
import ru.aoNTT.testTask_NTT.repository.OrganizationRepository;
import ru.aoNTT.testTask_NTT.service.GenDirService;
import ru.aoNTT.testTask_NTT.service.OrganizationService;

import java.util.ArrayList;
import java.util.List;

/**
 * The class implementing the organization entity service
 *
 * @author Строев Д.В.
 * @version 1.0
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final GenDirService genDirService;

    @Autowired
    public OrganizationServiceImpl(OrganizationRepository organizationRepository, GenDirService genDirService) {
        this.organizationRepository = organizationRepository;
        this.genDirService = genDirService;
    }

    @Override
    public Organization save(Organization organization) {
        return organizationRepository.save(organization);
    }

    @Override
    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }


    @Override
    public List<Organization> searchOrg(String query) {
        List<Organization> organizations =
                organizationRepository.searchOrganizationsByFullNameOrShortName(query);
        return organizations;
    }

    @Override
    public Organization findById(Long id) {
        return organizationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reader not found"));
    }

    @Override
    public Organization updateOrganization(Long id, Organization organization) {
        Organization organizationOld = findById(id);
        if (organizationOld != null) {
            organizationOld.setFullName(organization.getFullName());
            organizationOld.setShortName(organization.getShortName());
            organizationOld.setPostalAddress(organization.getPostalAddress());
            organizationOld.setLegalAddress(organization.getLegalAddress());
            organizationRepository.save(organizationOld);
        }
        return organizationOld;
    }

    @Override
    public void deleteById(Long id) {
        organizationRepository.deleteById(id);
    }

    @Override
    public Organization assignGenDir(Long id, Long genDirID) {
        Organization organization = findById(id);
        GenDir genDirNew = genDirService.findById(genDirID);
        organization.setGenDir(genDirNew);
        organizationRepository.save(organization);
        return organization;
    }

    @Override
    public void addBranchOrganizations(Long id, BranchOrganization branchOrganization) {
        Organization organization = findById(id);
        ArrayList<BranchOrganization> branchOrganizations = new ArrayList<>();
        branchOrganizations.add(branchOrganization);
        organization.setBranchOrganizations(branchOrganizations);
        organizationRepository.save(organization);
    }

    @Override
    public Organization createOrg(Organization organization) {
        return organizationRepository.save(organization);
    }
}
