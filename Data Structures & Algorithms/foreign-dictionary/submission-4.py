class Solution:
    def foreignDictionary(self, words: List[str]) -> str:
        # Nodes: c, traversed, exists (in dict), befores
        self.incorrect = False
        class Alphabet:
            def __init__(self, i):
                self.i = i
                self.exists = False
                self.befores = set()
                self.afters = set()

        self.ind = [Alphabet(i) for i in range(26)]

        for w in words:
            for c in w:
                self.ind[self.pos(c)].exists = True
        self.helper(words)
        if self.incorrect:
            return ""

        to_consider = [i for i in range(26) if self.ind[i].exists and not self.ind[i].befores]
        ans = ""
        while to_consider:
            next = self.ind[to_consider.pop(0)]
            ans += chr(next.i + 97)
            for after in next.afters:
                self.ind[after].befores.remove(next.i)
                if not self.ind[after].befores:
                    to_consider.append(after)
        if (len(ans) != len([i for i in range(26) if self.ind[i].exists])):
            return ""
        return ans
    
    def helper(self, words):
        print(words)
        order = []
        prev = ""
        next = []

        for i in range(len(words)):
            if words[i][0] != prev:
                order.append(words[i][0])
                prev = words[i][0]
                if len(next) > 1:
                    self.helper(next)
                next = []
            nextw = words[i][1:]
            if nextw != "":
                next.append(nextw)
            elif next:
                self.incorrect = True
                return
        if len(next) > 1:
            self.helper(next)
        for i in range(len(order) - 1):
            oi = self.pos(order[i])
            oin = self.pos(order[i+1])
            print("dep from ", chr(oi+97), "to ", chr(oin+97))
            # self.ind[oi].exists = True
            self.ind[oi].afters.add(oin) 
            self.ind[oin].befores.add(oi)
        # self.ind[self.pos(order[-1])].exists = True
    def pos(self, c):
        return ord(c) - 97