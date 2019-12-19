package com.henry.fampresentation.bringiton

import com.henry.fampresentation.hurtmeplenty.model.MyId

object CheckMyIdFunctor {
  object FunctorInstances {
    implicit val myIdFunctor = new Functor[MyId] {
      override def map[A, B](fa: MyId[A])(f: A => B): MyId[B] = MyId(f(fa.t))
    }
  }

  def main(args: Array[String]): Unit = {
    import FunctorInstances._

    val i1 = MyId(5)
    val i2 = MyId("hello")
    val i3 = MyId(false)

    println(Functor[MyId].map(i1)(_ + 10))
    println(Functor[MyId].map(i2)(_.reverse))
    println(Functor[MyId].map(i3)(_ && true))
  }
}
