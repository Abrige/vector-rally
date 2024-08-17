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

package it.unicam.cs.vectorrally.track;

import it.unicam.cs.vectorrally.agents.Agent;
import it.unicam.cs.vectorrally.exceptions.TooManyPlayers;

public class Track {
    private final TrackTile[][] track;

    public Track(TrackTile[][] track) {
        this.track = track;
    }

    public TrackTile getTile(int x, int y) {
        return track[x][y];
    }

    public void setTile(int x, int y, TrackTile tile) {
        // used to add obstacles or car crashes
        track[x][y] = tile;
    }

    public int getWidth() {
        return track.length;
    }

    public int getHeight() {
        return track[0].length;
    }

    public void addAgent(Agent agent) throws TooManyPlayers {
        // TODO implement later, this method has to put the agent on the track start line
        // Note: may throw exception, too many players for the start line
    }
}
