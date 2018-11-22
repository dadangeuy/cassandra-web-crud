package com.rizaldi.cassandra.web.crud.repository;

import com.rizaldi.cassandra.web.crud.model.Region;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends CassandraRepository<Region, String> {
}
