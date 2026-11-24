-- creator_id must reference an existing user in app_users.
-- assignee_id must also reference an existing user, but can be NULL when a ticket hasn't been assigned.
-- REFERENCES app_users(id) establishes the relationship between the tables.

ALTER TABLE tickets
    ADD CONSTRAINT fk_tickets_creator
        FOREIGN KEY (creator_id)
            REFERENCES app_users(id);

ALTER TABLE tickets
    ADD CONSTRAINT fk_tickets_assignee
        FOREIGN KEY (assignee_id)
            REFERENCES app_users(id);