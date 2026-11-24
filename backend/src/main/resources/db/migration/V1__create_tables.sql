-- UUID — stores a unique identifier for each user.
-- VARCHAR(255) — stores text up to 255 characters.
-- TIMESTAMP — stores a date and time.

CREATE TABLE app_users (
                           id UUID,
                           email VARCHAR(255),
                           password_hash VARCHAR(255),
                           role VARCHAR(20),
                           created_at TIMESTAMP
);

-- creator_id — identifies the user who submitted the ticket.
-- assignee_id — identifies the internal user handling it, if assigned.
-- TEXT — allows descriptions of variable length without a fixed character limit.
-- status — will eventually hold values such as OPEN, IN_PROGRESS or CLOSED.

CREATE TABLE tickets (
                         id UUID,
                         creator_id UUID,
                         assignee_id UUID,
                         title VARCHAR(255),
                         description TEXT,
                         status VARCHAR(20),
                         created_at TIMESTAMP,
                         updated_at TIMESTAMP
);

