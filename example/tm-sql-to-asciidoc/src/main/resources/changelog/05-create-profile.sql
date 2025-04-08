CREATE TABLE app_profile (
    id VARCHAR(255) DEFAULT '' NOT NULL,
    user_id VARCHAR(255) NOT NULL REFERENCES app_user(id) UNIQUE,
    first_name VARCHAR(255) DEFAULT '' NOT NULL,
    last_name VARCHAR(255) DEFAULT '' NOT NULL,
    middle_name VARCHAR(255) DEFAULT '' NOT NULL,
    version INTEGER DEFAULT 0 NOT NULL,
    is_deleted BOOLEAN DEFAULT false NOT NULL,
    created TIMESTAMPTZ NOT NULL,
    updated TIMESTAMPTZ NULL,
    deleted TIMESTAMPTZ NULL,
    CONSTRAINT pk_app_profile PRIMARY KEY (id)
);

comment on table app_profile is 'Профиль';
comment on column app_profile.id is 'Идентификатор';
comment on column app_profile.user_id is 'Идентификатор пользователя';
comment on column app_profile.first_name is 'Имя';
comment on column app_profile.last_name is 'Фамилия';
comment on column app_profile.middle_name is 'Отчество';
comment on column app_profile.version is 'Версия';
comment on column app_profile.is_deleted is 'Флаг удаления';
comment on column app_profile.created is 'Дата создания';
comment on column app_profile.updated is 'Дата обновления';
comment on column app_profile.deleted is 'Дата удаления';
