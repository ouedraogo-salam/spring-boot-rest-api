package com.services.restservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.services.restservice.models.Infrastructure;

public interface InfrastructureDao extends JpaRepository<Infrastructure, Long> {

}
