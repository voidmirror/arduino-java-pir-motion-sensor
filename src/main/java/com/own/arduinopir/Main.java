package com.own.arduinopir;

import arduino.Arduino;
import com.fazecast.jSerialComm.SerialPort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Arduino arduino = new Arduino("COM4", 9600);

        boolean connection = arduino.openConnection();
        System.out.println("Установка соединения: " + connection);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        arduino.getSerialPort().getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(arduino.getSerialPort().getInputStream()));

        while (true) {
            SerialPort serial = arduino.getSerialPort();
            if (serial.bytesAvailable() > 0) {
                String input = arduino.serialRead();
                if (input.contains("1")) {
                    System.out.println("### Отправляю сигнал");
                }
            }

        }

    }

}
