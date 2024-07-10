package ru.aoNTT.testTask_NTT.service.serviceImpl;

import org.springframework.stereotype.Service;
import ru.aoNTT.testTask_NTT.models.entity.GenDir;
import ru.aoNTT.testTask_NTT.repository.GenDirRepository;
import ru.aoNTT.testTask_NTT.service.GenDirService;

import java.util.List;

/**
 * The class implementing the general director entity service
 *
 * @author Строев Д.В.
 * @version 1.0
 */
@Service
public class GenDirServiceImpl implements GenDirService {

    private final GenDirRepository genDirRepository;

    public GenDirServiceImpl(GenDirRepository genDirRepository) {
        this.genDirRepository = genDirRepository;
    }

    @Override
    public GenDir save(GenDir genDir) {
        return genDirRepository.save(genDir);
    }

    @Override
    public List<GenDir> findAll() {
        return genDirRepository.findAll();
    }

    @Override
    public List<GenDir> searchGenDir(String query) {
        List<GenDir> genDirs =
                genDirRepository.searchGenDir(query);
        return genDirs;
    }

    @Override
    public GenDir findById(Long id) {
        return genDirRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reader not found"));
    }

    @Override
    public GenDir updateGenDir(Long id, GenDir genDir) {
        GenDir genDirOld = findById(id);
        if (genDirOld != null) {
            genDirOld.setLastName(genDir.getLastName());
            genDirOld.setFirstName(genDir.getFirstName());
            genDirOld.setSurname(genDir.getSurname());
            genDirOld.setDateBirth(genDir.getDateBirth());
            genDirRepository.save(genDirOld);
        }
        return genDirOld;
    }

    @Override
    public void deleteById(Long id) {
        genDirRepository.deleteById(id);
    }

    @Override
    public GenDir createGenDir(GenDir genDir) {
        return genDirRepository.save(genDir);
    }
}
