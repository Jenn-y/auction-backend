BEGIN;
CREATE TABLE IF NOT EXISTS bid (
  id UUID DEFAULT gen_random_uuid () PRIMARY KEY,
  buyer_id UUID,
  auction_id UUID,
  bid_amount decimal,
  CONSTRAINT fk_buyer
      FOREIGN KEY(buyer_id) 
	  REFERENCES user_account(id),
  CONSTRAINT fk_auction
      FOREIGN KEY(auction_id) 
	  REFERENCES auction(id)
);
COMMIT;
