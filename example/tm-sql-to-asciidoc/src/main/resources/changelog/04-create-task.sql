CREATE TABLE app_task (
    id VARCHAR(255) DEFAULT '' NOT NULL,
    name VARCHAR(255) DEFAULT '' NOT NULL,
    description VARCHAR(255) DEFAULT '' NOT NULL,
    project_id VARCHAR(255) NULL REFERENCES app_project(id),
    user_id VARCHAR(255) NULL REFERENCES app_user(id),
    status status DEFAULT 'NOT_STARTED' NOT NULL,
    version INTEGER DEFAULT 0 NOT NULL,
    is_deleted BOOLEAN DEFAULT false NOT NULL,
    created TIMESTAMPTZ NOT NULL,
    updated TIMESTAMPTZ NULL,
    deleted TIMESTAMPTZ NULL,
    CONSTRAINT pk_app_task PRIMARY KEY (id)
);

comment on table app_task is 'Задача';
comment on column app_task.id is 'Идентификатор';
comment on column app_task.name is 'Название';
comment on column app_task.description is 'Описание';
comment on column app_task.status is 'Статус';
comment on column app_task.project_id is 'Идентификатор проекта';
comment on column app_task.user_id is 'Идентификатор пользователя';
comment on column app_task.version is 'Версия';
comment on column app_task.is_deleted is 'Флаг удаления';
comment on column app_task.created is 'Дата создания';
comment on column app_task.updated is 'Дата обновления';
comment on column app_task.deleted is 'Дата удаления';