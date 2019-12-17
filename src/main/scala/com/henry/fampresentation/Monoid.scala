package com.henry.fampresentation

trait Monoid[T] {
  def append(l: T, r: T): T

  def empty: T
}

object Monoid {
  implicit class MonoidOps[T: Monoid](l: T) {
    def |+|(r: T): T = Monoid[T].append(l, r)
  }

  def apply[T: Monoid]: Monoid[T] = implicitly[Monoid[T]]
}

object MonoidInstances {
  implicit val stringMonoid: Monoid[String] = new Monoid[String] {
    override def append(l: String, r: String): String = l.concat(r)

    override def empty: String = ""
  }

  implicit val intMonoid: Monoid[Int] = new Monoid[Int] {
    override def append(l: Int, r: Int): Int = l + r

    override def empty: Int = 0
  }
}
