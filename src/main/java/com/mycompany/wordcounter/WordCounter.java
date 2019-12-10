package com.mycompany.wordcounter;

import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.palette.ColorPalette;
import com.kennycason.kumo.bg.Background;
import com.kennycason.kumo.bg.RectangleBackground;
import com.kennycason.kumo.bg.PixelBoundryBackground;
import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.CircleBackground;
import com.kennycason.kumo.font.scale.LinearFontScalar;
import com.kennycason.kumo.font.scale.SqrtFontScalar;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WordCounter {

    public static void main(String[] args) throws IOException {
/*

        String[] inputFiles = {"src\\thank u, next\\imagine.txt", 
            "src\\thank u, next\\needy.txt", 
            "src\\thank u, next\\NASA.txt", 
            "src\\thank u, next\\bloodline.txt", 
            "src\\thank u, next\\fake smile.txt", 
            "src\\thank u, next\\bad idea.txt",
            "src\\thank u, next\\make up.txt",
            "src\\thank u, next\\ghostin.txt",
            "src\\thank u, next\\in my head.txt",
            "src\\thank u, next\\7 rings.txt",
            "src\\thank u, next\\thank u, next.txt",
            "src\\thank u, next\\break up with your girlfriend, im bored.txt"};
*/
            
            final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
            List<WordFrequency> wordFrequencies = frequencyAnalyzer.load("src\\thank u, next\\Output-bad idea.txt");
            final Dimension dimension = new Dimension(400, 400);
            final WordCloud wordCloud = new WordCloud(dimension, CollisionMode.RECTANGLE);
            wordCloud.setPadding(0);
            wordCloud.setBackground(new RectangleBackground(dimension));
            wordCloud.setColorPalette(new ColorPalette(Color.RED, Color.GREEN, Color.YELLOW, Color.BLUE));
            wordCloud.setFontScalar(new LinearFontScalar(10, 40));
            wordCloud.build(wordFrequencies);
            wordCloud.writeToFile("pic.png");
            
    }
}
