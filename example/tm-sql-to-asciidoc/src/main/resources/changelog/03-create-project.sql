CREATE TABLE app_project (
    id VARCHAR(255) DEFAULT '' NOT NULL,
    name VARCHAR(255) DEFAULT '' NOT NULL,
    description VARCHAR(255) DEFAULT '' NOT NULL,
    user_id VARCHAR(255) NULL REFERENCES app_user(id),
    status status DEFAULT 'NOT_STARTED' NOT NULL,
    version INTEGER DEFAULT 0 NOT NULL,
    is_deleted BOOLEAN DEFAULT false NOT NULL,
    created TIMESTAMPTZ NOT NULL,
    updated TIMESTAMPTZ NOT NULL,
    UNIQUE (name, user_id),
    CONSTRAINT pk_app_project PRIMARY KEY (id)
);

comment on table app_project is 'Проект';
comment on column app_project.id is 'Идентификатор';
comment on column app_project.name is 'Название';
comment on column app_project.description is 'Описание';
comment on column app_project.status is 'Статус';
comment on column app_project.user_id is 'Идентификатор пользователя';
comment on column app_project.version is 'Версия';
comment on column app_project.is_deleted is 'Флаг удаления';
comment on column app_project.created is 'Дата создания';
comment on column app_project.updated is 'Дата обновления';
