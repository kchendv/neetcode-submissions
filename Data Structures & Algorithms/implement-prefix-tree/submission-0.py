class Node:
    def __init__(self):
        self.children = dict()
class PrefixTree:

    def __init__(self):
        self.root = Node()
        

    def insert(self, word: str) -> None:
        cur = self.root
        for c in word + '.':
            if c not in cur.children:
                newc = Node()
                cur.children[c] = newc
            
            cur = cur.children[c]
        

    def search(self, word: str) -> bool:
        cur = self.root
        for c in word + '.':
            if c not in cur.children:
                return False
            else:
                cur = cur.children[c]
        return True

    def startsWith(self, prefix: str) -> bool:
        cur = self.root
        for c in prefix:
            if c not in cur.children:
                return False
            else:
                cur = cur.children[c]
        return True
        