
package net.simu

import scala._

class KademliaNode(id: BigInt) extends Node(id) { //extends Ordered[KademliaNode] {

	private val k = 20
	private val index = new Index(100)
	private val routing = new RoutingTable(this, k)
	private var network: Network = null
	private var active: Boolean = true

	def set_network(net: Network): Unit = {
		network = net
	}

	def is_active: Boolean = active
	def activate(flg: Boolean): Unit = {
		active = flg
	}

	// K: PING
	def ping(node: Node): Boolean = {
		return network.get_node(node).is_active
	}

	// K: STORE
	def store(node: Node, message: Message): Unit = {
		val target = network.get_node(node)
		try {
			target.msg_store(message)
		} catch {
			case _ => routing.remove_contact(target)
		}
	}

	// K: FIND_NODE
	def find_node(node: Node, key: BigInt) = {
		val target = network.get_node(node)
		try {
		} catch {
			case _ => routing.remove_contact(target)
		}
	}

	// K: FIND_VALUE
	def find_value(node: Node, key: BigInt) = {
		val target = network.get_node(node)
		try {
		} catch {
			case _ => routing.remove_contact(target)
		}
	}

	private def msg_store(msg: Message): Unit = {
		if (!is_active) {
			throw new Exception("KademliaNode is intactive")
		}
	}

	private def msg_find_node(key: BigInt) = {
	}

	private def msg_find_value(key: BigInt) = {
	}


}
