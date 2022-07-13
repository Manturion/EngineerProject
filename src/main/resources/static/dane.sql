--Przykladowe dane dla tabeli city
insert into city (name)
values ('Warszawa');

--Przykladowe dane dla tabeli address
insert into public.address (street_name, street_number, flat_number, zip_code, city_id)
values ('Warszawska', 10, 1, 26 - 800, 1);

--Przykladowe dane dla tabeli shop
insert into shop (name, address_id)
values ('Tesco', 1);

--Przykladowe dane dla tabeli category
insert into public.category (name)
values ('jedzenie');

--Przykladowe dane dla tabeli status
insert into public.status (name)
values ('aktywna');

--Przykladowe dane dla tabeli role
insert into role (name)
values ('admin');

--Przykladowe dane dla tabeli customer
insert into customer (email, name, password, salt, phone_number, respect, is_banned, offer_counter, token, role_id)
values ('jakub.m@gmail.com', 'jakub', '123456', 'lfmsafagsf', '777666555', 1, false, 1, 'shasfjalsgf', 1);

--Przykladowe dane dla tabeli customer_shop
insert into customer_shop (customer_id, shop_id)
values (1, 1);

--Przykladowe dane dla tabeli offer
insert into offer (title, description, image, old_price, new_prize, gps, start_date, expire_date, is_available,
                   created_by, status_id, category_id)
values ('pizzunia', 'wloska pizzunia', 'image nie wiem', 18.20, 32.80, 59223.29, '2021-01-01 00:00:01',
        '2022-01-01 00:00:01', true, 1, 1, 1);

--Przykladowe dane dla tabeli banned_customer
insert into banned_customer (ban_date, expire_date, reason, banned_by, customer_id)
values ('1970-01-01 00:00:01', '1971-01-01 00:00:01', 'dlaczego nie', 1, 1);

--Przykladowe dane dla tabeli report
insert into report (description, "date", offer_id, customer_id)
values ('oferta sie skonczyla', '2022-01-01 00:00:01', 1, 1);

--Przykladowe dane dla tabeli offer_customer
insert into offer_customer (grade, customer_id, offer_id)
values (1, 1, 1);



