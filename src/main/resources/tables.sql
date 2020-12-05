CREATE TABLE rockets
(
  id int UNIQUE NOT NULL,
  rocket_id character varying(2000),
  CONSTRAINT rockets_pkey PRIMARY KEY (id)
);

CREATE TABLE launches
(
  id int UNIQUE NOT NULL,
  rocket_id int NOT NULL,
  mission_name character varying(2000),
  launch_year int,
  links character varying(2000),
  CONSTRAINT launches_pkey PRIMARY KEY (id),
  CONSTRAINT rocket_fkey FOREIGN KEY (rocket_id) REFERENCES rockets(id)
);
