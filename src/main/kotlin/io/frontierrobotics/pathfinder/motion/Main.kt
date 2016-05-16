package io.frontierrobotics.pathfinder.motion

import com.pi4j.io.i2c.I2CBus
import com.pi4j.io.i2c.I2CDevice
import com.pi4j.io.i2c.I2CFactory

fun main(args: Array<String>) {
    println("Motion!")

    val bus = I2CFactory.getInstance(I2CBus.BUS_1)
    println("Connected to bus")

    val arduino = bus.getDevice(0x1A)
    println("Connected to device")

    blink(arduino)

    blink(arduino)

    readData(arduino)
}

fun blink(device: I2CDevice) {
    device.write(0x02)
}

fun readData(device: I2CDevice) {
    val buffer = byteArrayOf(0, 0, 0, 0, 0, 0)

    device.read(buffer, 0, 6)

    println(String(buffer))
}

fun printResult(sent: Byte, received: Byte) {
    println("Sent 0x${asHex(sent)}, got 0x${asHex(received)}")
}

fun asHex(value: Byte) = String.format("%02X", value);