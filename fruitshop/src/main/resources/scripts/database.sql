drop schema if exists fruitshop cascade;
create schema fruitshop;

create table fruitshop.user (
"id" bigserial primary key   ,
"name" text not null,
"username" text not null unique,
"email" text not null unique,
"password" text not null,
"active" bool not null
);

create table fruitshop.role (
"id" bigserial primary key   ,
"name" text not null,
"active" bool not null
);

create table fruitshop.user_role (
"user_id" bigint not null,
"role_id" bigint not null
);

create table fruitshop.product(
"id" bigserial primary key  ,
"name" text not null,
"image_link" text,
"description" text,
"price" numeric,
"quantity" bigint,
"active" bool not null
);

create table fruitshop.basket_product(
"id" bigserial primary key  ,
"product_id" bigint not null,
"quantity" bigint not null,
"active" bool not null
);

create table fruitshop.user_basket_product (
"user_id" bigint not null,
"basket_product_id" bigint not null
);


alter table fruitshop.user_role
drop constraint if exists user_id_constraint,
drop constraint if exists role_id_constraint,
ADD constraint  user_id_constraint FOREIGN KEY ("user_id") REFERENCES fruitshop.user (id),
ADD constraint  role_id_constraint FOREIGN KEY ("role_id") REFERENCES fruitshop.role (id);

alter table fruitshop.basket_product
drop constraint if exists product_id_constraint,
ADD constraint  product_id_constraint FOREIGN KEY ("product_id") REFERENCES fruitshop.product (id);


alter table fruitshop.user_basket_product
drop constraint if exists user_id_constraint,
drop constraint if exists basket_product_id_constraint,
ADD constraint  user_id_constraint FOREIGN KEY ("user_id") REFERENCES fruitshop.user (id),
ADD constraint  basket_product_id_constraint FOREIGN KEY ("basket_product_id") REFERENCES fruitshop.basket_product (id);


insert into fruitshop."role" (id,"name",active) values(1,'ROLE_USER',true);
insert into fruitshop."role" (id,"name",active) values(2,'ROLE_ADMIN',true);

insert into fruitshop.product(id,"name",image_link,description,price,quantity,active) 
values(1,'Apple', '../images/GrannySmith.jpg', 'Granny Smith', 2.50,90,true);
insert into fruitshop.product(id,"name",image_link,description,price,quantity,active) 
values(2,'Lemon', '../images/Lemon.jpg', 'From Portugal', 1.50,40,true);
insert into fruitshop.product(id,"name",image_link,description,price,quantity,active) 
values(3,'Pineapple', '../images/Pineapple.jpg', 'From Açores', 2.00,80,true);
insert into fruitshop.product(id,"name",image_link,description,price,quantity,active) 
values(4,'Orange', '../images/Orange.jpg', 'From Algarve', 2.50,60,true);