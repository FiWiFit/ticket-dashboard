-- User authentication and retrieval
GRANT SELECT ON TABLE public.app_users
    TO ticket_app;

-- Ticket operations
GRANT SELECT, INSERT, UPDATE, DELETE
    ON TABLE public.tickets
    TO ticket_app;