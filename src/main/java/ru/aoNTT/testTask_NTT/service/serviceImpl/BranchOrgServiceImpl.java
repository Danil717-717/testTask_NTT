package ru.aoNTT.testTask_NTT.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aoNTT.testTask_NTT.models.entity.BranchOrganization;
import ru.aoNTT.testTask_NTT.models.entity.HeadOrganization;
import ru.aoNTT.testTask_NTT.repository.BranchOrgRepository;
import ru.aoNTT.testTask_NTT.service.BranchOrgService;
import ru.aoNTT.testTask_NTT.service.HeadOrgService;

import java.util.List;

/**
 * A class that implements the service entity branch of an organization
 *
 * @author Строев Д.В.
 * @version 1.0
 */
@Service
public class BranchOrgServiceImpl implements BranchOrgService {

    private final BranchOrgRepository branchOrgRepository;

    private final HeadOrgService headOrgService;

    @Autowired
    public BranchOrgServiceImpl(BranchOrgRepository branchOrgRepository, HeadOrgService headOrgService) {
        this.branchOrgRepository = branchOrgRepository;
        this.headOrgService = headOrgService;
    }

    @Override
    public BranchOrganization save(BranchOrganization branchOrganization) {
        return branchOrgRepository.save(branchOrganization);
    }

    @Override
    public List<BranchOrganization> findAll() {
        return branchOrgRepository.findAll();
    }

    @Override
    public List<BranchOrganization> searchBranchOrg(String query) {
        List<BranchOrganization> branchOrganizations =
                branchOrgRepository.searchBranchOrganizationsByNameOrAddress(query);
        return branchOrganizations;
    }

    @Override
    public BranchOrganization findById(Long id) {
        return branchOrgRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reader not found"));
    }

    @Override
    public BranchOrganization updateBranchOrg(Long id, BranchOrganization branchOrganization) {
        BranchOrganization brOrgOld = findById(id);
        if (brOrgOld != null) {
            brOrgOld.setNameOrganization(branchOrganization.getNameOrganization());
            brOrgOld.setPostalAddress(branchOrganization.getPostalAddress());
            brOrgOld.setHeadOrganization(branchOrganization.getHeadOrganization());
            branchOrgRepository.save(brOrgOld);
        }
        return brOrgOld;
    }

    @Override
    public void deleteById(Long id) {
        branchOrgRepository.deleteById(id);
    }

    @Override
    public BranchOrganization assignHeadOrganization(Long id, Long headOrganizationId) {
        BranchOrganization branchOrganization = findById(id);
        HeadOrganization headOrganization = headOrgService.findById(headOrganizationId);
        branchOrganization.setHeadOrganization(headOrganization);
        branchOrgRepository.save(branchOrganization);
        return branchOrganization;
    }

    @Override
    public BranchOrganization createBranchOrg(BranchOrganization branchOrganization) {
        return branchOrgRepository.save(branchOrganization);
    }
}
