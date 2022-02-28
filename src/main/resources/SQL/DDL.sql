create sequence hibernate_sequence;

alter sequence hibernate_sequence owner to postgres;

create table countries
(
    id           serial
        primary key,
    country_name text
);

alter table countries
    owner to postgres;

create table cities
(
    id         serial
        primary key,
    city_name  text,
    country_id integer
        constraint "FK_countries"
            references countries
            on update cascade on delete cascade
);

alter table cities
    owner to postgres;

create table concerts
(
    id           serial
        primary key,
    title        varchar not null,
    performer    varchar not null,
    concert_date date,
    city_id      integer
        constraint "FK_cities"
            references cities
            on update cascade on delete cascade
);

alter table concerts
    owner to postgres;

create table authors
(
    id          serial
        primary key,
    name        varchar not null,
    description varchar not null
);

alter table authors
    owner to postgres;

create table users
(
    id                           serial
        primary key,
    username                     varchar not null
        unique,
    password                     varchar,
    city_id                      integer
        constraint "FK_cities"
            references cities,
    current_user_subscription_id integer,
    author                       integer
        constraint fk_author
            references authors
            on update cascade on delete set null
);

alter table users
    owner to postgres;

create table tickets
(
    id         serial
        primary key,
    concert_id serial
        constraint "FK_concerts"
            references concerts
            on update cascade on delete cascade,
    user_id    serial
        constraint "FK_users"
            references users
            on update cascade on delete cascade,
    price      integer not null
        constraint price_greater_than_zero
            check (price > 0)
);

alter table tickets
    owner to postgres;

create table audios
(
    id        serial
        primary key,
    title     varchar not null,
    author_id integer not null
        constraint "FK_authors"
            references authors
            on update cascade on delete set null,
    audio     bytea
);

alter table audios
    owner to postgres;

create table subscriptions
(
    id          serial
        primary key,
    name        text    not null,
    price       integer not null,
    description text    not null
);

alter table subscriptions
    owner to postgres;

create table user_subscriptions
(
    id              serial
        primary key,
    is_valid        boolean not null,
    subscription_id integer not null
        constraint "FK_subscription"
            references subscriptions
            on delete cascade,
    host_user_id    integer not null
        constraint "FK_host_user"
            references users
);

alter table user_subscriptions
    owner to postgres;

alter table users
    add foreign key (current_user_subscription_id) references user_subscriptions;

create table user_playlists
(
    user_playlist_id serial
        constraint user_playlists_pk
            primary key,
    user_id          integer
        constraint user_id_fk
            references users
            on update cascade,
    title            varchar not null,
    description      varchar not null
);

alter table user_playlists
    owner to postgres;

create table uploaded_by_users
(
    user_id  bigint,
    audio_id bigint
);

alter table uploaded_by_users
    owner to postgres;

CREATE INDEX country_name_index ON countries(country_name);
CREATE INDEX city_name_index ON cities(city_name);
CREATE INDEX user_name_index ON users(username);
CREATE INDEX author_name_index ON authors(name);
CREATE INDEX audio_title_index ON audios(title);
