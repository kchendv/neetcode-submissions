class Node:
    def __init__(self):
        self.isEnd = False
        self.children = dict()
class WordDictionary:

    def __init__(self):
        self.root = Node()
        

    def addWord(self, word: str) -> None:
        cur = self.root
        for i, c in enumerate(word):
            if c not in cur.children:
                cur.children[c] = Node()
                
            cur = cur.children[c]
        # print(self.root.children)
        cur.isEnd = True


    def search(self, word: str) -> bool:
        dfs = [(self.root, 0)]
        while dfs:
            # print(dfs)
            c, i = dfs.pop()
            if i == len(word):
                if c.isEnd:
                    return True
            elif word[i] == '.':
                for child in c.children.values():
                    dfs.append((child, i+1))
            elif word[i] in c.children:
                dfs.append((c.children[word[i]], i+1))

        return False