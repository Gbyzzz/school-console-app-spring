FROM postgres:14
EXPOSE 5432
COPY school_db_create.sql /var/lib/postgresql/backup/
ADD restore.sh /docker-entrypoint-initdb.d/