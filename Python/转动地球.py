# https://blog.csdn.net/xiaorang/article/details/106692489
from PIL import Image, ImageDraw
import math
import numpy as np
import imageio
import torch


def calcSphereXY2XYZ(px, py, maxHeight, longOffset):
    v0x = torch.from_numpy(np.array(px))
    v0y = torch.from_numpy(np.array(py))
    v03 = v0x - maxHeight
    v04 = v0y - maxHeight
    v1x = v03 / maxHeight
    v1y = v04 / maxHeight
    # print(max(v1x), min(v1x))
    v07 = torch.pow(v1x, 2)
    v08 = torch.pow(v1y, 2)
    v09 = v07 + v08
    v0a = 1 - v09
    v1z = torch.pow(v0a, 1 / 2)  # z
    # print("z:", max(v1z), min(v1z))
    v1lat = torch.mul(v1y, math.pi / 2)  # lat
    v0lon = torch.tanh(v1z)
    v1lon = v0lon + longOffset  # long
    v2lon = torch.fmod(v1lon, math.pi * 2)  # long
    return v2lon, v1lat


def calcShpereLatLong2XY(vlon, vlat, width, height):
    v3x0 = torch.mul(vlon, width / 2 / math.pi)
    v3y0 = torch.mul(vlat, height / math.pi)
    v3y1 = torch.add(v3y0, height / 2)
    v3x2 = v3x0.astype(np.integer)
    v3y2 = v3y1.astype(np.integer)
    return v3x2, v3y2


def getPic(a):
    # imgBack= Image.open("地球3.jpg")
    imgBack = Image.open("Resources/世界地球日地图_8K_2.jpg")
    imgCloud = Image.open("Resources/世界地球云地图_8K.jpg")
    width = imgBack.size[0]
    height = imgBack.size[1]
    imgBack = imgBack.convert("RGBA")
    arrayBack = np.array(imgBack)
    arrayCloud = np.array(imgCloud)
    circleSize = 508
    img2 = Image.new("RGBA", (circleSize, circleSize))
    img = Image.new("RGBA", (circleSize, circleSize), "black")
    w = img.size[0]
    h = img.size[1]
    pxList = []
    pyList = []
    for i in range(w):
        for j in range(h):
            r = math.sqrt((i - w / 2)**2 + (j - h / 2)**2)
            if r < circleSize / 2:
                pxList.append(i)
                pyList.append(j)

    nplon, nplat = calcSphereXY2XYZ(pxList, pyList, h / 2, a)
    nplon2, nplat2 = calcSphereXY2XYZ(pxList, pyList, h / 2, a / 2)
    # nplon, nplat= rotSphere(nplon, nplat, )
    npx, npy = calcShpereLatLong2XY(nplon, nplat, width - 1, height)
    npx2, npy2 = calcShpereLatLong2XY(nplon2, nplat2, width - 1, height)
    color = arrayBack[npy, npx]
    color2 = arrayCloud[npy2, npx2]
    for i in range(len(pxList)):
        x = pxList[i]
        y = pyList[i]
        cc = color[i]
        # print(cc)
        cc = tuple(cc)
        img.putpixel((x, y), cc)
        c2 = color2[i]
        c0 = int(c2[0] * 1.6)
        if c0 > 255:
            c0 = 255
        c_alpha = int(c2[0] * 0.9)
        c2 = (c0, c0, c0, c_alpha)
        img2.putpixel((x, y), c2)
    r, g, b, a = img2.split()
    img.paste(img2, (0, 0), mask=a)
    return img


if __name__ == "__main__":
    frames = []
    str1 = "./Resources/微信地球_mask.jpg"
    img1 = Image.new("RGBA", (750, 1334))
    img2 = Image.open(str1)
    for i in range(0, 720, 12):
        a = -i * math.pi / 180
        img = getPic(a)
        img1.paste(img, (122, 424))
        r, g, b = img2.split()
        img1.paste(img2, (0, 0))
        str1 = "./temp/temp%03d.png" % i
        print(str1)
        img1.save(str1)
        im = imageio.imread(str1)
        frames.append(im)
        # img.show()
    imageio.mimsave("earth.gif", frames, "GIF", duration=0.20)
