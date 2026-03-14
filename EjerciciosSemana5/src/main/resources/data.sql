INSERT INTO CUSTOMER (name, email) VALUES ( 'Juan Perez', 'juan@email.com');
INSERT INTO CUSTOMER ( name, email) VALUES ( 'Maria Lopez', 'maria@email.com');
INSERT INTO CUSTOMER ( name, email) VALUES ( 'Carlos Ruiz', 'carlos@email.com');
INSERT INTO CUSTOMER ( name, email) VALUES ( 'Ana Torres', 'ana@email.com');
INSERT INTO CUSTOMER ( name, email) VALUES ( 'Luis Garcia', 'luis@email.com');

INSERT INTO orders ( total, customer_id) VALUES ( 120.50, 1);
INSERT INTO orders ( total, customer_id) VALUES ( 300.00, 2);
INSERT INTO orders ( total, customer_id) VALUES ( 75.25, 3);
INSERT INTO orders ( total, customer_id) VALUES ( 500.00, 4);
INSERT INTO orders ( total, customer_id) VALUES ( 60.00, 5);

INSERT INTO order_item ( product_name, price, quantity, order_id) VALUES ( 'Guitar', 100.00, 1, 1);
INSERT INTO order_item ( product_name, price, quantity, order_id) VALUES ( 'Drums', 300.00, 1, 2);
INSERT INTO order_item ( product_name, price, quantity, order_id) VALUES ( 'Violin', 75.25, 1, 3);
INSERT INTO order_item ( product_name, price, quantity, order_id) VALUES ( 'Piano', 500.00, 1, 4);
INSERT INTO order_item ( product_name, price, quantity, order_id) VALUES ( 'Flute', 60.00, 1, 5);