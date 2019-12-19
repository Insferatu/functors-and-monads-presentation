package com.henry.fampresentation.bringiton

import com.henry.fampresentation.hurtmeplenty.model.MyList.concat
import com.henry.fampresentation.hurtmeplenty.model.{MyCons, MyList, MyNil}

object CheckMyListMonad {
  object MonadInstances {
    implicit val myListMonad = new Monad[MyList] {
      override def map[A, B](fa: MyList[A])(f: A => B): MyList[B] = fa match {
        case MyCons(h, t) => MyCons(f(h), map(t)(f))
        case MyNil => MyNil
      }

      override def pure[A](a: A): MyList[A] = MyCons(a, MyNil)

      override def flatMap[A, B](fa: MyList[A])(f: A => MyList[B]): MyList[B] = fa match {
        case MyCons(h, t) => concat(f(h), flatMap(t)(f))
        case MyNil => MyNil
      }
    }
  }

  def main(args: Array[String]): Unit = {
    import MonadInstances._

    val l1: MyList[Int] = MyCons(5, MyCons(4, MyCons(3, MyNil)))
    val l2: MyList[String] = MyCons("hello", MyCons("darkness", MyCons("my old friend", MyNil)))
    val l3: MyList[Boolean] = MyCons(true, MyCons(false, MyCons(true, MyNil)))

    println(Monad[MyList].flatMap(l1)(i => MyCons(i + 10, MyNil)))
    println(Monad[MyList].flatMap(l2)(i => MyCons(i.reverse, MyNil)))
    println(Monad[MyList].flatMap(l3)(i => MyCons(i && true, MyNil)))
  }
}
