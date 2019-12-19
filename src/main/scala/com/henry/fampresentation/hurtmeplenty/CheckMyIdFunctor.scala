package com.henry.fampresentation.hurtmeplenty

import com.henry.fampresentation.hurtmeplenty.model.MyId

object CheckMyIdFunctor {
  object FunctorInstances {
    implicit val myIdFunctor = new Functor[MyId] {
      override def map[A, B](fa: MyId[A])(f: A => B): MyId[B] = MyId(f(fa.t))
    }
  }

  def main(args: Array[String]): Unit = {
    import Functor._
    import FunctorInstances._

    val i1 = MyId(5)
    val i2 = MyId("hello")
    val i3 = MyId(false)

    println(i1.map(_ + 10))
    println(i2.map(_.reverse))
    println(i3.map(_ && true))
  }
}
