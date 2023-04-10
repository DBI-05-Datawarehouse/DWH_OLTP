create table article
(
    article_nr           serial    not null,
    discontinued         boolean   not null,
    min_stock            integer   not null,
    name                 varchar(255),
    order_unit           varchar(255),
    price                float(53) not null,
    stock                integer   not null,
    supply_unit          varchar(255),
    category_category_nr integer,
    supplier_supplier_nr integer,
    primary key (article_nr)
);
create table category
(
    category_nr serial not null,
    description TEXT,
    name        varchar(255),
    primary key (category_nr)
);
create table customer
(
    customer_nr serial not null,
    city        varchar(255),
    contact     varchar(255),
    country     varchar(255),
    fax         varchar(255),
    firm        varchar(255),
    phone       varchar(255),
    position    varchar(255),
    region      varchar(255),
    street      varchar(255),
    zip         varchar(255),
    primary key (customer_nr)
);
create table firm
(
    firm_nr serial not null,
    name    varchar(255),
    primary key (firm_nr)
);
create table order_details
(
    discount           float(53) not null,
    quantity           integer   not null,
    single_price       float(53) not null,
    article_article_nr integer   not null,
    order_order_nr     integer   not null,
    primary key (article_article_nr, order_order_nr)
);
create table orders
(
    order_nr              serial    not null,
    city                  varchar(255),
    country               varchar(255),
    firm                  varchar(255),
    order_date            date,
    region                varchar(255),
    shipping_costs        float(53) not null,
    shipping_date         date,
    street                varchar(255),
    zip                   varchar(255),
    customer_customer_nr  integer,
    shipping_firm_firm_nr integer,
    staff_staff_nr        integer,
    primary key (order_nr)
);
create table staff
(
    staff_nr      serial not null,
    birth_date    date,
    boss          varchar(255),
    city          varchar(255),
    country       varchar(255),
    first_name    varchar(255),
    hire_date     date,
    last_name     varchar(255),
    phone_office  varchar(255),
    phone_private varchar(255),
    position      varchar(255),
    region        varchar(255),
    remark        varchar(255),
    street        varchar(255),
    zip           varchar(255),
    primary key (staff_nr)
);
create table supplier
(
    supplier_nr serial not null,
    city        varchar(255),
    contact     varchar(255),
    country     varchar(255),
    fax         varchar(255),
    firm        varchar(255),
    phone       varchar(255),
    position    varchar(255),
    region      varchar(255),
    street      varchar(255),
    zip         varchar(255),
    primary key (supplier_nr)
);
alter table if exists article
    add constraint FKfs6yu1y3y14fopep4x4ktyjxf foreign key (category_category_nr) references category;
alter table if exists article
    add constraint FK8gpjxiqpfnt638s27fv9ji61n foreign key (supplier_supplier_nr) references supplier;
alter table if exists order_details
    add constraint FKm5fxmw610t96ecipn1rr044j6 foreign key (article_article_nr) references article;
alter table if exists order_details
    add constraint FKl67robyv1swjiqfbww14fhsmn foreign key (order_order_nr) references orders;
alter table if exists orders
    add constraint FKa08cgcau1ymff97wmojvip2wf foreign key (customer_customer_nr) references customer;
alter table if exists orders
    add constraint FKskhcwrxcqawr6nnw29hjw4wva foreign key (shipping_firm_firm_nr) references firm;
alter table if exists orders
    add constraint FKoi4lnamjpknj72gmhcwbywvly foreign key (staff_staff_nr) references staff;
