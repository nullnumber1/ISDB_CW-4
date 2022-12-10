-- Insert static game data

-- !Ups

insert into characters (name, moving, fight, firing_range)
VALUES ('Default', 0, 0, 0),
       ('Энни', 2, 2, 3),
       ('Доктор Ксенон Блум', 2, 2, 2),
       ('Рик', 3, 2, 3),
       ('Пончо', 2, 3, 2),
       ('Морти', 3, 1, 3),
       ('Роджер', 2, 2, 3);

insert into disease (name, po_reward, square_reward)
VALUES ('Гепатит A', 3, 1),
       ('Гепатит C', 2, 1),
       ('Гонорея', 1, 3),
       ('Кишечная палочка', 2, 2);

insert into disease (name, po_reward)
VALUES ('Бубонная Чума', 4),
       ('Туберкулёз', 3);

insert into square_shape (shape_name)
VALUES ('SQUARE'),
       ('CIRCLE'),
       ('TRIANGLE'),
       ('STAR');

insert into square_object(object_name)
VALUES ('EXIT'),
       ('ATTRACTION'),
       ('CAFE'),
       ('SLIDE');

insert into square_condition(condition_name)
VALUES ('COMPLETE_PROXIMITY'),
       ('CAFE_PROXIMITY'),
       ('ATTRACTION_PROXIMITY'),
       ('SLIDE_PROXIMITY'),
       ('SQUARE_CAFE_PROXIMITY'),
       ('DOUBLE_SQUARE_PROXIMITY'),
       ('DOUBLE_CIRCLE_PROXIMITY'),
       ('DOUBLE_STAR_PROXIMITY'),
       ('STAR_SLIDE_PROXIMITY'),
       ('CIRCLE_ATTRACTION_PROXIMITY');

insert into square_action(action_name)
VALUES ('EXIT'),
       ('CONTROL_MARKER_ATTRACTION'),
       ('CONTROL_MARKER_CAFE'),
       ('CONTROL_MARKER_SLIDE'),
       ('CONTROL_MARKER_SQUARE'),
       ('CONTROL_MARKER_CIRCLE'),
       ('CONTROL_MARKER_STAR'),
       ('CONTROL_MARKER_MINUS'),
       ('TAKE_CARD'),
       ('NEIGHBOUR_BONUS_STAR'),
       ('NEIGHBOUR_BONUS_CIRCLE'),
       ('NEIGHBOUR_BONUS_SQUARE'),
       ('TAKE_ORGANISM_RESPONSE'),
       ('CAFE_BONUS');

insert into organism_response(response_type, name)
VALUES ('DISEASE', 'Гепатит A'),
       ('DISEASE', 'Гепатит C'),
       ('DISEASE', 'Бубонная Чума'),
       ('DISEASE', 'Гонорея'),
       ('DISEASE', 'Кишечная палочка'),
       ('DISEASE', 'Туберкулёз'),
       ('ACTION', 'Оргазм'),
       ('ACTION', 'Кашель'),
       ('ACTION', 'Тошнота'),
       ('ACTION', 'Острая диарея'),
       ('ACTION', 'Опьянение'),
       ('ACTION', 'Чихание'),
       ('ACTION', 'Мигрень'),
       ('ACTION', 'Отрыжка'),
       ('ACTION', 'Жидкий стул'),
       ('ACTION', 'Метеоризм'),
       ('EFFECT', 'Слюнотечение'),
       ('EFFECT', 'Озноб'),
       ('EFFECT', 'Вздутие живота'),
       ('EFFECT', 'Судороги'),
       ('EFFECT', 'Икота'),
       ('EFFECT', 'Камни в почках'),
       ('INFARCT', 'Первый инфаркт'),
       ('INFARCT', 'Второй инфаркт');

insert into square_stack (name, po_amount, shape_id, object_id, action_id)
VALUES ('Закусочки', 0, 2, 3, 14),
       ('Шлюз пищевода', 1, 1, 2, 9),
       ('Черепашья фиеста', 2, 4, 3, 13),
       ('Нижняя Брюхляндия', 2, 4, 2, 13),
       ('Бар и Криль', 0, 1, 3, 10),
       ('Почечные горки', 2, 1, 4, 13),
       ('Лёгкие перегрузки', 2, 2, 4, 13),
       ('Мочепад', 1, 4, 4, 5),
       ('Спуск по толстой кишке', 0, 4, 4, 11),
       ('Нарезка мошоночки', 2, 1, 3, 13),
       ('Пик селезёнки', 1, 1, 4, 6),
       ('Батут диафрагмы', 2, 2, 2, 13),
       ('Набивка пузика', 1, 1, 3, 4),
       ('Будка корн-догов', 1, 2, 3, 9),
       ('Печень с приведениями', 0, 2, 2, 12),
       ('Пираты Поджелудчного моря', 5, 1, 4, 8),
       ('Карусель коры головного мозга', 1, 2, 4, 7),
       ('Тонкая-тонкая кишка', 1, 4, 2, 3),
       ('Зал костного мозга', 2, 1, 2, 13),
       ('Одноклеточная карусель', 1, 4, 4, 9),
       ('Тако Да!', 2, 2, 3, 13),
       ('ООО "Стейк с картошкой"', 1, 4, 3, 2),
       ('Правая ноздря', 1, 3, 1, 1),
       ('Великий анус', 1, 3, 1, 1),
       ('Правое ухо', 1, 3, 1, 1),
       ('Левый сосок', 1, 3, 1, 1);

insert into square_stack (name, po_amount, shape_id, object_id, condition_id)
VALUES ('Голодная хижина Боба', 4, 2, 3, 7),
       ('Киса Терияки', 3, 4, 3, 5),
       ('Чудесные моменты с Рубеном', 3, 1, 2, 10),
       ('Сосочная карусель', 3, 2, 4, 9),
       ('Киоск с чуррос', 2, 1, 3, 3),
       ('Сплав по гемоглобиновой реке', 4, 1, 4, 6),
       ('Контактный зоопарк простаты', 4, 4, 2, 8),
       ('Дамба сфинктера', 1, 4, 2, 1),
       ('Клуб "Весёлые кости"', 2, 2, 2, 4),
       ('Ректодром', 2, 4, 2, 2);


-- !Downs

DROP TABLE games;