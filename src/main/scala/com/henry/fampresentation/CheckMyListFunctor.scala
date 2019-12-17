package com.henry.fampresentation

import com.henry.fampresentation.model.{MyCons, MyList, MyNil}

object CheckMyListFunctor {
  object FunctorInstances {
    implicit val myListFunctor = new Functor[MyList] {
      override def map[A, B](fa: MyList[A])(f: A => B): MyList[B] = fa match {
        case MyCons(h, t) => MyCons(f(h), map(t)(f))
        case MyNil => MyNil
      }
    }
  }

  def main(args: Array[String]): Unit = {
    import Functor._
    import FunctorInstances._

    val l1: MyList[Int] = MyCons(5, MyCons(4, MyCons(3, MyNil)))
    val l2: MyList[String] = MyCons("hello", MyCons("darkness", MyCons("my old friend", MyNil)))
    val l3: MyList[Boolean] = MyCons(true, MyCons(false, MyCons(true, MyNil)))

    println(l1.map(_ + 10))
    println(l2.map(_.reverse))
    println(l3.map(_ && true))
  }
}
