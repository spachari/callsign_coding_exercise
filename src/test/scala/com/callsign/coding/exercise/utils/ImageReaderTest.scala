package com.callsign.coding.exercise.utils

import java.awt.Color
import java.awt.image.BufferedImage

import org.scalatest.flatspec.AnyFlatSpec

import scala.collection.immutable.Stack

class ImageReaderTest extends AnyFlatSpec {

  val img = new BufferedImage(40, 40, BufferedImage.TYPE_INT_RGB)
  val r = 10
  val g = 15
  val b = 18
  val col = (r << 16) | (g << 8) | b
  img.setRGB(10, 10, col)
  img.setRGB(30, 30, col)

  val imageUtils = new ImageUtils()
  "transformImage" should " transform a pixel present in the first half of the image" in {
    val transformedImage = imageUtils.transformImage(img)
    val transImageColor = new Color(transformedImage.getRGB(10,10))

    assert(10 to 13 contains(transImageColor.getRed))
    assert(18 to 24 contains(transImageColor.getGreen))
    assert(14 to 17 contains(transImageColor.getBlue))

  }

  "transformImage" should " not transform a pixel present in the first half of the image" in {
    val transformedImage = imageUtils.transformImage(img)
    val transImageColor = new Color(transformedImage.getRGB(30,30))

    assert(transImageColor.getRed == 10)
    assert( transImageColor.getGreen == 15)
    assert(transImageColor.getBlue == 18)

  }

}
