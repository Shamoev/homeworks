package edu.sourceit.homeworks.homework16.jdbc.exceptions;

public class GenericDaoException extends RuntimeException {
    public GenericDaoException(String reason) {
        super(reason);
    }

    public GenericDaoException(String reason, Exception e) {
        super(reason, e);
    }
}
