CREATE TABLE app_user (
    id VARCHAR(255) DEFAULT '' NOT NULL,
    username VARCHAR(255) DEFAULT '' NOT NULL UNIQUE,
    password_hash VARCHAR(255) DEFAULT '' NOT NULL,
    email VARCHAR(255) DEFAULT '' NOT NULL UNIQUE,
    version INTEGER DEFAULT 0 NOT NULL,
    is_deleted BOOLEAN DEFAULT false NOT NULL,
    created TIMESTAMPTZ NOT NULL,
    updated TIMESTAMPTZ NOT NULL,
    CONSTRAINT pk_app_user PRIMARY KEY (id)
);

comment on table app_user is 'Пользователь';
comment on column app_user.username is 'Имя пользователя';
comment on column app_user.password_hash is 'Хеш пароля';
comment on column app_user.email is 'E-mail';
comment on column app_user.version is 'Версия';
comment on column app_user.is_deleted is 'Флаг удаления';
comment on column app_user.created is 'Дата создания';
comment on column app_user.updated is 'Дата обновления';