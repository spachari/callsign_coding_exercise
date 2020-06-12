package com.callsign.coding.exercise.utils

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File

import javafx.scene.Scene
import javafx.scene.image.{Image, ImageView}
import javax.imageio.ImageIO

import scala.util.{Failure, Random, Success, Try}

class ImageUtils {

  def transformImage(img: BufferedImage): BufferedImage = {

    val w = img.getWidth
    val h = img.getHeight

    val out = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB)

    for (x <- 0 until w) {
      if (x <= w / 2) {
        for (y <- 0 until h) {
          val randomNumber = Random.nextInt(3)
          val c = new Color(img.getRGB(x, y))
          val alteredRed = (c.getRed + randomNumber) min 255
          val alteredBlue = (c.getBlue + randomNumber) min 255
          val alteredGreen = (c.getGreen + randomNumber) min 255
          Try {
            new Color(alteredRed, alteredBlue, alteredGreen)
          } match {
            case Success(_) => out.setRGB(x, y, new Color(alteredRed, alteredBlue, alteredGreen).getRGB)
            case Failure(exception) => throw new RuntimeException(s"$alteredBlue + $alteredGreen + $alteredRed ... $exception")
          }
        }
      }
      else {
        for (y <- 0 until h)
          out.setRGB(x, y, img.getRGB(x, y))
      }
    }
    out
  }
}