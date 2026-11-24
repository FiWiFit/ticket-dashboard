-- UNIQUE prevents two users from registering with the same email address.
-- CHECK restricts a column to specific allowed values.

-- Each email address can belong to only one user
ALTER TABLE app_users
    ADD CONSTRAINT uq_app_users_email
        UNIQUE (email);

-- Users must have a valid role
ALTER TABLE app_users
    ADD CONSTRAINT chk_app_users_role
        CHECK (role IN ('INTERNAL', 'EXTERNAL'));

-- Tickets must have a valid status
ALTER TABLE tickets
    ADD CONSTRAINT chk_tickets_status
        CHECK (status IN ('OPEN', 'IN_PROGRESS', 'CLOSED'));