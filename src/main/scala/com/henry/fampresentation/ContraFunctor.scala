package com.henry.fampresentation

trait ContraFunctor[F[_]] {
  def contramap[A, B](fa: F[B])(f: A => B): F[A]

  def lift[A, B](f: A => B): F[B] => F[A] = fa => contramap(fa)(f)
}

object ContraFunctor {
  implicit class FunctorOps[F[_]: ContraFunctor, B](fa: F[B]) {
    def contramap[A](f: A => B): F[A] = ContraFunctor[F].contramap(fa)(f)
  }

  def apply[F[_]: ContraFunctor]: ContraFunctor[F] = implicitly[ContraFunctor[F]]
}
