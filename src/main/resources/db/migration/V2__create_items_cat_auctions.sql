CREATE TABLE IF NOT EXISTS "categories" (
  "uuid" UUID DEFAULT gen_random_uuid () PRIMARY KEY,
  "name" varchar(20) NOT NULL,
  "subcategory" UUID,
  CONSTRAINT fk_subcategory
      FOREIGN KEY(subcategory) 
	  REFERENCES categories(uuid)
);

CREATE TABLE IF NOT EXISTS "items" (
  "uuid" UUID DEFAULT gen_random_uuid () PRIMARY KEY,
  "item_number" varchar(20) NOT NULL,
  "name" varchar(50) NOT NULL,
  "start_price" decimal,
  "color" varchar(30),
  "size" numeric,
  "description" varchar(255)
);

CREATE TABLE IF NOT EXISTS "auctions" (
  "uuid" UUID DEFAULT gen_random_uuid () PRIMARY KEY,
  "start_date" timestamp,
  "end_date" timestamp,
  "highest_bid" decimal,
  "adress" varchar(50),
  "zip_code" numeric,
  "phone" varchar(50),
  "status" varchar(255),
  "shipping_cost_included" varchar(255),
  "item" UUID,
  "seller" UUID,
  "category" UUID,
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
