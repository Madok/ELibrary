package com.zpo.elibrary.db.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Service;

import com.datastax.driver.core.querybuilder.QueryBuilder;

@Service("CassandraTemplate")
public class CassandraTemplate {

    @Autowired
    private CassandraOperations cassandraTemplate;

    public <T> T create(final T entity) {
        return cassandraTemplate.insert(entity);
    }

    public <T> T update(final T entity) {
        return (T)cassandraTemplate.update(entity);
    }

    public <T> T update(final T entity, final Class<T> claz) {
        return (T)cassandraTemplate.update(entity);
    }

    public <T> T findById(final Object id, final Class<T> claz) {
        return cassandraTemplate.selectOneById(claz, id);
    }

    public <T> void deleteById(final Object id, final Class<T> claz) {
        cassandraTemplate.deleteById(claz, id);
    }

    public void delete(final Object entity) {
        cassandraTemplate.delete(entity);
    }

    public <T> List<T> findAll(final Class<T> clazz) {
        return (List<T>)cassandraTemplate
            .select(QueryBuilder.select().all().from(cassandraTemplate.getTableName(clazz).toCql()), clazz);
    }

    public <T> T findBy(final String columnName, final Object value, final Class<T> clazz) {
        return cassandraTemplate.selectOne(QueryBuilder.select().all().from(cassandraTemplate.getTableName(clazz).toCql())
            .where(QueryBuilder.eq(columnName, value)).limit(1), clazz);
    }

    public <T> List<T> findByIds(final List<Object> ids, final Class<T> claz) {
        return cassandraTemplate.selectBySimpleIds(claz, ids);
    }

    public <T> void truncate(final Class<T> claz) {
        cassandraTemplate.truncate(claz.getName());
    }

    public <T> long getCount(final Class<T> claz) {
        return cassandraTemplate.count(claz);
    }

    public <T> boolean exists(final Object id, final Class<T> claz) {
        return cassandraTemplate.exists(claz, id);
    }

}
