package net.simu

class Simu(count: Int, rand: scala.util.Random) {
	private val network = new Network(count, rand)

	def next_step(): Unit = {
		network.next_step()
	}

}
