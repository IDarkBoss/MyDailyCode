def check(a, temp, i, arry):
    if i >= len(arry):
        if temp == 0:
            return True
        else:
            return False
    else:
        if temp == 0:
            a = 1

        if arry[i] == "{" or arry[i] == "[" or arry[i] == "(":
            temp = temp + 1
            i = i + 1
            return check(a, temp, i, arry)
        if arry[i] in chara.values():
            right = arry[i]
            left = list(chara.keys())[list(chara.values()).index(right)][0]

            left_bracket = arry[i - a]
            if left_bracket != left:
                return False
            else:
                temp = temp - 1
                a = a + 2
                i = i + 1
                return check(a, temp, i, arry)


if __name__ == "__main__":
    arry = "()"
    chara = {}
    chara["("] = ")"
    chara["["] = "]"
    chara["{"] = "}"

    temp = 0
    a = 1
    i = 0

    print(check(a, temp, i, arry))
