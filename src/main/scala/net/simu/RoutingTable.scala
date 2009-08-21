
package net.simu

class RoutingTable(initNode: Node, initK: int) {
  private val node = initNode
  val k = initK
  val table = new Array[KBucket](160)
  for (i <- 0 to table.length - 1) {
    table.update(i, new KBucket(k))
  }

  def get_bucket_index(node: Node): int =  {
    val distance = this.node ^ node
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
      bucket.remove(node)
      bucket.append(node)
    } else if (bucket.isFull) {
       // PING
       // if (node.send_ping(bucket.front())) {
       if (true) {
         bucket.removeFront()
       }
       bucket.append(node)
     } else {
       bucket.append(node)
     }
   }

  def remove_contact(node: Node) = {
    val index = get_bucket_index(node)
    table(index).remove(node)
  }

}
