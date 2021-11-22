BEGIN;
CREATE TABLE IF NOT EXISTS category (
  id UUID DEFAULT gen_random_uuid () PRIMARY KEY,
  name text NOT NULL,
  subcategory_of UUID,
  CONSTRAINT fk_subcategory_of
      FOREIGN KEY(subcategory_of)
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
