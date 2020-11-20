package lesson5

import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class OpenAddressingSetTest : AbstractOpenAddressingSetTest() {

    override fun <T : Any> create(bits: Int): MutableSet<T> {
        return OpenAddressingSet(bits)
    }

    @Test
    @Tag("Example")
    fun addTestJava() {
        doAddTest()
    }

    @Test
    @Tag("7")
    fun removeTestJava() {
        doRemoveTest()
        doRemoveTest2()
    }

    @Test
    @Tag("5")
    fun iteratorTestJava() {
        doIteratorTest()
        doIteratorTest2()
    }

    @Test
    @Tag("8")
    fun iteratorRemoveTestJava() {
        doIteratorRemoveTest()
    }
}