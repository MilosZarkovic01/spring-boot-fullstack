-- by using BIGSERIAL we don't have to create sequence by ourself

CREATE  TABLE  customer(
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    gender TEXT NOT NULL,
    age INT NOT NULL
);
