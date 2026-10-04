class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        net = 0
        lp = 0
        lpi = -1
        for i in range(len(gas)):
            net += gas[i] - cost[i]
            if net < lp:
                lp = net
                lpi = i
        if net < 0:
            return -1
        if lpi == len(gas) - 1:
            return 0
        return lpi + 1