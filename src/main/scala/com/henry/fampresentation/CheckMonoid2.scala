package com.henry.fampresentation

object CheckMonoid2 {
  def main(args: Array[String]): Unit = {
    import MonoidInstances._

    val strList = List("Foo-", "Bar-", "Boo-", "Bee-")
    println(collapse(strList))

    val intList = List(1, 2, 3, 4)
    println(collapse(intList))
  }

  def collapse[T: Monoid](list: List[T]): T = list.foldLeft(Monoid[T].empty)(Monoid[T].append)
}
