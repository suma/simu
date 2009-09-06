/*
 * kbucketTest.scala
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package net.simu

import org.junit.After
import org.junit.Before
import org.junit.Assert._
import org.junit.Test

class kbucketTest {

  val k: Int = 20
  val bucket = new KBucket(k)

  @Before
    def setUp: Unit = {
  }

  @After
    def tearDown: Unit = {
  }

  @Test
  def kbucket = {
    assertEquals(false, bucket.isFull)
  }

  @Test
  def kbucketAppend1 = {
    // k の数だけ
    for (i <- 1 to k) {
      bucket.append(new Node(i))
    }
    assertEquals(k, bucket.length)
    assertEquals(BigInt(1), bucket.front.get_id)
  }

  @Test
  def kbucketAppend2 = {
    // k より多くappendしたときでも正しく動くか
    for (i <- 1 to k + 1) {
      bucket.append(new Node(i))
    }
    assertEquals(k , bucket.length)
    assertEquals(BigInt(2), bucket.front.get_id)
  }

  @Test
  def kbucketAppend3 = {
    // 要素を削除しても動くか
    for (i <- 1 to k) {
      bucket.append(new Node(i))
    }
    val remv = new Node(10)
    bucket.remove(remv)
    assertEquals(k - 1 , bucket.length)
    assertEquals(false, bucket.has_node(remv))
  }
}
