CREATE TABLE IF NOT EXISTS public.user (
    id serial,
    first_name varchar(31),
    last_name varchar(31),
    phone_number varchar(31),
    password varchar(31),
    email varchar(31),
    CONSTRAINT pk_user_id PRIMARY KEY (id)
);