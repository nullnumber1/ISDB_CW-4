-- Create functions

-- !Ups

CREATE OR REPLACE FUNCTION give_cards()
    RETURNS text AS
$$
DECLARE
    card_ids_array integer[];;
    user_ids_array integer[];;
    card_index     integer = 1;;
    user_to_update integer;;
BEGIN
    card_ids_array := array(select card_id from square_stack order by random());;
    raise notice 'card_ids_array: %', card_ids_array;;
    SELECT array_agg(user_id) INTO user_ids_array FROM users;;
    FOREACH user_to_update IN ARRAY user_ids_array
        LOOP
            FOR i IN card_index..card_index + 2
                LOOP
                    INSERT INTO user_cards (user_id, card_id) VALUES (user_to_update, card_ids_array[i]);;
                END LOOP;;
            card_index = card_index + 3;;
        END LOOP;;
    RETURN 'Cards given';;
END;;
$$ LANGUAGE plpgsql;

/* move user to specified coordinate */
CREATE OR REPLACE FUNCTION update_user_coordinate(user_id_param int, coordinate_x_param int, coordinate_y_param int)
    RETURNS VOID AS
$$
DECLARE
    last_x integer := 0;;
    last_y integer := 0;;
BEGIN
    SELECT (x_coordinate) FROM USERS WHERE USERS.user_id = user_id_param into last_x;;
    SELECT (y_coordinate) FROM USERS WHERE USERS.user_id = user_id_param into last_y;;

    UPDATE users
    SET x_coordinate = coordinate_x_param,
        y_coordinate = coordinate_y_param
    WHERE USERS.user_id = user_id_param;;

    UPDATE GAME_FIELD
    SET user_id = NULL
    WHERE GAME_FIELD.x_coordinate = last_x
      AND GAME_FIELD.y_coordinate = last_Y;;

    UPDATE GAME_FIELD
    SET user_id = user_id_param
    WHERE GAME_FIELD.x_coordinate = coordinate_x_param
      AND GAME_FIELD.y_coordinate = coordinate_y_param;;

END;;
$$ LANGUAGE plpgsql;

/* move disease to specified coordinate */
CREATE OR REPLACE FUNCTION update_disease_coordinate(disease_id_param int, coordinate_x_param int, coordinate_y_param int)
    RETURNS VOID AS
$$
DECLARE
    last_x integer := 0;;
    last_y integer := 0;;
BEGIN
    SELECT (x_coordinate) FROM disease WHERE disease_id = disease_id_param into last_x;;
    SELECT (y_coordinate) FROM disease WHERE disease_id = disease_id_param into last_y;;

    UPDATE disease
    SET x_coordinate = coordinate_x_param,
        y_coordinate = coordinate_y_param
    WHERE disease_id = disease_id_param;;

    UPDATE game_field
    SET disease_id = NULL
    WHERE x_coordinate = last_x
      AND y_coordinate = last_y;;

    UPDATE game_field
    SET disease_id = disease_id_param
    WHERE x_coordinate = coordinate_x_param
      AND y_coordinate = coordinate_y_param;;

END;;
$$ LANGUAGE plpgsql;

-- !Downs