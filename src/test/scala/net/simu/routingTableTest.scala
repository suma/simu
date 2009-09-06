
package net.simu

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert._

class routingTableTest {

	val node = new KademliaNode(0)
	val k = 20
	val rt = new RoutingTable(node, k)

	@Before
	def setUp: Unit = {
	}

	@After
	def tearDown: Unit = {
	}

	@Test
	def indexTest = {
		val a = new KademliaNode(1)
		val b = new KademliaNode(2)
		assertEquals(0, rt.get_bucket_index(a))
		assertEquals(1, rt.get_bucket_index(b))
	}
}
