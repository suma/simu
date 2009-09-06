
package net.simu

class RoutingTable(initNode: KademliaNode, initK: Int) {
	private val node = initNode
	val k = initK
	val table = new Array[KBucket](160)
	for (i <- 0 to table.length - 1) {
		table.update(i, new KBucket(k))
	}

	def get_bucket_index(node: Node): Int =  {
		val distance = this.node.id ^ node.id
		val len = distance.bitLength
		if (len <= 1) {
			return 0
		} else {
			return len - 1
		}
	}

	def new_contact(node: Node) = {
		val index = get_bucket_index(node)
		val bucket = table(index)
		if (bucket.has_node(node)) {
			// Move to end
			bucket.remove(node)
			bucket.append(node)
		} else if (bucket.isFull) {
			if (this.node.ping(bucket.front)) {
				// Move front node to end
				val front = bucket.front
				bucket.remove_front()
				bucket.append(front)
			} else {
				bucket.remove_front()
				bucket.append(node)
			}
		 } else {
			 bucket.append(node)
		 }
	 }

	def remove_contact(node: Node) = {
		val index = get_bucket_index(node)
		table(index).remove(node)
	}

}
