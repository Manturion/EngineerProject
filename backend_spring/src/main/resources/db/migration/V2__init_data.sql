--Przykladowe dane dla tabeli city
insert into city (id,name)
values (1,'Warszawa');

--Przykladowe dane dla tabeli address
insert into address (id,street_name, street_number, flat_number, zip_code, city_id)
values (1,'Warszawska', 10, 1, '26-800', 1);

--Przykladowe dane dla tabeli shop
insert into shop (id,name, address_id)
values (1,'Tesco', 1);

--Przykladowe dane dla tabeli category
insert into category (id,name)
values (1,'jedzenie');

--Przykladowe dane dla tabeli status
insert into status (id,name)
values (1,'aktywna');

--Przykladowe dane dla tabeli role
insert into role (id,name)
values (1,'admin');

--Przykladowe dane dla tabeli customer
insert into customer (id,email, name, password, salt, phone_number, respect, is_banned, offer_counter, token, role_id)
values (1,'jakub.m@gmail.com', 'jakub', '123456', 'lfmsafagsf', '777666555', 1, false, 1, 'shasfjalsgf', 1);

--Przykladowe dane dla tabeli customer_shop
insert into customer_shop (customer_id, shop_id)
values (1, 1);

--Przykladowe dane dla tabeli offer
insert into offer (id,title, description, image, old_price, new_price, gps, start_date, expire_date, is_available,
                   created_by_customer_id, status_id, category_id)
values (1,'eGift card to spend on pizza making', 'From fresh dough bases, tomato sauce, cheese, ham and even pineapple chunks (go on, we won’t judge), you can make the pizza of your dreams in the comfort of your own home.

Grab your Morrisons eGift Card today.

What you need to know

Free £5 Morrisons eGift Card to spend on pizza-making essentials', 'https://images.hotukdeals.com/threads/raw/8I41h/4014506_1/re/1024x1024/qt/60/4014506_1.jpg', 18.20, 32.80, 5923.56, '2021-01-01 00:00:01',
        '2022-01-01 00:00:01', true, 1, 1, 1);

--Przykladowe dane dla tabeli banned_customer
insert into banned_customer (id,ban_date, expire_date, reason, banned_by, customer_id)
values (1,'1970-01-01 00:00:01', '1971-01-01 00:00:01', 'dlaczego nie', 1, 1);

--Przykladowe dane dla tabeli report
insert into report (id,description, "date", offer_id, customer_id)
values (1,'oferta sie skonczyla', '2022-01-01 00:00:01', 1, 1);

--Przykladowe dane dla tabeli offer_customer
insert into offer_customer (grade, customer_id, offer_id)
values (1, 1, 1);