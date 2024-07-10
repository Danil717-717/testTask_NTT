package ru.aoNTT.testTask_NTT.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Organization branch entity class with id properties,
 * nameOrganization, postalAddress, headOrganization
 *
 * @author Строев Д.В.
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "info_branchOrg")
public class BranchOrganization {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * name organization
     */
    private String nameOrganization;

    /**
     * postal address
     */
    private String postalAddress;

    /**
     * head organization
     */
    @OneToOne
    private HeadOrganization headOrganization;
}
