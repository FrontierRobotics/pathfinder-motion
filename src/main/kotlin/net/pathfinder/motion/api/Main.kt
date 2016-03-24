package net.pathfinder.motion.api

import com.pi4j.io.i2c.I2CBus
import com.pi4j.io.i2c.I2CDevice
import com.pi4j.io.i2c.I2CFactory

fun main(args: Array<String>) {
    println("Motion!")

    val bus = I2CFactory.getInstance(I2CBus.BUS_1)
    println("Connected to bus")

    val arduino = bus.getDevice(0x08)
    println("Connected to device")

    sendAndReceive(arduino, 0x02)
}

fun sendAndReceive(device: I2CDevice, command: Byte) {
    device.write(command)
    Thread.sleep(500)

    printResult(command, device.read().toByte());
}

fun printResult(sent: Byte, received: Byte) {
    println("Sent 0x${asHex(sent)}, got 0x${asHex(received)}")
}

fun asHex(value: Byte) = String.format("%02X", value);