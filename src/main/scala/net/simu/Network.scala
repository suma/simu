package net.simu


class Network(count: Int, rand: scala.util.Random) {
	private val count_node = count
	private val nodes = new Array[Node](count)
	private val nodes_old = new Array[Node](count)

	for (i <- 0 to count - 1) {
		nodes.update(i, new Node(BigInt(i)))
		nodes(i).set_network(this)
	}

	def next_step(): Unit = {
		scala.Array.copy(nodes, 0, nodes_old, 0, count_node)
	}

	def get_node(index: Int): Node = nodes_old(index)

	def get_node(node: Node): Node = {
		val index = nodes_old.findIndexOf(i => node.equals(i))
		if (index == -1) {
			return null;
		}
		return nodes_old(index)
	}
}