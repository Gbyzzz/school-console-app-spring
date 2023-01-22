package ua.foxminded.pinchuk.javaspring.schoolconsoleappspring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
@Configuration
public class Config {
//    private static final String CREATE_DB = "/school_db_create.sql";
//    private final JdbcTemplate jdbcTemplate;
//
//    public Config(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Bean
//    public DataSource getDataSource() {
//
//        createDatabase();
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/school_db");
//        dataSourceBuilder.username("postgres");
//        dataSourceBuilder.password("postgres");
//        dataSourceBuilder.driverClassName("org.postgresql.Driver");
//        return dataSourceBuilder.build();
//    }
//
//    private void createDatabase() throws ua.foxminded.pinchuk.javaspring.schoolconsoleapp.dao.exception.DAOException {
//        String create = parseFile(CREATE_DB);
//        jdbcTemplate.update(create);
//    }
//
//    private String parseFile(String filename) {
//        StringBuilder sb = new StringBuilder();
//        BufferedReader in = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(filename)));
//        String buff = "";
//        while (true) {
//            try {
//                if (((buff = in.readLine()) == null)) break;
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            sb.append(buff + System.lineSeparator());
//        }
//        return sb.toString();
//    }
}
