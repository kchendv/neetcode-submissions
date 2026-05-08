class Solution {
    private data class Target(
        val v: Int,
        val t: Int,
    )
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val x: MutableMap<Int, MutableList<Target>> = mutableMapOf()
        times.forEach { t ->
            if (x.contains(t[0])) {
                x[t[0]]?.add(Target(t[1], t[2]))
            } else {
                x[t[0]] = mutableListOf(Target(t[1], t[2]))
            }
        }
        val tt: MutableList<Int> = MutableList(n){Int.MAX_VALUE}
        val q: MutableList<Target> = mutableListOf(Target(k, 0))
        while (q.isNotEmpty()) {
            val tx: Target = q.removeFirst()
            if (tx.t < tt[tx.v - 1]) {
                tt[tx.v - 1] = tx.t
                if (x.contains(tx.v)) {
                    x[tx.v]?.forEach { tn ->
                        q.add(Target(tn.v, tx.t + tn.t))
                    }
                }
            }
        }
        if (tt.contains(Int.MAX_VALUE)) {
            return -1
        }
        return tt.max()
        
    }
}
