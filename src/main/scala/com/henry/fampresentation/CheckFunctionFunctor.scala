package com.henry.fampresentation

object CheckFunctionFunctor {
  object FunctorInstances {
    implicit def readerFunctor[R]: Functor[R => *] = new Functor[R => *] {
      override def map[A, B](fa: R => A)(f: A => B): R => B = f compose fa
    }
  }

  def main(args: Array[String]): Unit = {
    import FunctorInstances._
    val f1: Int => String = i => (i + 5).toString

    val res = Functor[Int => *].map(f1)(_.reverse)

    println(res(6))
  }
}
