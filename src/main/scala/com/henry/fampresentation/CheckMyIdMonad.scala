package com.henry.fampresentation

import com.henry.fampresentation.model.MyId

object CheckMyIdMonad {
  object MonadInstances {
    implicit val myIdMonad = new Monad[MyId] {
      override def map[A, B](fa: MyId[A])(f: A => B): MyId[B] = MyId(f(fa.t))

      override def pure[A](a: A): MyId[A] = MyId(a)

      override def flatMap[A, B](fa: MyId[A])(f: A => MyId[B]): MyId[B] = f(fa.t)
    }
  }

  def main(args: Array[String]): Unit = {
    import Monad._
    import MonadInstances._

    val i1 = Monad[MyId].pure(5)
    val i2 = Monad[MyId].pure("hello")
    val i3 = Monad[MyId].pure(false)

    println(i1.flatMap(i => MyId(i + 10)))
    println(i2.flatMap(i => MyId(i.reverse)))
    println(i3.flatMap(i => MyId(i && true)))
  }
}
