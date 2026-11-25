-- Transfer ownership of existing application tables
ALTER TABLE public.app_users OWNER TO ticket_migrator;

ALTER TABLE public.tickets OWNER TO ticket_migrator;

-- Transfer ownership of Flyway's migration history
ALTER TABLE public.flyway_schema_history OWNER TO ticket_migrator;