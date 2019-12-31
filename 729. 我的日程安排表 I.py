class MyCalendar:
    def __init__(self):
        self.timetable = []

    def book(self, start: int, end: int) -> bool:
        for i in self.timetable:
            if i[0] < end and start < i[1]:
                return False

        self.timetable.append([start, end])
        return True


start = 10
end = 20
MyCalendar()
result = MyCalendar.book(None, start, end)
print(result)

# Your MyCalendar object will be instantiated and called as such:
# obj = MyCalendar()
# param_1 = obj.book(start,end)