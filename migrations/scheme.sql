create table if not exists barbershops (
    id uuid primary key default gen_random_uuid(),
    name text not null,
    address text not null,
    phone_number varchar(255) not null,
    working_time text not null,
    photo text
);

create table if not exists services (
    id uuid primary key default gen_random_uuid(),
    name text not null,
    description text not null,
    grade1_price integer not null,
    grade2_price integer not null,
    grade3_price integer not null,
    average_time integer not null
)