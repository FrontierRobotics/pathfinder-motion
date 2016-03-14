package net.pathfinder.motion.api

import com.pi4j.io.i2c.I2CBus
import com.pi4j.io.i2c.I2CFactory

fun main(args: Array<String>) {
    println("Motion!")

    val bus = I2CFactory.getInstance(I2CBus.BUS_1)
}