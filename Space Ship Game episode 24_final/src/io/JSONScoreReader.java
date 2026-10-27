package io;

import java.util.ArrayList;

public class JSONScoreReader implements ScoreReader {
    @Override
    public ArrayList<ScoreData> readScores() throws Exception {
        return JSONParser.readFile();
    }
}

