CREATE TABLE requests
(
  id int UNIQUE NOT NULL,
  ts timestamp default current_timestamp,
  data character varying(2000),
  path character varying(2000),
  CONSTRAINT requests_pkey PRIMARY KEY (id)
);
