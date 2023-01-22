package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.exception;

public class DAOException extends RuntimeException {
    public DAOException() {
        super();
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Exception e) {
        super(e);
    }

    public DAOException(String message, Exception e) {
        super(message, e);
    }
}