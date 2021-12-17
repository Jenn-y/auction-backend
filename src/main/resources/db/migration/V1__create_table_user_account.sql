CREATE EXTENSION IF NOT EXISTS pgcrypto;

BEGIN;
CREATE TABLE IF NOT EXISTS user_account (
  id UUID DEFAULT gen_random_uuid () PRIMARY KEY,
  first_name text NOT NULL,
  last_name text NOT NULL,
  email text NOT NULL,
  password text NOT NULL,
  phone_num text,
  gender text,
  date_of_birth date,
  created_at timestamp NOT NULL,
  updated_at timestamp NOT NULL,
  role text NOT NULL,
  status text NOT NULL,
  payment_details_id UUID,
  shipping_details_id UUID,
  CONSTRAINT fk_payment_details
      FOREIGN KEY(payment_details_id)
    REFERENCES payment_details(id),
  CONSTRAINT fk_shipping_details
      FOREIGN KEY(shipping_details_id)
    REFERENCES shipping_details(id),
  CONSTRAINT email_unique UNIQUE (email)
);
COMMIT;
