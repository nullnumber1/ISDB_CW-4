-- Create tables

-- !Ups

create table characters
(
    character_id serial primary key,
    name         varchar(30) unique not null,
    moving       smallint           not null,
    fight        smallint           not null,
    firing_range smallint           not null
);

create table users
(
    user_id      serial primary key,
    username     varchar(30)                                  not null,
    password     varchar(128)                                 not null,
    po_amount    smallint default 0                           not null,
    character_id integer references characters (character_id) not null,
    x_coordinate smallint default 0                           not null,
    y_coordinate smallint default 0                           not null
);

create table organism_response
(
    response_id   serial primary key,
    response_type varchar(30)        not null,
    name          varchar(30) unique not null
);

create table response_dump
(
    response_id integer primary key references organism_response (response_id)
);

create table effect
(
    effect_id   serial primary key,
    user_id     integer references users (user_id)                 not null,
    response_id integer references organism_response (response_id) not null
);

create table square_action
(
    action_id   serial primary key,
    action_name varchar(30) not null
);

create table square_condition
(
    condition_id   serial primary key,
    condition_name varchar(30) unique not null
);

create table square_shape
(
    shape_id   serial primary key,
    shape_name varchar(30) unique not null
);

create table square_object
(
    object_id   serial primary key,
    object_name varchar(30) unique not null
);

create table square_stack
(
    card_id      serial primary key,
    name         varchar(30)                                  not null,
    po_amount    smallint                                     not null,
    shape_id     integer references square_shape (shape_id)   not null,
    object_id    integer references square_object (object_id) not null,
    action_id    integer references square_action (action_id),
    condition_id integer references square_condition (condition_id)
);

create table square_dump
(
    card_id integer primary key references square_stack (card_id)
);

create table user_cards
(
    id      serial primary key,
    user_id integer references users (user_id)        not null,
    card_id integer references square_stack (card_id) not null
);

create table control_markers
(
    marker_id serial primary key,
    user_id   integer references users (user_id)       not null,
    amount    smallint default 5 check ( amount >= 0 ) not null
);

create table disease
(
    disease_id    serial primary key,
    name          varchar(30) unique not null,
    po_reward     smallint           not null,
    square_reward smallint,
    x_coordinate  smallint,
    y_coordinate  smallint
);

create table game_field
(
    field_id     serial primary key,
    x_coordinate smallint                                  not null,
    y_coordinate smallint                                  not null,
    card_id      integer references square_stack (card_id) not null,
    user_id      integer references users (user_id),
    disease_id   integer references disease (disease_id),
    marker_id    integer references control_markers (marker_id)
);

-- !Downs

truncate table users, control_markers, game_field, user_cards, effect, response_dump, square_dump;
