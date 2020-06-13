--liquibase formatted sql

--changeset neodevelop:202006131106-7
alter table invoice add date_updated datetime null;

update invoice set date_updated = concat_ws(' ', uddate, udtime);

alter table invoice drop column uddate;

alter table invoice drop column udtime;
