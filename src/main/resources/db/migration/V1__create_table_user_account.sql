CREATE EXTENSION IF NOT EXISTS pgcrypto;

BEGIN
  CREATE TABLE IF NOT EXISTS user_account (
    id UUID DEFAULT gen_random_uuid () PRIMARY KEY,
    firstName text NOT NULL,
    lastName text NOT NULL,
    username text,
    email text NOT NULL,
    password text NOT NULL,
    createdAt timestamp,
    updatedAt timestamp,
    role text,
    CONSTRAINT email_unique UNIQUE (email)
  );
COMMIT;
