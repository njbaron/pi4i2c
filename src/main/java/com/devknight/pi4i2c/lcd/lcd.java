package com.devknight.pi4i2c.lcd;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;

public class lcd{

    //Constants
    private I2CBus i2cBus;
    private I2CDevice device;

    //Commands
    private static byte LCD_CLEARDISPLAY = 0x01;
    private static byte LCD_RETURNHOME = 0x02;
    private static byte LCD_ENTRYMODESET = 0x04;
    private static byte LCD_DISPLAYCONTROL = 0x08;
    private static byte LCD_CURSORSHIFT = 0x10;
    private static byte LCD_FUNCTIONSET = 0x20;
    private static byte LCD_SETCGRAMADDR = 0x40;
    private static int LCD_SETDDRAMADDR = 0x80;

    //Flags for display entry mode
    private static byte LCD_ENTRYRIGHT = 0x00;
    private static byte LCD_ENTRYLEFT = 0x02;
    private static byte LCD_ENTRYSHIFTINCREMENT = 0x01;
    private static byte LCD_ENTRYSHIFTDECREMENT = 0x00;

    //Flags for display on/off control
    private static byte LCD_DISPLAYON = 0x04;
    private static byte LCD_DISPLAYOFF = 0x00;
    private static byte LCD_CURSORON = 0x02;
    private static byte LCD_CURSOROFF = 0x00;
    private static byte LCD_BLINKON = 0x01;
    private static byte LCD_BLINKOFF = 0x00;

    //Flags for display/cursor shift
    private static byte LCD_DISPLAYMOVE = 0x08;
    private static byte LCD_CURSORMOVE = 0x00;
    private static byte  LCD_MOVERIGHT = 0x04;
    private static byte LCD_MOVELEFT = 0x00;

    //Flags for function set
    private static byte LCD_8BITMODE = 0x10;
    private static byte LCD_4BITMODE = 0x00;
    private static byte LCD_2LINE = 0x08;
    private static byte LCD_1LINE = 0x00;
    private static byte LCD_5x10DOTS = 0x04;
    private static byte LCD_5x8DOTS = 0x00;

    //Flags for backlight control
    private static byte LCD_BACKLIGHT = 0x08;
    private static byte LCD_NOBACKLIGHT = 0x00;

    private static byte En = 0x04; //Enable bit
    private static byte Rw = 0x02; //Read/Write bit
    private static byte Rs = 0x01; //Register select bit

    public lcd(byte address) throws Exception{
        this.init(address, 1);
    }

    public lcd(byte address, int busNo) throws Exception{
        this.init(address, busNo);
    }

    private void init(byte address, int busNo) throws Exception{
        this.i2cBus = I2CFactory.getInstance(busNo);
        this.device = i2cBus.getDevice(address);


    }
}
