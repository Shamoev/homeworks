package edu.sourceit.homeworks.homework16.jdbc.dao;

import edu.sourceit.homeworks.homework16.jdbc.model.BaseEntity;

import java.io.Serializable;

public interface GenericDao<T extends BaseEntity, PK extends Serializable> {
    PK create(T objectToCreate);

    T read(PK id);

    void update(T objectToUpdate);

    void delete(T objectToDelete);
}
