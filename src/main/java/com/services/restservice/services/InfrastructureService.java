package com.services.restservice.services;

import java.util.List;
import java.util.Optional;

import com.services.restservice.models.Infrastructure;

public interface InfrastructureService {
    Infrastructure create(Infrastructure infrastructure); // creating/adding data in the database

    List<Infrastructure> getAll(); // geting all data store in the database

    Optional<Infrastructure> getInfrastructureById(Long id); // getting a single database which match the given data

    Infrastructure update(Long id, Infrastructure infrastructure); // update data in the database

    Infrastructure delete(Long id); // delete data from the database
}
