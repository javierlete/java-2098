--
-- Archivo generado con SQLiteStudio v3.4.4 el lu. nov. 11 09:32:30 2024
--
-- Codificación de texto usada: UTF-8
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Tabla: mensajes
CREATE TABLE IF NOT EXISTS mensajes (id INTEGER PRIMARY KEY AUTOINCREMENT, usuario_id REFERENCES usuarios (id) NOT NULL, fecha DATETIME NOT NULL, texto VARCHAR(255) NOT NULL);
INSERT INTO mensajes (id, usuario_id, fecha, texto) VALUES (1, 1, '2024-11-06 11:21', 'Mensaje de prueba');
INSERT INTO mensajes (id, usuario_id, fecha, texto) VALUES (2, 2, '2024-11-06 11:30', 'Otro mensaje');
INSERT INTO mensajes (id, usuario_id, fecha, texto) VALUES (3, 1, '2024-11-06 11:40', 'Mensaje posterior');
INSERT INTO mensajes (id, usuario_id, fecha, texto) VALUES (4, 1, '2024-11-07 10:17', 'Prueba de mensaje nuevo con Javier Lete');
INSERT INTO mensajes (id, usuario_id, fecha, texto) VALUES (5, 2, '2024-11-07 10:23', 'Hola a todos');
INSERT INTO mensajes (id, usuario_id, fecha, texto) VALUES (6, 2, '2024-11-07 10:23', '¿Qué tal estáis?');
INSERT INTO mensajes (id, usuario_id, fecha, texto) VALUES (7, 3, '2024-11-07 10:25', 'ñalsdkjflñaskdhgñlkajsdfñlkhasldg');
INSERT INTO mensajes (id, usuario_id, fecha, texto) VALUES (8, 3, '2024-11-07 10:25', 'Otro');
INSERT INTO mensajes (id, usuario_id, fecha, texto) VALUES (9, 3, '2024-11-07 10:26', '¡Mira que hija más guapa tengo!');

-- Tabla: usuarios
CREATE TABLE IF NOT EXISTS usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre VARCHAR(100) NOT NULL, email VARCHAR(100) NOT NULL UNIQUE, password VARCHAR(100) NOT NULL);
INSERT INTO usuarios (id, nombre, email, password) VALUES (1, 'Javier Lete', 'javier@email.net', 'javier');
INSERT INTO usuarios (id, nombre, email, password) VALUES (2, 'Pepe Pérez', 'pepe@email.net', 'pepe');
INSERT INTO usuarios (id, nombre, email, password) VALUES (3, 'Juan', 'juan@email.net', 'juan');

-- Tabla: usuarios_lesgusta_mensajes
CREATE TABLE IF NOT EXISTS usuarios_lesgusta_mensajes (usuarios_id REFERENCES usuarios (id) NOT NULL, mensajes_id REFERENCES mensajes (id) NOT NULL, PRIMARY KEY (usuarios_id, mensajes_id));
INSERT INTO usuarios_lesgusta_mensajes (usuarios_id, mensajes_id) VALUES (2, 3);
INSERT INTO usuarios_lesgusta_mensajes (usuarios_id, mensajes_id) VALUES (2, 2);
INSERT INTO usuarios_lesgusta_mensajes (usuarios_id, mensajes_id) VALUES (1, 3);
INSERT INTO usuarios_lesgusta_mensajes (usuarios_id, mensajes_id) VALUES (3, 7);
INSERT INTO usuarios_lesgusta_mensajes (usuarios_id, mensajes_id) VALUES (3, 5);
INSERT INTO usuarios_lesgusta_mensajes (usuarios_id, mensajes_id) VALUES (3, 4);
INSERT INTO usuarios_lesgusta_mensajes (usuarios_id, mensajes_id) VALUES (1, 1);
INSERT INTO usuarios_lesgusta_mensajes (usuarios_id, mensajes_id) VALUES (1, 9);
INSERT INTO usuarios_lesgusta_mensajes (usuarios_id, mensajes_id) VALUES (1, 8);
INSERT INTO usuarios_lesgusta_mensajes (usuarios_id, mensajes_id) VALUES (1, 7);
INSERT INTO usuarios_lesgusta_mensajes (usuarios_id, mensajes_id) VALUES (1, 5);
INSERT INTO usuarios_lesgusta_mensajes (usuarios_id, mensajes_id) VALUES (3, 6);
INSERT INTO usuarios_lesgusta_mensajes (usuarios_id, mensajes_id) VALUES (3, 2);
INSERT INTO usuarios_lesgusta_mensajes (usuarios_id, mensajes_id) VALUES (3, 3);
INSERT INTO usuarios_lesgusta_mensajes (usuarios_id, mensajes_id) VALUES (3, 1);
INSERT INTO usuarios_lesgusta_mensajes (usuarios_id, mensajes_id) VALUES (3, 8);
INSERT INTO usuarios_lesgusta_mensajes (usuarios_id, mensajes_id) VALUES (3, 9);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
