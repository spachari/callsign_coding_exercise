package com.callsign.coding.exercise.config


import pureconfig.ConfigSource
import pureconfig.generic.auto._


case class Config(imageName : String)


object AppConfig {
  val appConfig = ConfigSource.resources("config/application.conf").load[Config] match {
    case Right(is) => is
    case Left(ex) => throw new RuntimeException(ex.prettyPrint())
  }
}

