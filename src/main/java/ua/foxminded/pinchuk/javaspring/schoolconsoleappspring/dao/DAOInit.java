package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.dao;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.exception.DAOException;

public interface DAOInit {
    void initDatabase() throws DAOException;
}
