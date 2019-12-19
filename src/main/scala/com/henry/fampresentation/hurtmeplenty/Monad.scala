package com.henry.fampresentation.hurtmeplenty

trait Monad[F[_]] {
  def map[A, B](fa: F[A])(f: A => B): F[B]

  def pure[A](a: A): F[A]

  def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]

  def flatten[A](ffa: F[F[A]]): F[A] = flatMap(ffa)(identity)
}

object Monad {
  implicit class MonadOps[F[_]: Monad, A](fa: F[A]) {
    def map[B](f: A => B): F[B] = Monad[F].map(fa)(f)

    def flatMap[B](f: A => F[B]): F[B] = Monad[F].flatMap(fa)(f)
  }

  def apply[F[_]: Monad]: Monad[F] = implicitly[Monad[F]]
}
