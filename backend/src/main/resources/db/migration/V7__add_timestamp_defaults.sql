-- updated_at will not automatically change when a ticket is edited

ALTER TABLE app_users
    ALTER COLUMN created_at SET DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE tickets
    ALTER COLUMN created_at SET DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE tickets
    ALTER COLUMN updated_at SET DEFAULT CURRENT_TIMESTAMP;