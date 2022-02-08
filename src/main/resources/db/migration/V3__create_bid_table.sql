BEGIN;
CREATE TABLE IF NOT EXISTS bid (
  id UUID DEFAULT gen_random_uuid () PRIMARY KEY,
  bidder_id UUID NOT NULL,
  auction_id UUID NOT NULL,
  bid_amount decimal NOT NULL,
  bid_date timestamp WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
  CONSTRAINT fk_bidder
      FOREIGN KEY(bidder_id) 
	  REFERENCES user_account(id),
  CONSTRAINT fk_auction
      FOREIGN KEY(auction_id) 
	  REFERENCES auction(id)
);
COMMIT;
