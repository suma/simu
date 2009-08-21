
package net.simu

import scala._

class Node(i: BigInt) { //extends Ordered[Node] {

	private val id: BigInt = i
	private var network: Simu = null
	private var active: Boolean = true

	def get_id = id
	def set_network(simu: Simu): Unit = {
		network = simu
	}

	def is_active() = active
	def activate(flg: Boolean): Unit = {
		active = flg
	}

	def push_message(message: Message, id_sender: int): Unit = {
	}

	def compare(node: Node): int = {
		if (id < node.id) {
			return -1
		} else if (id > node.id) {
			return 1
		}
		return 0
	}

	/*
	override def <(node: Node): Boolean = id < node.id
	override def <=(node: Node): Boolean = id <= node.id
	override def >(node: Node): Boolean = id > node.id
	override def >=(node: Node): Boolean = id >= node.id
	*/

	def ==(node: Node): Boolean = id == node.id
	def equals(node: Node) = id == node.id

	def ^(node: Node) = id ^ node.id

}
