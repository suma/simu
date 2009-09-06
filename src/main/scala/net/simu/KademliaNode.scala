
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
	def store(node: Node, key: BigInt, message: Message): Unit = {
		val target = network.get_node(node)
		try {
			target.msg_store(key, message)
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
	def find_value(node: Node, key: BigInt): Option[Value] = {
		val target = network.get_node(node)
		try {
			return target.msg_find_value(key)
		} catch {
			case _ => routing.remove_contact(target); return None
		}
	}

	private def msg_store(key: BigInt, msg: Message): Unit = {
		if (!is_active) {
			throw new Exception("KademliaNode is intactive")
		}
		index.set(key, msg.value)
	}

	private def msg_find_node(key: BigInt) = {
	}

	private def msg_find_value(key: BigInt): Option[Value] = {
		try {
			return Some(index.get(key))
		} catch {
			case _: KeyNotFoundException => return None
		}
	}


}
