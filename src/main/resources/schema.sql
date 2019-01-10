
CREATE SEQUENCE IF NOT EXISTS public.employee_seq;

CREATE TABLE if not exists public.employee
(
  id bigint NOT NULL DEFAULT nextval('employee_seq'::regclass),
  email character varying(255),
  name character varying(255),
  CONSTRAINT employee_pkey PRIMARY KEY (id)
)