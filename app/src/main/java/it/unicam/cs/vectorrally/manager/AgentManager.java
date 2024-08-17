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

import it.unicam.cs.vectorrally.agents.Agent;
import it.unicam.cs.vectorrally.agents.Bot;
import it.unicam.cs.vectorrally.agents.Player;
import it.unicam.cs.vectorrally.exceptions.IllegalPlayerType;

import java.io.File;
import java.util.Scanner;

public class AgentManager implements Manager<Agent[]> {
    private String pathToAgents;

    public AgentManager(String pathToAgents) {
        this.pathToAgents = pathToAgents;
    }

    public Agent[] load() {
        try {
            File myFile = new File(this.pathToAgents);
            Scanner myReader = new Scanner(myFile);
            int rows = Integer.parseInt(myReader.nextLine());

            Agent[] agents = new Agent[rows];
            for (int i = 0; i < rows; i++) {
                String line = myReader.nextLine().toLowerCase();
                String[] components = line.split(" ");
                if (components[0].equals("bot")){
                    agents[i] = new Bot(components[1]);
                } else if (components[0].equals("player")) {
                    agents[i] = new Player(components[1]);
                } else {
                    throw new IllegalPlayerType(components[0]);
                }
            }
            myReader.close();
            return agents;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
