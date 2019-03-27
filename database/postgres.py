#!/user/local/opt/python/libexec/bin/python

import psycopg2


def create_database(cur):
    #this one for user test
    #cur.execute("create table if not exists PPL "
    #            "(user_id serial primary key, user_name text not null unique);")

    cur.execute("create table if not exists UNIVERSITY "
                "(school_id serial primary key, school_name text not null, school_addr text unique);")

    cur.execute("create table if not exists DEPARTMENT "
                "(dept_id serial primary key, dept_name text not null);")

    cur.execute("create table if not exists CLASS "
                "(class_id serial primary key, class_name text not null, class_code text not null, "
                "dept int references DEPARTMENT(dept_id) not null, "
                "school int references UNIVERSITY(school_id) not null);")

    cur.execute("create table if not exists TEXTBOOK "
                "(book_id serial primary key, book_detail text not null, "
                "book_image_directory text not null unique, book_name text not null, "
                "book_price float not null, book_seller int references PPL(user_id));")

    cur.execute("create table if not exists classnbook "
                "(cnb_id serial primary key, c_id int references CLASS(class_id), "
                "b_id int references TEXTBOOK(book_id));")
    # device table
    cur.execute("create table if not exists device "
                "(device_id serial primary key, device_name text not null, device_detail text not null, "
                "device_price float not null, device_seller int references PPL(user_id));")

    cur.execute("create table if not exists devicenschool "
                "(dns_id serial primary key, d_id int references device(device_id), "
                "s_id int references university(school_id));")

    return


def crt_new(cur):
    cur.execute("create table if not exists car "
                "(car_id serial primary key, car_name text not null, car_start text not null, "
                "car_end text not null, car_price float not null, car_owner int references PPL(user_id));")

    cur.execute("create table if not exists carnschool "
                "(cns_id serial primary key, c_id int references car(car_id), "
                "s_id int references university(school_id));")


def application():
    try:
        conn = psycopg2.connect(database="test2", host="localhost", port="5432", user="xiaoyuanduan", password="0000")
        #format:
        # conn = psycopg2.connect(database="", host="", port="", user="", password="")
    except psycopg2.OperationalError:
        print("connection error")
    else:
        cur = conn.cursor()

        #create_database(cur)
        crt_new(cur)

        conn.commit()
        conn.close()

        print("work")
    return


if __name__ == '__main__':
    application()
