-- Table: public."user"

-- DROP TABLE public."user";

CREATE TABLE public."user"
(
    firstname character varying(50)[] COLLATE pg_catalog."default" NOT NULL,
    lastname character varying(50)[] COLLATE pg_catalog."default" NOT NULL,
    email character varying(100)[] COLLATE pg_catalog."default",
    phone character varying(10)[] COLLATE pg_catalog."default" NOT NULL,
    profilepic bytea,
    username character varying(50)[] COLLATE pg_catalog."default" NOT NULL,
    password character varying(50)[] COLLATE pg_catalog."default" NOT NULL,
    id integer NOT NULL DEFAULT nextval('user_id_seq'::regclass),
    point integer,
    level integer,
    CONSTRAINT user_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."user"
    OWNER to postgres;