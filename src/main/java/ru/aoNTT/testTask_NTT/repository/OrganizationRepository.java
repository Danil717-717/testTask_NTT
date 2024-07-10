package ru.aoNTT.testTask_NTT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.aoNTT.testTask_NTT.models.entity.Organization;

import java.util.List;
import java.util.Optional;

/**
 * Repository organization
 *
 * @author Строев Д.В.
 * @version 1.0
 */
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    @Query("SELECT o FROM Organization  o WHERE " +
            "o.fullName LIKE CONCAT('%',:query, '%')" +
            "OR o.shortName LIKE CONCAT('%', :query, '%')")
    List<Organization> searchOrganizationsByFullNameOrShortName(String query);

    @Query(value = "SELECT * FROM info_organization o WHERE " +
            "o.fullName LIKE CONCAT('%',:query, '%')" +
            "OR o.shortName LIKE CONCAT('%', :query, '%')", nativeQuery = true)
    List<Organization> searchOrganizationsByFullNameOrShortNamePostgreSQL(String query);
}
