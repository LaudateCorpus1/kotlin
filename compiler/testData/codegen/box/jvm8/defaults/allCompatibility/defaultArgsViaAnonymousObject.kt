// !JVM_DEFAULT_MODE: all-compatibility
// IGNORE_BACKEND_FIR: JVM_IR
// TARGET_BACKEND: JVM
// JVM_TARGET: 1.8
// WITH_RUNTIME

interface A {
    fun foo(x: String = "OK"): String {
        return x
    }
}

fun box(): String {
    val x = object : A {}
    return x.foo()
}