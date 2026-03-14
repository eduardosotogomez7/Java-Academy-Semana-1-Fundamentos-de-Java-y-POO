INSERT INTO CUSTOMER (id, name, email) VALUES (1, 'Juan Perez', 'juan@email.com');
INSERT INTO CUSTOMER (id, name, email) VALUES (2, 'Maria Lopez', 'maria@email.com');
INSERT INTO CUSTOMER (id, name, email) VALUES (3, 'Carlos Ruiz', 'carlos@email.com');
INSERT INTO CUSTOMER (id, name, email) VALUES (4, 'Ana Torres', 'ana@email.com');
INSERT INTO CUSTOMER (id, name, email) VALUES (5, 'Luis Garcia', 'luis@email.com');

INSERT INTO orders (id, total, customer_id) VALUES (1, 120.50, 1);
INSERT INTO orders (id, total, customer_id) VALUES (2, 300.00, 2);
INSERT INTO orders (id, total, customer_id) VALUES (3, 75.25, 3);
INSERT INTO orders (id, total, customer_id) VALUES (4, 500.00, 4);
INSERT INTO orders (id, total, customer_id) VALUES (5, 60.00, 5);

INSERT INTO order_item (id, product_name, price, quantity, order_id) VALUES (1, 'Guitar', 100.00, 1, 1);
INSERT INTO order_item (id, product_name, price, quantity, order_id) VALUES (2, 'Drums', 300.00, 1, 2);
INSERT INTO order_item (id, product_name, price, quantity, order_id) VALUES (3, 'Violin', 75.25, 1, 3);
INSERT INTO order_item (id, product_name, price, quantity, order_id) VALUES (4, 'Piano', 500.00, 1, 4);
INSERT INTO order_item (id, product_name, price, quantity, order_id) VALUES (5, 'Flute', 60.00, 1, 5);