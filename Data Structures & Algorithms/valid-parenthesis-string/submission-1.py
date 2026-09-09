class Solution:
    def checkValidString(self, s: str) -> bool:
        ub = 0
        lb = 0
        for c in s:
            if c == '(':
                ub += 1
                lb += 1
            elif c == ')':
                if ub == 0:
                    return False
                ub -= 1
                lb -= 1
            else:
                ub += 1
                lb = max(0, lb - 1)
            # print(ub, lb)
        return lb <= 0


        # (**(
