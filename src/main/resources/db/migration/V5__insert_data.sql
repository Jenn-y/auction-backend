BEGIN;

insert into user_account(id, email, first_name, last_name, password, role, status, phone_num, date_of_birth, gender, created_at, updated_at, payment_details_id, shipping_details_id)
values('dee2b360-efee-48cf-bcd8-27bb38b32047', 'austin@gmail.com', 'Jane', 'Austin', crypt('123456', gen_salt('md5')), 'USER', 'ACTIVE', '555-555-555', current_timestamp, 'FEMALE', current_timestamp, current_timestamp, null, null);

insert into category(id, name, subcategory_of)
values('e8eebc89-9c0b-4ef8-ba6d-6bb9bd380a17', 'Paintings', null);

insert into item(id, name, color, description, size)
values('e8eebc89-9a0b-4ef9-ba6d-6bb9bd380a16', 'Mona Lisa', 'brown', 'Mona Lisa (also known as La Gioconda or La Joconde) is a 16th-century portrait painted in oil by Leonardo da Vinci during the Renaissance in Florence, Italy.', 20);

insert into category(id, name, subcategory_of)
values('e8eebc99-9c0b-4ef8-ba6d-6bb9bd388a15', 'Acrylic', 'e8eebc89-9c0b-4ef8-ba6d-6bb9bd380a17');

insert into auction(id, start_date, end_date, status, start_price, category_id, item_id, seller_id)
values('e8eebc89-9c0b-4ef8-ba6d-7bb9bd380a16', current_timestamp, current_date + interval '30 days', 'active', 200, 'e8eebc89-9c0b-4ef8-ba6d-6bb9bd380a17', 'e8eebc89-9a0b-4ef9-ba6d-6bb9bd380a16', 'dee2b360-efee-48cf-bcd8-27bb38b32047');
COMMIT;
