#!/user/local/opt/python/libexec/bin/python

import psycopg2


def add_school(cur):
    for i in range(4, 100):
        cur.execute("insert into UNIVERSITY (school_id, school_name, school_addr) values (" + str(i) + ", " + str(
            i) + ", " + str(i) + ");")


def add_major(cur):
    for i in range(1, 100):
        cur.execute("insert into department(dept_id, dept_name) values (" + str(i) + "," + str(i) + ");")


def add_class(cur):
    x = 1
    for i in range(1, 100):
        for j in range(1, 100):
            for k in range(1, 5):
                cur.execute("insert into class(class_id, class_name, class_code, dept, school) values(" +
                            str(x) + "," + str(k) + "," + str(k) + "," + str(j) + "," + str(i) + ");")
                x = x + 1


def add_book(cur):
    for i in range(1, 78409):
        cur.execute("insert into textbook values(" + str(i) + "," + str(i) + "," + str(i) + ", 1.00 , 1);")


def classnbook(cur):
    x = 3
    for i in range(2,25000):
        for j in range(2):
            cur.execute("insert into classnbook values(" + str(x) + "," + str(i) + "," + str(x) + ");")
            x = x + 1


def application():
    try:
        conn = psycopg2.connect(database="test2", host="localhost", port="5432", user="xiaoyuanduan", password="0000")
    except psycopg2.OperationalError:
        print("connection error")
    else:
        cur = conn.cursor()

        # add_major(cur)
        # add_class(cur)
        #add_book(cur)
        classnbook(cur)

        conn.commit()
        conn.close()

        print("work")

    return


if __name__ == '__main__':
    application()
