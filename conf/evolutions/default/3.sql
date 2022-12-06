-- Create triggers

-- !Ups

create or replace function scan_playing_cards() returns trigger as
$$
declare
    count integer;;
begin
    select count(*) from user_cards where user_id = new.user_id into count;;
    if count > 5 then
        raise exception 'You can only have 5 playing cards.';;
    end if;;
    return new;;
end;;
$$ language plpgsql;

create or replace trigger check_playing_cards
    after insert
    on user_cards
    for each row
execute procedure scan_playing_cards();;

/* Триггер, запрещающий ставить более одной карты на одну координату */
create or replace function check_duplicate_coordinates() returns trigger as
$$
begin
    if exists(select * from game_field where x_coordinate = new.x_coordinate and y_coordinate = new.y_coordinate) then
        raise exception 'You can only have one card at a coordinate.';;
    end if;;
    return new;;
end;;
$$
    language plpgsql;

create or replace trigger one_card_per_coordinate
    before insert
    on game_field
    for each row
execute procedure check_duplicate_coordinates();;

/* Триггер, контролирующий количество пользователей в одной сессии (1 – 4) */
create or replace function check_session_users() returns trigger as
$$
declare
    count integer;;
begin
    select count(*) from users into count;;
    if count > 4 then
        raise exception 'You can only have 4 users in one session.';;
    end if;;
    return new;;
end;;
$$ language plpgsql;

create or replace trigger check_user_count
    after insert
    on users
    for each row
execute procedure check_session_users();;

/* Триггер, проверяющий что карта может быть только в одной из таблиц с динамическими данными */
create or replace function check_field_dump() returns trigger as
$$
begin
    if exists(select * from square_dump where card_id = new.card_id) then
        raise exception 'This card is in dump.';;
    end if;;
    if exists(select * from game_field where card_id = new.card_id) then
        raise exception 'This card is in field.';;
    end if;;
    return new;;
end;;
$$ language plpgsql;

create or replace function check_cards_dump() returns trigger as
$$
begin
    if exists(select * from square_dump where card_id = new.card_id) then
        raise exception 'This card is in dump.';;
    end if;;
    if exists(select * from user_cards where card_id = new.card_id) then
        raise exception 'This card is in user cards.';;
    end if;;
    return new;;
end;;
$$ language plpgsql;

create or replace function check_cards_field() returns trigger as
$$
begin
    if exists(select * from game_field where card_id = new.card_id) then
        raise exception 'This card is in field.';;
    end if;;
    if exists(select * from user_cards where card_id = new.card_id) then
        raise exception 'This card is in user cards.';;
    end if;;
    return new;;
end;;
$$ language plpgsql;

create or replace trigger check_cards_table
    after insert
    on user_cards
    for each row
execute procedure check_field_dump();;

create trigger check_field_table
    after insert
    on game_field
    for each row
execute procedure check_cards_dump();;

create or replace trigger check_dump_table
    after insert
    on square_dump
    for each row
execute procedure check_cards_field();;

/* Триггер, проверяющий что эффект может быть только в одной из таблиц с динамическими данными*/
create or replace function check_response_dump() returns trigger as
$$
begin
    if exists(select * from response_dump where response_id = new.response_id) then
        raise exception 'This response is in dump.';;
    end if;;
    return new;;
end;;
$$ language plpgsql;

create or replace function check_effect() returns trigger as
$$
begin
    if exists(select * from effect where response_id = new.response_id) then
        raise exception 'This response is in effect.';;
    end if;;
    return new;;
end;;
$$ language plpgsql;

create or replace trigger check_response_table
    after insert
    on response_dump
    for each row
execute procedure check_effect();;

create or replace trigger check_effect_table
    after insert
    on effect
    for each row
execute procedure check_response_dump();;

-- !Downs