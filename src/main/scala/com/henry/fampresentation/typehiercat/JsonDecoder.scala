package com.henry.fampresentation.typehiercat

trait JsonDecoder[+T] {
  def decode(json: String): T
}
