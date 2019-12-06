arry = "{[()]}"


def check(i):
    if arry[i] == "{":
        if arry[-(i + 1)] == "}":
            i = i + 1
            return check(i)
        else:
            return False
    if arry[i] == "[":
        if arry[-(i + 1)] == "]":
            i = i + 1
            return check(i)
        else:
            return False
    if arry[i] == "(":
        if arry[-(i + 1)] == ")":
            i = i + 1
            return check(i)
        else:
            return False
    return True


if __name__ == "__main__":
    i = 0
    print(check(i))