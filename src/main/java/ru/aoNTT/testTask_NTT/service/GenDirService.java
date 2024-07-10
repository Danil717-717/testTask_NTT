package ru.aoNTT.testTask_NTT.service;

import ru.aoNTT.testTask_NTT.models.entity.GenDir;

import java.util.List;

/**
 * CEO entity service interface
 *
 * @author Строев Д.В.
 * @version 1.0
 */
public interface GenDirService {

    /**
     * CEO Entity Preservation Method
     *
     * @param genDir entity CEO
     * @return entity CEO
     */
    GenDir save(GenDir genDir);

    /**
     * Method returning all CEO entities
     *
     * @return list of CEO entities
     */
    List<GenDir> findAll();

    /**
     * Method returning all entities CEO by keyword
     *
     * @param query query keyword
     * @return entities CEO by keyword
     */
    List<GenDir> searchGenDir(String query);

    /**
     * Method returning the CEO entity by id
     *
     * @param id entity id CEO
     * @return entity CEO
     */
    GenDir findById(Long id);

    /**
     * CEO entity update method
     *
     * @param id id of the CEO entity
     * @param genDir CEO
     * @return the updated CEO entity
     */
    GenDir updateGenDir(Long id, GenDir genDir);

    /**
     * Method for removing the CEO entity
     * @param id id of the CEO entity
     */
    void deleteById(Long id);

    /**
     * CEO entity creation method
     *
     * @param genDir entity CEO
     * @return entity CEO
     */
    GenDir createGenDir(GenDir genDir);
}
