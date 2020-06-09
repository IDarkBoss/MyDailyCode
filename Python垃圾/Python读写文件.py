import re

path_input = r"C:\Users\lenovo\Desktop\test.sql"
path_output = r"C:\Users\lenovo\Desktop\output.sql"
pattern = re.compile(r'-?[1-9]\d*')

with open(path_input,
          "r+", encoding="GB2312") as f1, open(path_output,
                                               "w",
                                               encoding="GB2312") as f2:
    data = f1.readlines()

    for row in data:
        if "insert into INS_VARIABLE_DEF(ID,ORDER_".lower() in row.lower():
            origin = re.findall(pattern, row)
            if (origin):
                id = origin[0]
                if int(id) > 124:
                    row = row.replace(id, str(int(id) + 1))

        f2.write(row)