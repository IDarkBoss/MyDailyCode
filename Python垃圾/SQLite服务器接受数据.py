from flask import Flask
import sqlite3

app = Flask(__name__)


@app.route('/')
def hello():
    return "雷猴啊"


@app.route('/register/<username>&<password>', methods=["GET", "POST"])
def register(username, password):
    conn = sqlite3.connect("/home/lionel/Handup_down.db")
    cur = conn.cursor()
    print("jajjajaa")
    # 是否已存在
    sql = "select * from USERS where USERNAME='" + username + "' and PASSWORD='" + password + "'"
    cur.execute(sql)
    data = cur.fetchone()
    if data is not None:
        return "用户已存在"
    else:
        sql = f"insert into USERS(USERNAME, PASSWORD, NAME, TIMES) VALUES ({username}, {password}, 'NAME', 0);"
        cur.execute(sql)
        conn.commit()
        conn.close()
        return "注册成功"


@app.route('/login/<username>&<password>', methods=['GET'])
def login(username, password):
    print("asdasds")
    conn = sqlite3.connect("/home/lionel/Handup_down.db")
    cur = conn.cursor()
    sql = "select * from USERS where USERNAME='" + username + "' and PASSWORD='" + password + "'"
    cur.execute(sql)
    data = cur.fetchone()
    conn.close()

    if len(data) > 0:
        return True
    else:
        return False


if __name__ == '__main__':
    # app.debug = True
    app.run(host="0.0.0.0", port=8000)
