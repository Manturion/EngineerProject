insert into offer (id, title, description, image, old_price, new_price, latitude, longitude, start_date, expire_date,
                   is_available,
                   created_by_customer_id, status_id, category_id)
values (2, 'Filet z piersi kurczaka cena z aplikacją @Stokrotka',
        'Oferta ogólnopolska z najnowszej gazetki Stokrotka ważna w dniach 10-16.11.2022
        Limit na jedną apke= 2kg. ' || 'Cena bez aplikacji = 24,99,-',
        'https://static.pepper.pl/threads/raw/Ua2p6/595813_1/re/1024x1024/qt/60/595813_1.jpg', 24.99, 16.99,
        51.23201087656004, 22.537180040206714, '2022-11-07 00:00:01',
        '2022-11-010 00:00:01', true, 1, 1, 1);

insert into offer (id, title, description, image, old_price, new_price, latitude, longitude, start_date, expire_date,
                   is_available,
                   created_by_customer_id, status_id, category_id)
values (3, 'Ciastka Jeżyki classic lub kokos 140g przy zakupie dwóch sztuk',
        'Promocja 7-9.11 w sklepach sieci Lidl.' || 'Ciastka Jeżyki: dwa smaki, klasyczny i kokosowy. Opakowanie 140g.
Kupując dwa opakowania cena za sztukę 3,19 zł' || '' || 'Promocja bez aplikacji, dla każdego.',
        'https://static.pepper.pl/threads/raw/JBfPz/595450_1/re/1024x1024/qt/60/595450_1.jpg', 4.19, 3.19,
        51.22932429386167, 22.536747678975022, '2021-11-07 00:00:01',
        '2022-11-09 00:00:01', true, 1, 1, 1);


insert into offer (id, title, description, image, old_price, new_price, latitude, longitude, start_date, expire_date,
                   is_available,
                   created_by_customer_id, status_id, category_id)
values (4, 'Lewiatan papryka czerwona 4,99zł/1kg',
        'Lewiatan papryka czerwona 4, 99 znalezione w Chrzanowie',
        'https://static.pepper.pl/threads/raw/rxhfS/595094_1/re/1024x1024/qt/60/595094_1.jpg',
        7.99, 4.99,51.234254026297684, 22.540007238470103, '2021-11-09 00:00:01',
        '2022-11-15 00:00:01', true, 1, 1, 1);
