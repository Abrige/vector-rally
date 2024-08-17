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

package it.unicam.cs.vectorrally.engine;

import it.unicam.cs.vectorrally.agents.Agent;
import it.unicam.cs.vectorrally.exceptions.TooManyPlayers;
import it.unicam.cs.vectorrally.track.Track;

public class GameEngine {
    private final Track track;
    private final Agent[] agents;
    private boolean playing = true;

    public GameEngine(Track track, Agent[] agents) throws TooManyPlayers {
        this.track = track;
        this.agents = agents;
        setPlayersOnTrack();
    }

    private void setPlayersOnTrack() throws TooManyPlayers {
        // TODO implement later, this method has to put all agents on the track start line
        for (Agent agent : agents) {
            track.addAgent(agent);
        }
    }

    public void run() {
        // TODO implement later
        while(playing){
            // TODO implement later
            // ask each player for a move
            // check if the move is valid
            // move players
            // check for crash
            // print track
            // update playing value
        }
    }
}
