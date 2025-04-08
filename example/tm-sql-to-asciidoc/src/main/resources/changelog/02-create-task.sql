app_task (
    `id` VARCHAR(255) DEFAULT '' NOT NULL,
    `name` VARCHAR(255) DEFAULT '' NOT NULL,
    `description` VARCHAR(255) DEFAULT '' NOT NULL,
    CONSTRAINT pk_app_task PRIMARY KEY (id)
);