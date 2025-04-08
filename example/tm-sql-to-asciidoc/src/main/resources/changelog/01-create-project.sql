CREATE TABLE app_project (
    id VARCHAR(255) DEFAULT '' NOT NULL,
    name VARCHAR(255) DEFAULT '' NOT NULL,
    description VARCHAR(255) DEFAULT '' NOT NULL,
    CONSTRAINT pk_app_project PRIMARY KEY (id)
);
