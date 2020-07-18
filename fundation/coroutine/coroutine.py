"""
链式协程
"""
class Coroutine(object):
    raw = ''
    def __init__(self, raw):
        self.raw = raw

    def producer(self, next_cor = None):
        tokens = self.raw.strip().split()
        for token in tokens:
            next_cor.send(token)
        next_cor.close()


    def intermediate(self, pattern = "ing" , next_cor = None):
        print("Searching for pattern '{}'".format(pattern))
        try:
            while True:
                token = yield
                if pattern in token:
                    next_cor.send(token)
        except GeneratorExit:
            print("Filtering accomplished!")


    def consumer(self):
        print("Consumer start printing...")
        try:
            while True:
                token = yield
                print(token)
        except GeneratorExit:
            print("Print accomplished!")


if __name__ == "__main__":
    test = Coroutine(raw="Shane is running behind a moving car.")
    # 初始化两个协程
    consumer = test.consumer()
    consumer.__next__()
    intermediate = test.intermediate(next_cor=consumer)
    intermediate.__next__()

    producer = test.producer(next_cor=intermediate)

"""
Consumer start printing...
Searching for pattern 'ing'
running
moving
Filtering accomplished!
Print accomplished!
"""




