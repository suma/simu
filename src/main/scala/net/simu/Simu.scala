package net.simu


import java.util.Random

class Simu(count: int, rand: Random) {
  private val count_node = count
  private val random = rand
  private val nodes = new Array[Node](count)
  private val nodes_old = new Array[Node](count)

  for (i <- 0 to count - 1) {
    nodes.update(i, new Node(BigInt(i)))
    nodes(i).set_network(this)
  }

  def next_step(): Unit = {
    scala.Array.copy(nodes, 0, nodes_old, 0, count_node)
  }

  def get_node(index: int) =  nodes_old(index)

}
