/*
 * MIT License
 *
 * Copyright (c) 2024 Mattia Brizi
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package it.unicam.cs.vectorrally.manager;

import it.unicam.cs.vectorrally.track.Track;
import it.unicam.cs.vectorrally.track.TrackTile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TrackManager implements Manager<Track> {
    private final String pathToTrack;

    public TrackManager(String pathToTrack) {
        this.pathToTrack = pathToTrack;
    }

    public Track load() {
        try {
            File myFile = new File(this.pathToTrack);
            Scanner myReader = new Scanner(myFile);
            int rows = Integer.parseInt(myReader.nextLine());
            int columns = Integer.parseInt(myReader.nextLine());

            TrackTile[][] track = new TrackTile[rows][columns];
            for (int i = 0; i < rows; i++) {
                String line = myReader.nextLine().toLowerCase();
                for (int j = 0; j < columns; j++) {
                    track[i][j] = TrackTile.valueOf(line.charAt(j));
                }
            }
            myReader.close();
            return new Track(track);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
