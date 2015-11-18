package test

interface A {
    fun run()
}

class B(val o: String, val k: String) {

    inline fun testNested(crossinline f: (String) -> Unit, crossinline f2: (String) -> Unit) {
        object : A {
            override fun run() {
                f(o)
                f2(k)
            }
        }.run()
    }

    inline fun test(crossinline f: (String) -> Unit) {
        call {
            f("start");
            {
                testNested ({ it -> { f(it + o) }() }) { it -> { f(it + k) }() }
            }()
        }
    }

    inline fun call(f: () -> Unit) {
        f()
    }


}