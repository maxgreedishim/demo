package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.swing.*;
import java.awt.*;
import java.io.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton button1 = new JButton("Считать из файла");
		button1.addActionListener(e -> {
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/max/Desktop/text.txt")));
				JTextArea textArea = new JTextArea();
				String line;
					while ((line = in.readLine()) != null) {
						textArea.append(line);
					}
				frame.getContentPane().removeAll();
				frame.getContentPane().add(BorderLayout.NORTH, button1);
				frame.setSize(300, 300);
				frame.add(textArea);
				frame.setVisible(true);

			} catch (IOException exception) {
					exception.printStackTrace();
				}
		});
		frame.getContentPane().add(BorderLayout.NORTH, button1);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}
