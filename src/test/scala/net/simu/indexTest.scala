package net.simu

import org.junit.Assert._
import org.junit.Test

class indexTest {

	val ttl = 0
	val index = new Index(ttl)

	@Test
	def setGetTest = {
		val key = BigInt(12345)
		val value = new Value(100)
		index.set(key, value)
		assertEquals(value, index.get(key))
		assertTrue(value.id == index.get(key).id)
	}

	@Test
	def getTest = {
		var throwed = false
		try {
			index.get(BigInt(1))
		} catch {
			case _: KeyNotFoundException => throwed = true
		}
		assertTrue(throwed)
	}

	@Test
	def expireTest = {
		val value = new Value(100)
		index.set(BigInt(1), value)
		index.set(BigInt(2), value)
		index.set(BigInt(3), value)
		assertEquals(3, index.size)

		index.delete_expired();
		assertTrue(index.isEmpty)
		assertEquals(0, index.size)
	}

	@Test
	def sizeTest = {
		assertEquals(0, index.size)
		val value = new Value(100)
		index.set(BigInt(1), value)
		assertEquals(1, index.size)
	}

	@Test
	def emptyTest = {
		assertTrue(index.isEmpty)
		assertEquals(0, index.size)
	}

}