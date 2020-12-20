IF NOT EXISTS (
        SELECT * FROM INFORMATION_SCHEMA.TABLES
           WHERE TABLE_NAME = N'user_roles')
BEGIN
CREATE TABLE user_roles(
	user_id  VARCHAR(36)    NOT NULL,
	role_id  VARCHAR(36)    NOT NULL,
	CONSTRAINT PK_IdUR PRIMARY KEY (user_id, role_id),
	CONSTRAINT FK_userId FOREIGN KEY (user_id) REFERENCES training.users (id),
	CONSTRAINT FK_role_id FOREIGN KEY (role_id) REFERENCES training.roles (id)
)
END
GO