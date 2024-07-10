package ru.aoNTT.testTask_NTT.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity class organization manager with id properties,
 * lastName, firstName, surname, dateBirth
 *
 * @author Строев Д.В.
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "info_headOrg")
public class HeadOrganization {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * last name
     */
    private String lastName;

    /**
     * first name
     */
    private String firstName;

    /**
     * surname
     */
    private String surname;

    /**
     * date of birth
     */
    private String dateBirth;
}