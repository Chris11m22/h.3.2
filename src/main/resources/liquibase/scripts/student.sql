-- liquibase formatted sgl
-- changset christinam 1
create index name_index on stuent(name)
-- changset christinam 2
create index name_color_index on faculty(name,color)