-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

CREATE TABLE IF NOT EXISTS guestbook_entry(id bigserial primary key , entry VARCHAR(200),username VARCHAR(200) UNIQUE, useremail VARCHAR(200) UNIQUE);

CREATE TABLE IF NOT EXISTS guestbook_comment(id bigserial primary key, entry_id integer REFERENCES guestbook_entry (id), comment VARCHAR(200));
