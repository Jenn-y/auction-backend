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
  start_price decimal,
  color text,
  size numeric,
  description text NOT NULL
);

CREATE TABLE IF NOT EXISTS auction (
  id UUID DEFAULT gen_random_uuid () PRIMARY KEY,
  start_date timestamp,
  end_date timestamp,
  highest_bid decimal,
  address text,
  zip_code numeric,
  phone text,
  status text,
  shipping_cost_included text,
  item_id UUID,
  seller_id UUID,
  category_id UUID,
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
