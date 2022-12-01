package com.services.restservice.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.services.restservice.models.Infrastructure;
import com.services.restservice.services.InfrastructureServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/university-infrastructure-api-rest")
public class InfrastructureController {

    private InfrastructureServiceImpl infrastructureServiceImpl;

    /**
     * End point for getting all data about infrastructure
     * 
     * @return List<Infrastructure> : returned data type
     * 
     */
    @GetMapping()
    public ResponseEntity<List<Infrastructure>> getAll() {
        List<Infrastructure> ListInfrastructure = infrastructureServiceImpl.getAll();
        return new ResponseEntity<>(ListInfrastructure, HttpStatus.ACCEPTED);
    }

    /**
     * this function is for recovering/getting a single infrastructure from the
     * database
     * 
     * @param id : pathvariable getting from the url of the client
     * @return a single object of infrastructure which match the given id
     * 
     */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Infrastructure>> getById(@PathVariable Long id) {
        Optional<Infrastructure> infrastructure = infrastructureServiceImpl.getInfrastructureById(id);

        if (infrastructure.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(infrastructure, HttpStatus.ACCEPTED);
        }
    }

    /**
     * 
     * this function is from adding/storing new infrastructure in the database
     * 
     * @param infrastructure new infrastructure to add.store in the database
     * @return a single infrastructure which is the new added infrastructure in the
     *         database
     * 
     * 
     */
    @PostMapping("/add")
    public ResponseEntity<Infrastructure> create(@RequestBody Infrastructure infrastructure) {
        Infrastructure request = infrastructureServiceImpl.create(infrastructure);
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

    /**
     * update data in the database
     * 
     * @param id             the id of a storing data
     * @param infrastructure the new information about infrastructure use to update
     *                       it.
     * @return the new updated infrastructure
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Infrastructure> update(@PathVariable Long id, @RequestBody Infrastructure infrastructure) {
        Infrastructure request = infrastructureServiceImpl.update(id, infrastructure);
        if (request == null) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        } else {
            return new ResponseEntity<>(request, HttpStatus.OK);
        }
    }

    /**
     * Delete data storing in the database
     * 
     * @param id the id of the infrastructure to be deleted
     * @return the deleted infrastructure information
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Infrastructure> delete(@PathVariable Long id) {
        Infrastructure request = infrastructureServiceImpl.delete(id);
        if (request == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(request, HttpStatus.OK);
        }
    }

}
