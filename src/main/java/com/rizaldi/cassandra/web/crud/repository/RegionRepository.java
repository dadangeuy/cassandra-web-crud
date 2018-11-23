package com.rizaldi.cassandra.web.crud.repository;

import com.rizaldi.cassandra.web.crud.model.Region;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends CassandraRepository<Region, Long> {
    Slice<Region> findByNameContains(String name, Pageable page);
}
