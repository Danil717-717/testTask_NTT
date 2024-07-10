package ru.aoNTT.testTask_NTT.restController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.aoNTT.testTask_NTT.models.entity.BranchOrganization;
import ru.aoNTT.testTask_NTT.models.entity.GenDir;
import ru.aoNTT.testTask_NTT.models.entity.HeadOrganization;
import ru.aoNTT.testTask_NTT.models.entity.Organization;
import ru.aoNTT.testTask_NTT.service.BranchOrgService;
import ru.aoNTT.testTask_NTT.service.GenDirService;
import ru.aoNTT.testTask_NTT.service.HeadOrgService;
import ru.aoNTT.testTask_NTT.service.OrganizationService;

import java.util.List;

/**
 * Rest controller
 *
 * @author Строев Д.В.
 * @version 1.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RestControllerOrganization {

    private final BranchOrgService branchOrgService;

    private final GenDirService genDirService;

    private final HeadOrgService headOrgService;

    private final OrganizationService organizationService;


    /**
     * Method for displaying a list of all organizations
     *
     * @return list of organizations
     */
    @GetMapping("/organization")
    public List<Organization> getAllOrganization() {
        return organizationService.findAll();
    }

    /**
     * The method displays all organizations by key
     *
     * @param query key
     * @return all organizations by key
     */
    @GetMapping("/organization/search")
    public List<Organization> searchOrganization(@RequestParam("query") String query) {
        return organizationService.searchOrg(query);
    }

    /**
     * The method displays organizations by id
     *
     * @param id organization id
     * @return organization
     */
    @GetMapping("/organization/{id}")
    public Organization getOrganizationById(@PathVariable Long id) {
        return organizationService.findById(id);
    }

    /**
     * Method creates an organization
     *
     * @param organization organization
     * @return organization
     */
    @PostMapping("/organization")
    public Organization createOrg(@RequestBody Organization organization) {
        return organizationService.createOrg(organization);
    }

    /**
     * Method deletes organization
     *
     * @param id organization id
     */
    @DeleteMapping("/organization/{id}")
    public void deleteOrganization(@PathVariable Long id) {
        organizationService.deleteById(id);
    }

    /**
     * Method adds a CEO to the organization
     *
     * @param id        organization id
     * @param headorgId id of the CEO
     * @return organization
     */
    @PostMapping("/organization/{id}/gendir/{gendirId}")
    public Organization addGenDir(@PathVariable Long id, @PathVariable Long headorgId) {
        return organizationService.assignGenDir(id, headorgId);
    }

    /**
     * The method displays all branches of the organization
     *
     * @return list of organizations
     */
    @GetMapping("/branchorg")
    public List<BranchOrganization> getAllBranchOrg() {
        return branchOrgService.findAll();
    }

    /**
     * The method displays all branches of organizations by key
     *
     * @param query key
     * @return list of organization branches
     */
    @GetMapping("/branchorg/search")
    public List<BranchOrganization> searchBranchOrg(@RequestParam("query") String query) {
        return branchOrgService.searchBranchOrg(query);
    }

    /**
     * The method displays the organization's branch by id
     *
     * @param id organization branch id
     * @return branch of the organization
     */
    @GetMapping("/branchorg/{id}")
    public BranchOrganization getBranchOrganizationById(@PathVariable Long id) {
        return branchOrgService.findById(id);
    }

    /**
     * Method creates a branch of the organization
     *
     * @param branchOrganization branch of the organization
     * @return branch of the organization
     */
    @PostMapping("/branchorg")
    public BranchOrganization createOrg(@RequestBody BranchOrganization branchOrganization) {
        return branchOrgService.createBranchOrg(branchOrganization);
    }

    /**
     * Method deletes a branch of an organization
     *
     * @param id of the organization's branch
     */
    @DeleteMapping("/branchorg/{id}")
    public void deleteBranchOrganization(@PathVariable Long id) {
        branchOrgService.deleteById(id);
    }

    /**
     * The method adds a manager to a branch of the organization
     *
     * @param id        of the organization's branch
     * @param idheadorg of the head
     * @return branch of the organization
     */
    @PostMapping("/branchorg/{id}/headorg/{idheadorg}")
    public BranchOrganization addHeadOrg(@PathVariable Long id, @PathVariable Long idheadorg) {
        return branchOrgService.assignHeadOrganization(id, idheadorg);
    }

    /**
     * The method displays a list of general directors
     *
     * @return list of CEOs
     */
    @GetMapping("/gendir")
    public List<GenDir> getAllGenDir() {
        return genDirService.findAll();
    }

    /**
     * The method displays a list of general directors by key
     *
     * @param query key
     * @return list of CEOs
     */
    @GetMapping("/gendir/search")
    public List<GenDir> searchGenDir(@RequestParam("query") String query) {
        return genDirService.searchGenDir(query);
    }

    /**
     * The method displays the CEO by id
     *
     * @param id id of the CEO
     * @return CEO
     */
    @GetMapping("/gendir/{id}")
    public GenDir getGenDirById(@PathVariable Long id) {
        return genDirService.findById(id);
    }

    /**
     * Method for creating a CEO
     *
     * @param genDir CEO
     * @return CEO
     */
    @PostMapping("/gendir")
    public GenDir createGenDir(@RequestBody GenDir genDir) {
        return genDirService.createGenDir(genDir);
    }

    /**
     * Method deletes of the CEO
     *
     * @param id id of the CEO
     */
    @DeleteMapping("/gendir/{id}")
    public void deleteGenDir(@PathVariable Long id) {
        genDirService.deleteById(id);
    }

    /**
     * The method displays a list of heads of the organization
     *
     * @return list of heads of the organization
     */
    @GetMapping("/headorg")
    public List<HeadOrganization> getAllHeadOrganization() {
        return headOrgService.findAll();
    }

    /**
     * The method displays a list of heads of the organization by key
     *
     * @param query key
     * @return list of heads of the organization
     */
    @GetMapping("/headorg/search")
    public List<HeadOrganization> searchHeadOrganization(@RequestParam("query") String query) {
        return headOrgService.searchHeadOrganization(query);
    }

    /**
     * The method displays the head of the organization by id
     *
     * @param id of the head of the organization
     * @return of the head of the organization
     */
    @GetMapping("/headorg/{id}")
    public HeadOrganization getHeadOrganizationById(@PathVariable Long id) {
        return headOrgService.findById(id);
    }

    /**
     * Method for creating a head organization
     *
     * @param headOrganization head organization
     * @return head organization
     */
    @PostMapping("/headorg")
    public HeadOrganization createHeadOrganization(@RequestBody HeadOrganization headOrganization) {
        return headOrgService.createHeadOrganization(headOrganization);
    }

    /**
     * Method deletes of the head organization
     *
     * @param id id of the head organization
     */
    @DeleteMapping("/headorg/{id}")
    public void deleteHeadOrganization(@PathVariable Long id) {
        headOrgService.deleteById(id);
    }
}
