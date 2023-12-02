# inventory-control-api
1. Crear la base de datos:

create database minimarket_marina
use minimarket_marina

2. Configurar el application.propperties:

server.port=9001
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/minimarket_marina
spring.jpa.database-platform=org.hibernate.dialect.MySQL57Dialect
spring.datasource.username=your-user
spring.datasource.password=your-password
spring.jpa.hibernate.ddl-auto=update

3. Insertar las opciones del menú:

insert into home_option(description, menu, route_image_path, route_path, status, title, user_type) 
values ('Configuración de módulos para un correcto funcionamiento del sistema.', 0, '/assets/images/config-home.jpg', 'configuration', 'ACTIVE', 'Configuración', 'admin')

insert into home_option(description, menu, route_image_path, route_path, status, title, user_type) 
values ('Ingreso al módulo de productos.', 0, '/assets/images/product-home.jpg', 'product', 'ACTIVE', 'Productos', 'admin')

insert into home_option(description, menu, route_image_path, route_path, status, title, user_type) 
values ('Ingreso al módulo de pedidos.', 0, '/assets/images/order-home.jpg', 'order', 'ACTIVE', 'Pedidos', 'admin')

insert into home_option(description, menu, route_image_path, route_path, status, title, user_type) 
values ('Ingreso al módulo de inventario.', 0, '/assets/images/prod-inv-home.jpg', 'product-inventory', 'ACTIVE', 'Inventario', 'admin')

insert into home_option(description, menu, route_image_path, route_path, status, title, user_type) 
values ('Ingreso al módulo de categorías.', 1, '/assets/images/category-home.jpg', 'category', 'ACTIVE', 'Categorías', 'admin')

insert into home_option(description, menu, route_image_path, route_path, status, title, user_type) 
values ('Ingreso al módulo de proveedores.', 1, '/assets/images/provider-home.jpg', 'provider', 'ACTIVE', 'Proveedor', 'admin')

insert into home_option(description, menu, route_image_path, route_path, status, title, user_type) 
values ('Ingreso al módulo de usuarios.', 1, '/assets/images/user-home.jpg', 'user', 'ACTIVE', 'Usuarios', 'admin')
