
package net.simu

import scala.collection.mutable.HashMap
import java.util.Date

class KeyNotFoundException extends Exception {
}

class Index(initTtl: Long) {
	private val ttl = initTtl
	private val dic = new HashMap[BigInt, (Value, Date)]

	def isEmpty = dic.isEmpty
	def size = dic.size

	def get(key: BigInt): Value = {
		dic.get(key) match {
			case Some((value, _)) => value
			case None => throw new KeyNotFoundException;
		}
	}

	def set(key: BigInt, value: Value): Unit = {
		dic += key -> (value, new Date())
	}


	def delete_expired(): Unit = {
		val now = new Date()
		for ((key, (_, date)) <- dic) {now
			 if (ttl <= (now.getTime() - date.getTime())) {
				 dic -= key
			 }
		}
	}

}
