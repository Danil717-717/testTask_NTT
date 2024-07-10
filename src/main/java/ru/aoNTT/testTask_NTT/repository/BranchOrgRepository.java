package ru.aoNTT.testTask_NTT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.aoNTT.testTask_NTT.models.entity.BranchOrganization;

import java.util.List;

/**
 * Repository branch of the organization
 *
 * @author Строев Д.В.
 * @version 1.0
 */
public interface BranchOrgRepository extends JpaRepository<BranchOrganization, Long> {

    @Query("SELECT b FROM BranchOrganization b WHERE " +
            "b.nameOrganization LIKE CONCAT('%',:query, '%')" +
            "OR b.postalAddress LIKE CONCAT('%', :query, '%')")
    List<BranchOrganization> searchBranchOrganizationsByNameOrAddress(String query);

    @Query(value = "SELECT * FROM info_branchOrg b WHERE " +
            "b.nameOrganization LIKE CONCAT('%', :query, '%')" +
            "OR b.postalAddress LIKE CONCAT('%', :query, '%')", nativeQuery = true)
    List<BranchOrganization> searchBranchOrganizationsByNameOrAddressPostgreSQL(String query);
}
