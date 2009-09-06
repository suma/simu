package net.simu


class Node(node_id: BigInt) {
	val id = node_id

	def compare(node: KademliaNode): Int = {
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