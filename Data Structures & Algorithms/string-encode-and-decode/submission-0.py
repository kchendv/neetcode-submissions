class Solution:

    def encode(self, strs: List[str]) -> str:

        final = ""
        for s in strs:
            s = s.replace("\\", "\\\\")
            s = s.replace(",", "\\,")
            final += s + ','
        return final

    def decode(self, s: str) -> List[str]:
        c = 0
        cur = ""
        final_list = []
        while c < len(s):
            if (s[c] == '\\'):
                if (s[c+1] == '\\'):
                    cur += '\\'
                    c += 2
                elif (s[c+1] == ','):
                    cur += ','
                    c += 2
            elif (s[c] == ','):
                final_list.append(cur)
                cur = ""
                c += 1
            else:
                cur += s[c]
                c += 1

        return final_list