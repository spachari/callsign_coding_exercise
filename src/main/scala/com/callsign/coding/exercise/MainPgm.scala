package com.callsign.coding.exercise
import java.io.File

import com.callsign.coding.exercise.config.AppConfig
import com.callsign.coding.exercise.utils.ImageUtils
import javax.imageio
import javax.imageio.{ImageIO, ImageReader}

object MainPgm {

  def transformImage(outputLocation : String) = {
    val image = ImageIO.read(getClass().getClassLoader().getResource(AppConfig.appConfig.imageName))

    val photo2 = new ImageUtils().transformImage(image)

    ImageIO.write(photo2, "jpg", new File(outputLocation))
  }

  def main(args: Array[String]): Unit = {

    args.length match {
      case 0 => throw new RuntimeException("Please provide a location to create the image including file name like /tmp/test.jpg")
      case _ => transformImage(args(0))
    }

  }

}
