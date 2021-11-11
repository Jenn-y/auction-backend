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
  startPrice decimal,
  color text,
  size numeric,
  description text NOT NULL
);

CREATE TABLE IF NOT EXISTS auction (
  id UUID DEFAULT gen_random_uuid () PRIMARY KEY,
  startDate timestamp,
  endDate timestamp,
  highestBid decimal,
  address text,
  zipCode numeric,
  phone text,
  status text,
  shippingCostIncluded text,
  item UUID,
  seller UUID,
  category UUID,
  CONSTRAINT fk_category
      FOREIGN KEY(category) 
	  REFERENCES categories(uuid),
  CONSTRAINT fk_item
      FOREIGN KEY(item) 
	  REFERENCES items(uuid),
  CONSTRAINT fk_seller
      FOREIGN KEY(seller) 
	  REFERENCES users(uuid)
);
COMMIT;
