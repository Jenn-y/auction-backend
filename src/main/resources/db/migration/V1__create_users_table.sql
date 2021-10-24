CREATE TABLE IF NOT EXISTS "users" (

  "uid" integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  "first_name" varchar(20),
  "last_name" varchar(20),
  "username" varchar(20),
  "email" varchar(50) NOT NULL,
  "password" varchar(255) NOT NULL,
  "created_at" timestamp,
  "updated_at" timestamp

);