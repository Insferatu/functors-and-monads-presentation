package com.henry.fampresentation.bringiton

trait Monad[F[_]] {
  def map[A, B](fa: F[A])(f: A => B): F[B]

  def pure[A](a: A): F[A]

  def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]

  def flatten[A](ffa: F[F[A]]): F[A] = flatMap(ffa)(identity)
}

object Monad {
  def apply[F[_]](implicit m: Monad[F]): Monad[F] = m
}
