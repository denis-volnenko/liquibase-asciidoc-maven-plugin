CREATE TABLE app_project (
    id VARCHAR(255) DEFAULT '' NOT NULL,
    name VARCHAR(255) DEFAULT '' NOT NULL,
    description VARCHAR(255) DEFAULT '' NOT NULL,
    CONSTRAINT pk_app_project PRIMARY KEY (id)
);

comment on table app_project is 'Проект';
comment on column app_project.id is 'Идентификатор';
comment on column app_project.name is 'Название';
comment on column app_project.description is 'Описание';
