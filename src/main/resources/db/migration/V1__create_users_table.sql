CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE IF NOT EXISTS "users" (
  "uuid" UUID DEFAULT gen_random_uuid () PRIMARY KEY,
  "first_name" varchar(20),
  "last_name" varchar(20),
  "username" varchar(20),
  "email" varchar(50) NOT NULL,
  "password" varchar(255) NOT NULL,
  "created_at" timestamp,
  "updated_at" timestamp,
  "role" integer
);
