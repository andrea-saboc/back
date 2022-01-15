INSERT INTO public.system_user(
    user_type, id, address, blocked, city, country, email, name, password, phone_number, surname)
VALUES ('MansionOwner', 5, 'Trg 34', false, 'Paris', 'France', 'ana@gmail.com','Ana', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '78555', 'Grkovic');
INSERT INTO public.mansion_owner(
    type, advertiser_registration_approved, advertiser_reason, id)
VALUES ('mansion', true, 'I am a mansion owner', 5);

INSERT INTO public.system_user(
    user_type, id, address, blocked, city, country, email, name, password, phone_number, surname)
VALUES ('Administrator', '6', 'Tolstojeva 10', false, 'Novi Sad', 'Srbija', 'admin@gmail.com','Adminka', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra','069652256','mirkovic');
INSERT INTO administrator(
    id)
VALUES ('6');

INSERT INTO public.system_user(
    user_type, id, address, blocked, city, country, email, name, password, phone_number, surname)
VALUES ('BoatOwner', 100, 'St Marc 45', false, 'Genova', 'Italy', 'markijan@gmail.com', 'Mark', '$2a$10$KBYOmrL4g3ce5.wfagQnveII0Ubylu0s/1pP/zl2pagffN7uDfAKS', '09787', 'Markijani');
INSERT INTO public.boat_owner(
    type, advertiser_registration_approved, advertiser_reason, id)
VALUES ('boat', true, 'I want to advertise', 100);

INSERT INTO public.system_user(
    user_type, id, address, blocked, city, country, email, name, password, phone_number, surname)
VALUES ('CLIENT', 400, 'Trg 34', false, 'Trebinje', 'Bosnia and Herzegovina', 'littlevamp999@gmail.com','Anja', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '78555', 'Laketa');
INSERT INTO public.client(
    activation_code, client_loyalty_points,client_penalty_points, id)
VALUES ('code', 0, 0, 400);

INSERT INTO public.system_user(
    user_type, id, address, blocked, city, country, email, name, password, phone_number, surname)
VALUES ('CLIENT', 401, 'Trg 34', false, 'Gacko', 'Bosnia and Herzegovina', 'mikymilane@gmail.com','Milan', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '78555', 'Milovic');
INSERT INTO public.client(
    activation_code, client_loyalty_points,client_penalty_points, id)
VALUES ('code', 0, 0, 401);

INSERT INTO public.system_user(
    user_type, id, address, blocked, city, country, email, name, password, phone_number, surname)
VALUES ('CLIENT', 402, 'Trg 34', false, 'Nis', 'Serbia', 'anya@gmail.com','Anica', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '78555', 'Obrenovic');
INSERT INTO public.client(
    activation_code, client_loyalty_points,client_penalty_points, id)
VALUES ('code', 0, 0, 402);

INSERT INTO public.address(
    id, address, city, country, latitude, longitude)
VALUES (3, 'Jovana Jovanovica 23a', 'Novi Sade', 'Srbija', 23.67, 45.88);
INSERT INTO public.address(
    id, address, city, country, latitude, longitude)
VALUES (4, 'Marka Markovica 23a', 'London', 'Engleska', 23.67, 45.88);
INSERT INTO public.address(
    id, address, city, country, latitude, longitude)
VALUES (5, 'Jovana Markovica 23a', 'Beograd', 'Srbija', 23.67, 45.88);
INSERT INTO public.address(
    id, address, city, country, latitude, longitude)
VALUES (6, 'Hercega 23a', 'Herceg Novi', 'Montenegero', 23.67, 45.88);
INSERT INTO public.address(
    id, address, city, country, latitude, longitude)
VALUES (7, 'Hercega 23a', 'Herceg Novi', 'Montenegero', 23.67, 45.88);
INSERT INTO public.address(
    id, address, city, country, latitude, longitude)
VALUES (8, 'Ena 23a', 'Herceg Novi', 'Negero', 23.67, 45.88);
INSERT INTO public.address(
    id, address, city, country, latitude, longitude)
VALUES (9, 'Mila 23a', 'Herceg Novi', 'Montenegero', 23.67, 45.88);
INSERT INTO public.address(
    id, address, city, country, latitude, longitude)
VALUES (10, 'Kila 23a', 'Herceg Novi', 'Montenegero', 23.67, 45.88);
INSERT INTO public.address(
    id, address, city, country, latitude, longitude)
VALUES (11, 'Marokanska 23a', 'Herceg Novi', 'Montenegero', 44.67, 45.88);
INSERT INTO public.address(
    id, address, city, country, latitude, longitude)
VALUES (12, 'Marokanska 23a', 'Moskva', 'Russia', 44.67, 35.88);
INSERT INTO public.address(
    id, address, city, country, latitude, longitude)
VALUES (13, 'Marka Mljanova 30', 'Novi Sad', 'Serbia', 45.25, 19.85);
INSERT INTO public.address(
    id, address, city, country, latitude, longitude)
VALUES (14, 'St Marcus Aurelius 23/788', 'Honolulu', 'Hawaii', 21.31, -157.9);


INSERT INTO public.mansion(
    id, avg_grade, name, price_for_seven_days, price_per_day, promo_description, address_id, owner_id)
VALUES (1, 9, 'Vila Viktorija', 250, 50, 'Najbolji promo',5, 5);
INSERT INTO public.mansion(
    id, avg_grade, name, price_for_seven_days, price_per_day, promo_description, address_id, owner_id)
VALUES (2, 9, 'Vila Sofija', 250, 50, 'Promo..',6, 5);
INSERT INTO public.mansion(
    id, avg_grade, name, price_for_seven_days, price_per_day, promo_description, address_id, owner_id)
VALUES (3, 9, 'Vila Stojanka', 250, 50, 'Najbolji promo',7, 5);
INSERT INTO public.mansion(
    id, avg_grade, name, price_for_seven_days, price_per_day, promo_description, address_id, owner_id)
VALUES (4, 9, 'Vila Viktorija', 250, 50, 'Najbolji promo',8, 5);
INSERT INTO public.mansion(
    id, avg_grade, name, price_for_seven_days, price_per_day, promo_description, address_id, owner_id)
VALUES (6, 9, 'Nije vila', 250, 50, 'Najbolji promo',9, 5);
INSERT INTO public.mansion(
    id, avg_grade, name, price_for_seven_days, price_per_day, promo_description, address_id, owner_id)
VALUES (5, 9, 'Bobanka', 250, 50, 'Najbolji promo',10, 5);
INSERT INTO public.mansion(
    id, avg_grade, name, price_for_seven_days, price_per_day, promo_description, address_id, owner_id)
VALUES (7, 9, 'Nije vila', 250, 50, 'Najbolji promo',11, 5);
INSERT INTO public.mansion(
    id, avg_grade, name, price_for_seven_days, price_per_day, promo_description, address_id, owner_id)
VALUES (8, 9, 'Bobanka', 250, 50, 'Najbolji promo',12, 5);

INSERT INTO public.boat(
    id, gps, vhfradio, avg_grade, cancellation_policy, capacity, engine_power, fishfinder, length, max_speed, name, number_of_engines, price_for_seven_days, price_per_day, price_per_hour, promo_description, radar, type, address_id, owner_id)
VALUES (3, true, true, 10.0, 'You will recieve 100% of total price!', 10, 200, true, 10, 120, 'Milicija', 6, 500, 100, 30, 'Promo description of malicija',true, 'Sail boat', 13, 100);
INSERT INTO public.boat(
    id, gps, vhfradio, avg_grade, cancellation_policy, capacity, engine_power, fishfinder, length, max_speed, name, number_of_engines, price_for_seven_days, price_per_day, price_per_hour, promo_description, radar, type, address_id, owner_id)
VALUES (4, true, true, 10.0, 'You will recieve 70% of total price!', 10, 200, true, 34, 220, 'Malicija', 6, 500, 100, 30, 'Promo description of malicija',true, 'Sail boat', 14, 100);
INSERT INTO public.boat(
    id, gps, vhfradio, avg_grade, cancellation_policy, capacity, engine_power, fishfinder, length, max_speed, name, number_of_engines, price_for_seven_days, price_per_day, price_per_hour, promo_description, radar, type, address_id, owner_id)
VALUES (5, true, true, 10.0, 'You will recieve 70% of total price!', 10, 200, true, 34, 220, 'Catamaran', 6, 500, 100, 30, 'This is the best boat',false, 'Yacht', 10, 100);
INSERT INTO public.boat(
    id, gps, vhfradio, avg_grade, cancellation_policy, capacity, engine_power, fishfinder, length, max_speed, name, number_of_engines, price_for_seven_days, price_per_day, price_per_hour, promo_description, radar, type, address_id, owner_id)
VALUES (6, false, true, 10.0, 'You will recieve 85% of total price!', 15, 200, true, 34, 220, 'BENETEAU', 6, 700, 250, 70, 'This is the best boat',true, 'Sailboat', 9, 100);

INSERT INTO public.additional_service(
    id, name, price_per_day, price_per_hour, boat_id, mansion_id)
VALUES (1, 'wifi', 30, 12, 3, null );
INSERT INTO public.additional_service(
    id, name, price_per_day, price_per_hour, boat_id, mansion_id)
VALUES (2, 'captain', 50, 100, 3, null );
INSERT INTO public.additional_service(
    id, name, price_per_day, price_per_hour, boat_id, mansion_id)
VALUES (3, 'champagne', 12, 36, 4, null );
INSERT INTO public.additional_service(
    id, name, price_per_day, price_per_hour, boat_id, mansion_id)
VALUES (4, 'bathroom', 12, 36, 4, null );

INSERT INTO public.boat_available_period(
    available_period_id, end_date, start_date, boat_id)
VALUES (1, '2022-03-10 00:00:00', '2022-01-01 00:00:00', 3);
INSERT INTO public.boat_available_period(
    available_period_id, end_date, start_date, boat_id)
VALUES (2, '2022-03-28 00:00:00', '2022-03-20 00:00:00', 3);
INSERT INTO public.boat_available_period(
    available_period_id, end_date, start_date, boat_id)
VALUES (3, '2022-02-20 00:00:00', '2022-01-20 00:00:00', 4);
INSERT INTO public.boat_available_period(
    available_period_id, end_date, start_date, boat_id)
VALUES (4,'2022-01-28 00:00:00', '2022-01-20 00:00:00', 5);

INSERT INTO public.reservation(
    reservation_type, id, cancelled, end_date, number_of_guests, start_date, total_price, type, system_user)
VALUES ('boat', 1, false, '2022-02-07 00:00:00', 4, '2022-01-28 00:08:00', 230, 'boat', 400);
INSERT INTO public.boat_reservation(
    id, boat_id, feedback_id, owner_feedback_id)
VALUES (1, 3, null, null);

INSERT INTO public.reservation(
    reservation_type, id, cancelled, end_date, number_of_guests, start_date, total_price, type, system_user)
VALUES ('boat', 2, false, '2022-02-09 00:00:00', 4, '2022-02-07 00:00:00', 230, 'boat', 401);
INSERT INTO public.boat_reservation(
    id, boat_id, feedback_id, owner_feedback_id)
VALUES (2, 3, null, null);

INSERT INTO public.reservation(
    reservation_type, id, cancelled, end_date, number_of_guests, start_date, total_price, type, system_user)
VALUES ('boat', 3, false, '2022-02-09 00:00:00', 4, '2022-02-07 00:00:00', 230, 'boat', 400);
INSERT INTO public.boat_reservation(
    id, boat_id, feedback_id, owner_feedback_id)
VALUES (3, 4, null, null);


INSERT INTO ROLE (id ,name) VALUES (1, 'ROLE_CLIENT');
INSERT INTO ROLE (id ,name) VALUES (2, 'ROLE_BOAT_OWNER');
INSERT INTO ROLE (id ,name) VALUES (3, 'ROLE_MANSION_OWNER');
INSERT INTO ROLE (id ,name) VALUES (4, 'ROLE_UNAUTHORISED');
INSERT INTO ROLE (id ,name) VALUES (5, 'ROLE_ADMIN');

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (400, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (401, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (402, 1);

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (5, 3);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (6, 5);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (100, 2);


INSERT INTO public.subscription(
    subscription_type, id, subscriber_id)
VALUES ('BOAT_SUBSCRIPTION', 11, 400);
INSERT INTO public.boat_subscription(
    id, boat_id)
VALUES (11, 3);

INSERT INTO public.subscription(
    subscription_type, id, subscriber_id)
VALUES ('BOAT_SUBSCRIPTION', 12, 400);
INSERT INTO public.boat_subscription(
    id, boat_id)
VALUES (12, 4);

INSERT INTO public.subscription(
    subscription_type, id, subscriber_id)
VALUES ('BOAT_SUBSCRIPTION', 13, 400);
INSERT INTO public.boat_subscription(
    id, boat_id)
VALUES (13, 5);

INSERT INTO public.subscription(
    subscription_type, id, subscriber_id)
VALUES ('BOAT_SUBSCRIPTION', 14, 401);
INSERT INTO public.boat_subscription(
    id, boat_id)
VALUES (14, 3);

INSERT INTO public.subscription(
    subscription_type, id, subscriber_id)
VALUES ('BOAT_SUBSCRIPTION', 15, 401);
INSERT INTO public.boat_subscription(
    id, boat_id)
VALUES (15, 6);

INSERT INTO public.subscription(
    subscription_type, id, subscriber_id)
VALUES ('BOAT_SUBSCRIPTION', 16, 401);
INSERT INTO public.boat_subscription(
    id, boat_id)
VALUES (16, 5);

INSERT INTO public.subscription(
    subscription_type, id, subscriber_id)
VALUES ('BOAT_SUBSCRIPTION', 17, 402);
INSERT INTO public.boat_subscription(
    id, boat_id)
VALUES (17, 4);

INSERT INTO public.subscription(
    subscription_type, id, subscriber_id)
VALUES ('BOAT_SUBSCRIPTION', 18, 402);
INSERT INTO public.boat_subscription(
    id, boat_id)
VALUES (18, 6);



	

