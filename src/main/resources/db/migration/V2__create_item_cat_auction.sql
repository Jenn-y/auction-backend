BEGIN;
CREATE TABLE IF NOT EXISTS category (
  id UUID DEFAULT gen_random_uuid () PRIMARY KEY,
  name text NOT NULL,
  subcategory UUID,
  CONSTRAINT fk_subcategory
      FOREIGN KEY(subcategory)
    REFERENCES category(id)
);

CREATE TABLE IF NOT EXISTS item (
  id UUID DEFAULT gen_random_uuid () PRIMARY KEY,
  name text NOT NULL,
  color text,
  size numeric,
  description text NOT NULL
);

CREATE TABLE IF NOT EXISTS auction (
  id UUID DEFAULT gen_random_uuid () PRIMARY KEY,
  start_date timestamp NOT NULL,
  end_date timestamp NOT NULL,
  start_price decimal NOT NULL,
  highest_bid decimal,
  address text,
  zip_code numeric,
  phone text,
  status text,
  shipping_cost_included text,
  item_id UUID NOT NULL,
  seller_id UUID NOT NULL,
  category_id UUID NOT NULL,
  CONSTRAINT fk_category
      FOREIGN KEY(category_id)
    REFERENCES category(id),
  CONSTRAINT fk_item
      FOREIGN KEY(item_id)
    REFERENCES item(id),
  CONSTRAINT fk_seller
      FOREIGN KEY(seller_id)
    REFERENCES user_account(id)
);
COMMIT;
