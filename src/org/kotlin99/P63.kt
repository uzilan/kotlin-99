package org.kotlin99

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

fun <T> completeBinaryTree(nodeAmount: Int, value: T): Tree<T> {
    fun generate(nodeAddress: Int): Tree<T> =
        if (nodeAddress > nodeAmount) End
        else Node(value, generate(nodeAddress * 2), generate(nodeAddress * 2 + 1))

    return generate(1)
}

class P63Test {
    @Test fun `construct complete binary tree`() {
        assertThat(completeBinaryTree(1, "x"), equalTo<Tree<String>>(
                Node("x")
        ))
        assertThat(completeBinaryTree(2, "x"), equalTo<Tree<String>>(
                Node("x", Node("x"))
        ))
        assertThat(completeBinaryTree(3, "x"), equalTo<Tree<String>>(
                Node("x", Node("x"), Node("x"))
        ))
        assertThat(completeBinaryTree(6, "x"), equalTo<Tree<String>>(
                Node("x",
                    Node("x", Node("x"), Node("x")),
                    Node("x", Node("x"), End))
        ))
    }
}