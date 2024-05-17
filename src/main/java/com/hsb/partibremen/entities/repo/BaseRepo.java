package com.hsb.partibremen.entities.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
interface BaseRepo<T, ID> extends JpaRepository<T, ID> {
    List<T> findByIsDeleted(boolean isDeleted);
}
