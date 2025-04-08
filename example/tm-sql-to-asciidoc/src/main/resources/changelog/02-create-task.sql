CREATE TABLE app_task (
    id VARCHAR(255) DEFAULT '' NOT NULL,
    name VARCHAR(255) DEFAULT '' NOT NULL,
    description VARCHAR(255) DEFAULT '' NOT NULL,
    CONSTRAINT pk_app_task PRIMARY KEY (id)
);

comment on table app_task is 'Задача';
comment on column app_task.id is 'Идентификатор';
comment on column app_task.name is 'Название';
comment on column app_task.description is 'Описание';