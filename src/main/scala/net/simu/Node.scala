
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

	// K: PING
	def ping(node: Node): Boolean = {
		return network.get_node(node).is_active
	}

	// K: STORE
	def push_message(message: Message, id_sender: Int): Unit = {
	}

	// K: FIND_NODE
	def find_node(key: BigInt) = {
	}

	// K: FIND_VALUE
	def find_value(key: BigInt) = {
		
	}

	def compare(node: Node): Int = {
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
