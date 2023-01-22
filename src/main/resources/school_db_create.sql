DROP DATABASE IF EXISTS school_db;

CREATE DATABASE school_db
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_Israel.1251'
    LC_CTYPE = 'English_Israel.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;