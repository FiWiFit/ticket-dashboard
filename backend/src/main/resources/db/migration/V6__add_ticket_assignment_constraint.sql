ALTER TABLE tickets
    ADD CONSTRAINT chk_tickets_assignment
        CHECK (
            (status = 'OPEN' AND assignee_id IS NULL)
                OR
            (status IN ('IN_PROGRESS', 'CLOSED') AND assignee_id IS NOT NULL)
            );