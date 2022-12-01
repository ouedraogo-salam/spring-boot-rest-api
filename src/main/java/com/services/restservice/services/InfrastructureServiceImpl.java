package com.services.restservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.services.restservice.models.Infrastructure;
import com.services.restservice.repositories.InfrastructureDao;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InfrastructureServiceImpl implements InfrastructureService {

    private final InfrastructureDao infrastructureDao;

    @Override
    public Infrastructure create(Infrastructure infrastructure) {
        return infrastructureDao.save(infrastructure);
    }

    @Override
    public List<Infrastructure> getAll() {
        return infrastructureDao.findAll();
    }

    @Override
    public Optional<Infrastructure> getInfrastructureById(Long id) {
        return infrastructureDao.findById(id);
    }

    @Override
    public Infrastructure update(Long id, Infrastructure infrastructure) {
        Optional<Infrastructure> request = infrastructureDao.findById(id);

        // if the no content the function return null otherwise
        // update and return the updated data
        if (request.isEmpty()) {
            return null;
        } else {
            Infrastructure new_infrastructure = request.get();
            new_infrastructure.setCapacite(infrastructure.getCapacite());
            new_infrastructure.setDisponibilite(infrastructure.getDisponibilite());
            new_infrastructure.setLocalisation(infrastructure.getLocalisation());
            new_infrastructure.setType(infrastructure.getType());
            return infrastructureDao.save(new_infrastructure);
        }

    }

    @Override
    public Infrastructure delete(Long id) {
        Optional<Infrastructure> infrastructure = infrastructureDao.findById(id);
        // return null if no data match the given id otherwise
        // delete the data and return it.
        if (infrastructure.isEmpty()) {
            return null;
        } else {
            infrastructureDao.deleteById(id);
            return infrastructure.get();
        }

    }

}
