-- Flyway migration role
CREATE ROLE ticket_migrator
    WITH LOGIN
    NOSUPERUSER
    NOCREATEDB
    NOCREATEROLE
    NOBYPASSRLS;

-- Application runtime role
CREATE ROLE ticket_app
    WITH LOGIN
    NOSUPERUSER
    NOCREATEDB
    NOCREATEROLE
    NOBYPASSRLS;

-- Database access
GRANT CONNECT ON DATABASE ticket_dashboard
    TO ticket_migrator, ticket_app;

-- Prevent inherited schema creation privileges from PUBLIC
REVOKE CREATE ON SCHEMA public FROM PUBLIC;

-- Migration schema privileges
GRANT USAGE, CREATE ON SCHEMA public
    TO ticket_migrator;

-- Runtime schema privileges
GRANT USAGE ON SCHEMA public
    TO ticket_app;