package io.zerotomastery.day5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


/**
 * AOC Day5
 * Binary Boarding
 * 
 * @author Nisanth Variyath
 * @version 12/05/2020
 */

public class BinaryBoarding {

	public static void main(String[] args) {
		long startTime = System.nanoTime();

		// PART ONE BEGINS HERE
		double high = 127;
		double low = 0;
		double sum;
		double row = 0, column = 0;
		ArrayList<Integer> seatId = new ArrayList<>();

		try {
			BufferedReader br = new BufferedReader(new FileReader("src\\io\\zerotomastery\\day5\\input.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				high = 127;
				low = 0;
				sum = 0;

				for (int i = 0; i < 7; i++) {
					switch (line.charAt(i)) {
					case 'F':
						sum = (high + low) / 2.0;
						high = Math.floor(sum);

						break;
					case 'B':
						sum = (high + low) / 2.0;
						;
						low = Math.ceil(sum);
						break;
					}

					if (String.valueOf(line.charAt(6)).equals("F")) {
						row = low;

					}
					if (String.valueOf(line.charAt(6)).equals("B")) {
						row = high;

					}

				}

				// System.out.println("Row = " + (int)row);

				low = 0;
				high = 7;
				for (int i = 7; i < 10; i++) {
					switch (line.charAt(i)) {
					case 'R':
						sum = (high + low) / 2.0;
						low = Math.ceil(sum);

						break;
					case 'L':
						sum = (high + low) / 2.0;
						;

						high = Math.floor(sum);
						break;
					}

					if (String.valueOf(line.charAt(9)).equals("R")) {
						column = high;

					}
					if (String.valueOf(line.charAt(9)).equals("L")) {
						column = low;
					}

				}

				seatId.add((int) ((row * 8) + column));

			}

			// System.out.println(seatId);
			Collections.sort(seatId);
			// System.out.println(seatId);

			System.out.println(" The highest seat ID on a boarding pass = " + seatId.get(seatId.size() - 1));

			// PART TWO BEGINS HERE

			int sumOfSeatId = 0;
			int sumOfTotalSeatId = 0;
			int mySeatID = 0;
			for (int index = 0; index < seatId.size(); index++) {

				sumOfSeatId += seatId.get(index);
			}
			// System.out.println(" sumOfSeatId = " + sumOfSeatId);

			for (int index = seatId.get(0); index <= seatId.get(seatId.size() - 1); index++) {
				sumOfTotalSeatId += index;
				// System.out.println(" index = " + index +" sumOfTotalSeatId =
				// "+sumOfTotalSeatId );
			}
			// System.out.println(" sumOfTotalSeatId = " + sumOfTotalSeatId);

			mySeatID = sumOfTotalSeatId - sumOfSeatId;

			System.out.println(" I found my seat! It's number : " + mySeatID);

			br.close();

			// calculate execution time
			long endTime = System.nanoTime();
			long duration = (endTime - startTime);
			System.out.println();
			System.out.println("Execution time in nanoseconds  : " + duration);
			System.out.println("Execution time in milliseconds : " + duration / 1000000);

		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		} catch (IOException e) {
			System.out.println("IOException");
		}

	}

}
