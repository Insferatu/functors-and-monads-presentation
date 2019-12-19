package com.henry.fampresentation.bringiton

trait Functor[F[_]] {
  def map[A, B](fa: F[A])(f: A => B): F[B]

  def lift[A, B](f: A => B): F[A] => F[B] = fa => map(fa)(f)
}

object Functor {
  def apply[F[_]](implicit f: Functor[F]): Functor[F] = f
}
