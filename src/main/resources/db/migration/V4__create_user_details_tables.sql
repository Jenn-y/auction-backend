BEGIN;
CREATE TABLE IF NOT EXISTS shipping_details (
  id UUID DEFAULT gen_random_uuid () PRIMARY KEY,
  street_name text,
  city text,
  zip_code numeric,
  state text,
  country text
);

CREATE TABLE IF NOT EXISTS payment_details (
  id UUID DEFAULT gen_random_uuid () PRIMARY KEY,
  paypal boolean,
  card_name text,
  card_number text,
  expiration_date date,
  verification_code text
);
COMMIT;
