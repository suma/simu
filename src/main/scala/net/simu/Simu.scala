package net.simu


class Simu(count: int, rand: Random) {
	private val network = new Network(count, rand)

	def next_step(): Unit = {
		network.next_step()
	}

}
