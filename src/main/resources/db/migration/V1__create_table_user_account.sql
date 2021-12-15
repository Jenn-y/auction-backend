CREATE EXTENSION IF NOT EXISTS pgcrypto;

BEGIN;
CREATE TABLE IF NOT EXISTS user_account (
  id UUID DEFAULT gen_random_uuid () PRIMARY KEY,
  first_name text NOT NULL,
  last_name text NOT NULL,
  email text NOT NULL,
  password text NOT NULL,
  created_at timestamp NOT NULL,
  updated_at timestamp NOT NULL,
  role text NOT NULL,
  status text,
  CONSTRAINT email_unique UNIQUE (email)
);
COMMIT;
