package com.rizaldi.cassandra.web.crud.model;

import com.datastax.driver.core.DataType;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Table("indonesia")
public class Region {
    @PrimaryKey
    @CassandraType(type = DataType.Name.BIGINT)
    private long code;
    @CassandraType(type = DataType.Name.BIGINT)
    private long parent_code;
    @CassandraType(type = DataType.Name.ASCII)
    private String name;
}
