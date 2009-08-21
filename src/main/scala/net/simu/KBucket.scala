package net.simu

import java.util.Date
import scala.collection.mutable.ListBuffer

class KBucket(initK: int) {
	val k = initK
	val bucket = new ListBuffer[Node]

	def isFull: boolean = k == bucket.length

	def isEmpty: boolean = bucket.length == 0
	def length: int = bucket.length
	def has_node(node: Node): boolean = bucket.exists(i => node.equals(i))

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

	def removeFront(): Unit = {
		if (!isEmpty) {
			bucket.remove(0)
		}
	}

	def front: Node = {
    bucket.first
  }
}
