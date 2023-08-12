CREATE TABLE users (
    ...,
    age INTEGER CHECK (age > 16),
    ...
);
CREATE TABLE users (
    ...,
    name TEXT UNIQUE NOT NULL,
    ...
);
CREATE TABLE users (
    ...,
    faculty TEXT UNIQUE,
    ...
);

