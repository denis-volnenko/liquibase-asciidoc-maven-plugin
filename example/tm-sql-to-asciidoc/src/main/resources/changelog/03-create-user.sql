CREATE TABLE app_user (
    id VARCHAR(255) DEFAULT '' NOT NULL,
    username VARCHAR(255) DEFAULT '' NOT NULL,
    password_hash VARCHAR(255) DEFAULT '' NOT NULL,
    CONSTRAINT pk_app_user PRIMARY KEY (id)
);