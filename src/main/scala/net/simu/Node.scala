
package net.simu

import scala._

class Node(i: BigInt) { //extends Ordered[Node] {

	private val id: BigInt = i
	private var network: Network = null
	private var active: Boolean = true

	def get_id = id
	def set_network(net: Network): Unit = {
		network = net
	}

	def is_active(): Boolean = active
	def activate(flg: Boolean): Unit = {
		active = flg
	}

	def ping(node: Node): Boolean = {
		return network.get_node(node).is_active
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
