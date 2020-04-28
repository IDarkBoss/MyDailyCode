import requests, shutil, random  # 首先import requests和shutils
from bs4 import BeautifulSoup  # 再import我们刚才说的BS
import codecs, urllib, json, time


def download(proxy, user_agents, page):  # 这个函数用来寻找，下载，保存图片
    url = "https://xxx.com/?page=%d" % page  # 这里是写好目标地址的url并方便后边循环page（把所有页面都下载了）

    html = requests.get(url,
                        proxies=proxy).content  # 这里是通过requests来获得整个网页的源代码并整理
    photos = BeautifulSoup(
        html,
        features="html.parser").find_all(class_="item-image fix-scale-cover")
    # 用BeautifulSoup解析html，然后使用BS自带的函数，找到所有class为imgwrapper的项存在一个list里面
    for photo in photos:
        img_url = photo.img["data-src"]
        # 这里是获得上面每一条里面的img（有这个方法）的“data-src”里存储的字符串（也就是图片的真实地址）
        # print photo, img_url
        img_filename = img_url.split("/")[-1]  # 使用切片工具切出每一个文件名
        path = "E:\\Work\\MyDailyCode\\Python垃圾\\img\\" + img_filename
        headers = {
            "User-Agent": random.choice(user_agents),
            "Connection": "close"
        }

        req = requests.get(url=img_url, headers=headers)

        if req.status_code == 200:
            with open(path, "wb") as f:
                f.write(req.content)
                print(img_filename, "saved.")  # 完成了叫一声


if __name__ == '__main__':
    proxy = {"http": "http://127.0.0.1:7890"}
    user_agents = [
        'Mozilla/5.0 (Windows NT 6.1; rv:2.0.1) Gecko/20100101 Firefox/4.0.1',
        'Mozilla/5.0 (Windows; U; Windows NT 6.1; en-us) AppleWebKit/534.50 (KHTML, like Gecko) Version/5.1 Safari/534.50',
        'Opera/9.80 (Windows NT 6.1; U; en) Presto/2.8.131 Version/11.11'
    ]

    for page in range(1, 20):
        download(proxy, user_agents, page)
        time.sleep(random.randint(0, 3))
