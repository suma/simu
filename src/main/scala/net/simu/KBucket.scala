package net.simu

import java.util.Date
import scala.collection.mutable.ListBuffer

class KBucket(initK: Int) {
	val k = initK
	val bucket = new ListBuffer[Node]

	def isFull: Boolean = k == bucket.length

	def isEmpty: Boolean = bucket.length == 0
	def length: Int = bucket.length
	def has_node(node: Node): Boolean = bucket.exists(i => node.equals(i))

	def append(node: Node): Unit= {
		if (isFull) {
			bucket.remove(0)
		}

		// Append new node
		val index = bucket.findIndexOf(i => node.equals(i))
		if (index != -1) {
			bucket.remove(index)
		}
		bucket.append(node)
	}

	def remove(node: Node): Unit = {
		val index = bucket.findIndexOf(i => node.equals(i))
		if (index != -1)
			bucket.remove(index)
	}

	def remove_front(): Unit = {
		if (!isEmpty) {
			bucket.remove(0)
		}
	}

	def front: Node = {
    bucket.first
  }
}
