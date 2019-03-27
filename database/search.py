#!/user/local/opt/python/libexec/bin/python

import psycopg2


def search(cur):
    cur.execute("select book_image_directory from textbook where book_id in (select bid from classnbook where cid in "
                "(select class_id from class where dept = 35 and school = 60));")


def application():
    try:
        conn = psycopg2.connect(database="test2", host="localhost", port="5432", user="xiaoyuanduan", password="0000")
    except psycopg2.OperationalError:
        print("connection error")
    else:
        cur = conn.cursor()

        search(cur)
        books = cur.fetchall()

        for l in books:
            print(str(l) + "\n")

        # conn.commit()
        conn.close()

        print("work")

    return


if __name__ == '__main__':
    application()
