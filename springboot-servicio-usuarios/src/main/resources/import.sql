INSERT INTO usuarios(username,password,enabled,nombre,apellido,email) VALUES('joe','$2a$10$TOaBh7/FQdV7/M9HFq7SnuMF0EgKDcc9Wx9HsUNn/g4EezsEA9wV2',true,'Joel','Perez','joe@gmail.com');
INSERT INTO usuarios(username,password,enabled,nombre,apellido,email) VALUES('mar','$2a$10$xrKIfP8GkrDjydJ4vftR3OlFj7YgoEpy3JL.GzLQRgfX6iOk7LGH2',true,'Marriela','Blanquez','mar@gmail.com');

INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO usuarios_roles(usuario_id,roles_id)VALUES(1,1);
INSERT INTO usuarios_roles(usuario_id,roles_id)VALUES(2,2);
INSERT INTO usuarios_roles(usuario_id,roles_id)VALUES(2,1);


