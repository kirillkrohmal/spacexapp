CREATE TABLE requests
(
  id int UNIQUE NOT NULL,
  ts timestamp default current_timestamp,
  data text,
  path text,
  CONSTRAINT requests_pkey PRIMARY KEY (id)
);
