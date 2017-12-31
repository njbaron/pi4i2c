package com.devknight.pi4i2c;

import com.devknight.pi4i2c.mpu6050.mpu6050;

public class executable {

    public static void main(String[] args) {
        System.out.println("Welcome to JavaI2C");
        try {
            while (true) {
                mpu6050 mpu = new mpu6050((byte) 0x69);
                System.out.println("MPU Temp: " + mpu.get_temp());
                double[] accelData = mpu.get_accel_data();
                System.out.println("MPU Accel x: " + accelData[0]);
                System.out.println("MPU Accel y: " + accelData[1]);
                System.out.println("MPU Accel z: " + accelData[2]);
                double[] gyroData = mpu.get_gyro_data();
                System.out.println("MPU Gyro x: " + gyroData[0]);
                System.out.println("MPU Gyro y: " + gyroData[1]);
                System.out.println("MPU Gyro z: " + gyroData[2]);
            }
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
