BEGIN;
CREATE TABLE IF NOT EXISTS payment (
  id UUID DEFAULT gen_random_uuid () PRIMARY KEY,
  buyer_id UUID NOT NULL,
  auction_id UUID NOT NULL,
  amount decimal NOT NULL,
  payment_method text NOT NULL,
  date timestamp WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
  CONSTRAINT fk_buyer
      FOREIGN KEY(buyer_id) 
	  REFERENCES user_account(id),
  CONSTRAINT fk_auction
      FOREIGN KEY(auction_id) 
	  REFERENCES auction(id)
);
COMMIT;
