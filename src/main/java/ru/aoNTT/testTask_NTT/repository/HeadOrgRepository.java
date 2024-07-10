package ru.aoNTT.testTask_NTT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.aoNTT.testTask_NTT.models.entity.HeadOrganization;

import java.util.List;

/**
 * Repository Head of the organization
 *
 * @author Строев Д.В.
 * @version 1.0
 */
public interface HeadOrgRepository extends JpaRepository<HeadOrganization, Long> {

    @Query("SELECT h FROM HeadOrganization h WHERE " +
            "h.lastName LIKE CONCAT('%',:query, '%')" +
            "OR h.firstName LIKE CONCAT('%', :query, '%')" +
            "OR h.surname LIKE CONCAT('%', :query, '%')" +
            "OR h.dateBirth LIKE CONCAT('%', :query, '%')")
    List<HeadOrganization> searchHeadOrganization(String query);
}
