package ru.aoNTT.testTask_NTT.service.serviceImpl;

import org.springframework.stereotype.Service;
import ru.aoNTT.testTask_NTT.models.entity.HeadOrganization;
import ru.aoNTT.testTask_NTT.repository.HeadOrgRepository;
import ru.aoNTT.testTask_NTT.service.HeadOrgService;

import java.util.List;

/**
 * The class implementing the service entity head of the organization
 *
 * @author Строев Д.В.
 * @version 1.0
 */
@Service
public class HeadOrgServiceImpl implements HeadOrgService {

    private final HeadOrgRepository headOrgRepository;

    public HeadOrgServiceImpl(HeadOrgRepository headOrgRepository) {
        this.headOrgRepository = headOrgRepository;
    }

    @Override
    public HeadOrganization save(HeadOrganization headOrganization) {
        return headOrgRepository.save(headOrganization);
    }

    @Override
    public List<HeadOrganization> findAll() {
        return headOrgRepository.findAll();
    }

    @Override
    public List<HeadOrganization> searchHeadOrganization(String query) {
        List<HeadOrganization> headOrganizations =
                headOrgRepository.searchHeadOrganization(query);
        return headOrganizations;
    }

    @Override
    public HeadOrganization findById(Long id) {
        return headOrgRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reader not found"));
    }

    @Override
    public HeadOrganization updateHeadOrg(Long id, HeadOrganization headOrganization) {
        HeadOrganization headOrgOld = findById(id);
        if (headOrgOld != null) {
            headOrgOld.setLastName(headOrganization.getLastName());
            headOrgOld.setFirstName(headOrganization.getFirstName());
            headOrgOld.setSurname(headOrganization.getSurname());
            headOrgOld.setDateBirth(headOrganization.getDateBirth());
            headOrgRepository.save(headOrgOld);
        }
        return headOrgOld;
    }

    @Override
    public void deleteById(Long id) {
        headOrgRepository.deleteById(id);
    }

    @Override
    public HeadOrganization createHeadOrganization(HeadOrganization headOrganization) {
        return headOrgRepository.save(headOrganization);
    }
}
