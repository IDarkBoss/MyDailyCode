import re

path = r"E:\svn\CNP\trunk\database\Initdate\ins_init_data_0.sql"
pattern = re.compile(r'-?[1-9]\d*')

with open(r"ins_init_data_0.sql", "r+",
          encoding="utf-8") as f1, open(r"1.sql", "w", encoding="utf-8") as f2:
    data = f1.readlines()

    for row in data:
        if "insert into INS_VARIABLE_DEF(ID,ORDER_NUMBER" in row:
            origin = re.findall(pattern, row)
            if (origin):
                id = origin[0]
                if int(id) > 67:
                    row = row.replace(id, str(int(id) + 1))

        f2.write(row)