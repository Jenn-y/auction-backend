CREATE EXTENSION IF NOT EXISTS pgcrypto;

BEGIN
  CREATE TABLE IF NOT EXISTS user_account (
    id UUID DEFAULT gen_random_uuid () PRIMARY KEY,
    first_name text,
    last_name text,
    username text,
    email text NOT NULL,
    password text NOT NULL,
    created_at timestamp,
    updated_at timestamp,
    role text,
    CONSTRAINT email_unique UNIQUE (email)
  );
COMMIT;
