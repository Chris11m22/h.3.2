CREATE TABLE student (
    ...,
    age INTEGER CHECK (age > 16),
    ...
);
CREATE TABLE student (
    ...,
    name TEXT UNIQUE NOT NULL,
    ...
);
CREATE TABLE student (
    ...,
    faculty TEXT UNIQUE,
    ...
);

