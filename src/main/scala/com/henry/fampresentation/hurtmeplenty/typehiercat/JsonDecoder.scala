package com.henry.fampresentation.hurtmeplenty.typehiercat

trait JsonDecoder[+T] {
  def decode(json: String): T
}
