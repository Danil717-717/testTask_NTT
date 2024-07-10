package ru.aoNTT.testTask_NTT.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.aoNTT.testTask_NTT.models.entity.GenDir;

import java.util.List;

/**
 * Repository general director of the organization
 *
 * @author Строев Д.В.
 * @version 1.0
 */
public interface GenDirRepository extends JpaRepository<GenDir, Long> {

    @Query("SELECT o FROM GenDir  o WHERE " +
            "o.lastName LIKE CONCAT('%',:query, '%')" +
            "OR o.firstName LIKE CONCAT('%', :query, '%')" +
            "OR o.surname LIKE CONCAT('%', :query, '%')" +
            "OR o.dateBirth LIKE CONCAT('%', :query, '%')")
    List<GenDir> searchGenDir(String query);
}
