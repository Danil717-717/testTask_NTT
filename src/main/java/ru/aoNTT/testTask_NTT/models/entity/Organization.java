package ru.aoNTT.testTask_NTT.models.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Organization entity class with id properties,
 * fullName, shortName, TIN, OGRN, postalAddress,
 * legalAddress, genDir, branchOrganizations
 *
 * @author Строев Д.В.
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "info_organization")
public class Organization {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * full name
     */
    private String fullName;

    /**
     * short name
     */
    private String shortName;

    /**
     * TIN
     */
    private int tin;

    /**
     * OGRN
     */
    private int ogrn;

    /**
     * postal address
     */
    private String postalAddress;

    /**
     * legal address
     */
    private String legalAddress;

    /**
     * general director of the organization
     */
    @OneToOne
    private GenDir genDir;

    /**
     * branch of the organization
     */
    @OneToMany
    private List<BranchOrganization> branchOrganizations = new ArrayList<>();

}
