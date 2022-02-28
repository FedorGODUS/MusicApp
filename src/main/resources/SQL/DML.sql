INSERT INTO public.authors (id, name, description) VALUES (1, 'morgen', 'dinero');
INSERT INTO public.authors (id, name, description) VALUES (2, 'BBT', 'young');
INSERT INTO public.authors (id, name, description) VALUES (3, 'SQWOZ BAB', 'older');

INSERT INTO public.countries (id, country_name) VALUES (1, 'Russia');
INSERT INTO public.countries (id, country_name) VALUES (2, 'USA');
INSERT INTO public.countries (id, country_name) VALUES (3, 'UK');

INSERT INTO public.cities (id, city_name, country_id) VALUES (1, 'Moscow', 1);
INSERT INTO public.cities (id, city_name, country_id) VALUES (2, 'Washington', 2);
INSERT INTO public.cities (id, city_name, country_id) VALUES (3, 'London', 3);

INSERT INTO public.concerts (id, title, performer, concert_date, city_id) VALUES (1, 'Super Concert', 'morgen', '2022-02-28', 1);
INSERT INTO public.concerts (id, title, performer, concert_date, city_id) VALUES (2, 'Lollipop', 'BBT', '2022-02-27', 2);
INSERT INTO public.concerts (id, title, performer, concert_date, city_id) VALUES (3, 'Flowjob', 'SQWOZ BAB', '2022-02-22', 3);
