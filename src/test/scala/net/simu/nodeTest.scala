/*
 * nodeTest.scala
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package net.simu

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert._

class nodeTest {

	val node1 = new Node(1)
	val node2 = new Node(2)

	@Before
	def setUp: Unit = {
	}

	@After
	def tearDown: Unit = {
	}

	@Test
	def idTest = {
		assertEquals(BigInt(1), node1.id)
		assertEquals(BigInt(2), node2.id)
	}

	@Test
	def nodeCreateTest = {
		val a = new Node(1)
		val b = new Node(1)
		assertEquals(true, a.equals(b))
		assertEquals(true, a == b)
	}

	@Test
	def nodeXorTest = {
		// 1 xor 2 => 3
		assertEquals(BigInt(3), node1 ^ node2)
	}


}
