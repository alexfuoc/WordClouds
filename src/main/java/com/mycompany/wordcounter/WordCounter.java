package com.mycompany.wordcounter;

import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.palette.ColorPalette;
import com.kennycason.kumo.bg.Background;
import com.kennycason.kumo.bg.RectangleBackground;
import com.kennycason.kumo.bg.PixelBoundryBackground;
import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.bg.CircleBackground;
import com.kennycason.kumo.font.scale.LinearFontScalar;
import com.kennycason.kumo.font.scale.SqrtFontScalar;
import com.kennycason.kumo.palette.ColorPalette;
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
        frequencyAnalyzer.setWordFrequenciesToReturn(1000);
        frequencyAnalyzer.setMinWordLength(1);
        
        //7 Rings
        List<WordFrequency> wordFrequencies = frequencyAnalyzer.load("src\\thank u, next\\Output-7 rings.txt");
        Dimension dimension = new Dimension(450, 450);
        WordCloud wordCloud = new WordCloud(dimension, CollisionMode.RECTANGLE);
        wordCloud.setPadding(2);
        wordCloud.setBackground(new CircleBackground(225));
        wordCloud.setColorPalette(new ColorPalette(new Color(0x4055F1), new Color(0x408DF1), new Color(0x40AAF1), new Color(0x40C5F1)));
        wordCloud.setFontScalar(new LinearFontScalar(15, 55));
        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile("src\\word clouds\\wordcloud_7rings.png");

        //NASA
        wordFrequencies = frequencyAnalyzer.load("src\\thank u, next\\Output-NASA.txt");
        dimension = new Dimension(450, 450);
        wordCloud = new WordCloud(dimension, CollisionMode.RECTANGLE);
        wordCloud.setPadding(2);
        wordCloud.setBackground(new CircleBackground(225));
        wordCloud.setColorPalette(new ColorPalette(new Color(0x4055F1), new Color(0x408DF1), new Color(0x40AAF1), new Color(0x40C5F1)));
        wordCloud.setFontScalar(new LinearFontScalar(15, 55));
        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile("src\\word clouds\\wordcloud_nasa.png");
        
        //bad idea
        wordFrequencies = frequencyAnalyzer.load("src\\thank u, next\\Output-bad idea.txt");
        dimension = new Dimension(450, 450);
        wordCloud = new WordCloud(dimension, CollisionMode.RECTANGLE);
        wordCloud.setPadding(2);
        wordCloud.setBackground(new CircleBackground(225));
        wordCloud.setColorPalette(new ColorPalette(new Color(0x4055F1), new Color(0x408DF1), new Color(0x40AAF1), new Color(0x40C5F1)));
        wordCloud.setFontScalar(new LinearFontScalar(15, 55));
        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile("src\\word clouds\\wordcloud_badidea.png");
        
        //bloodline
        wordFrequencies = frequencyAnalyzer.load("src\\thank u, next\\Output-bloodline.txt");
        dimension = new Dimension(450, 450);
        wordCloud = new WordCloud(dimension, CollisionMode.RECTANGLE);
        wordCloud.setPadding(2);
        wordCloud.setBackground(new CircleBackground(225));
        wordCloud.setColorPalette(new ColorPalette(new Color(0x4055F1), new Color(0x408DF1), new Color(0x40AAF1), new Color(0x40C5F1)));
        wordCloud.setFontScalar(new LinearFontScalar(15, 55));
        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile("src\\word clouds\\wordcloud_bloodline.png");
        
        //break up with your girlfriend, im bored
        wordFrequencies = frequencyAnalyzer.load("src\\thank u, next\\Output-break up with your girlfriend, im bored.txt");
        dimension = new Dimension(450, 450);
        wordCloud = new WordCloud(dimension, CollisionMode.RECTANGLE);
        wordCloud.setPadding(2);
        wordCloud.setBackground(new CircleBackground(225));
        wordCloud.setColorPalette(new ColorPalette(new Color(0x4055F1), new Color(0x408DF1), new Color(0x40AAF1), new Color(0x40C5F1)));
        wordCloud.setFontScalar(new LinearFontScalar(15, 55));
        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile("src\\word clouds\\wordcloud_breakup.png");
        
        //fake smile
        wordFrequencies = frequencyAnalyzer.load("src\\thank u, next\\Output-fake smile.txt");
        dimension = new Dimension(450, 450);
        wordCloud = new WordCloud(dimension, CollisionMode.RECTANGLE);
        wordCloud.setPadding(2);
        wordCloud.setBackground(new CircleBackground(225));
        wordCloud.setColorPalette(new ColorPalette(new Color(0x4055F1), new Color(0x408DF1), new Color(0x40AAF1), new Color(0x40C5F1)));
        wordCloud.setFontScalar(new LinearFontScalar(15, 55));
        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile("src\\word clouds\\wordcloud_fakesmile.png");
        
        //ghostin
        wordFrequencies = frequencyAnalyzer.load("src\\thank u, next\\Output-ghostin.txt");
        dimension = new Dimension(450, 450);
        wordCloud = new WordCloud(dimension, CollisionMode.RECTANGLE);
        wordCloud.setPadding(2);
        wordCloud.setBackground(new CircleBackground(225));
        wordCloud.setColorPalette(new ColorPalette(new Color(0x4055F1), new Color(0x408DF1), new Color(0x40AAF1), new Color(0x40C5F1)));
        wordCloud.setFontScalar(new LinearFontScalar(15, 55));
        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile("src\\word clouds\\wordcloud_ghostin.png");
        
        //imagine
        wordFrequencies = frequencyAnalyzer.load("src\\thank u, next\\Output-imagine.txt");
        dimension = new Dimension(450, 450);
        wordCloud = new WordCloud(dimension, CollisionMode.RECTANGLE);
        wordCloud.setPadding(2);
        wordCloud.setBackground(new CircleBackground(225));
        wordCloud.setColorPalette(new ColorPalette(new Color(0x4055F1), new Color(0x408DF1), new Color(0x40AAF1), new Color(0x40C5F1)));
        wordCloud.setFontScalar(new LinearFontScalar(15, 55));
        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile("src\\word clouds\\wordcloud_imagine.png");
        
        //in my head
        wordFrequencies = frequencyAnalyzer.load("src\\thank u, next\\Output-in my head.txt");
        dimension = new Dimension(450, 450);
        wordCloud = new WordCloud(dimension, CollisionMode.RECTANGLE);
        wordCloud.setPadding(2);
        wordCloud.setBackground(new CircleBackground(225));
        wordCloud.setColorPalette(new ColorPalette(new Color(0x4055F1), new Color(0x408DF1), new Color(0x40AAF1), new Color(0x40C5F1)));
        wordCloud.setFontScalar(new LinearFontScalar(15, 55));
        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile("src\\word clouds\\wordcloud_inmyhead.png");
        
        //make up 
        wordFrequencies = frequencyAnalyzer.load("src\\thank u, next\\Output-make up.txt");
        dimension = new Dimension(450, 450);
        wordCloud = new WordCloud(dimension, CollisionMode.RECTANGLE);
        wordCloud.setPadding(2);
        wordCloud.setBackground(new CircleBackground(225));
        wordCloud.setColorPalette(new ColorPalette(new Color(0x4055F1), new Color(0x408DF1), new Color(0x40AAF1), new Color(0x40C5F1)));
        wordCloud.setFontScalar(new LinearFontScalar(15, 55));
        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile("src\\word clouds\\wordcloud_makeup.png");
        
        //needy
        wordFrequencies = frequencyAnalyzer.load("src\\thank u, next\\Output-needy.txt");
        dimension = new Dimension(450, 450);
        wordCloud = new WordCloud(dimension, CollisionMode.RECTANGLE);
        wordCloud.setPadding(2);
        wordCloud.setBackground(new CircleBackground(225));
        wordCloud.setColorPalette(new ColorPalette(new Color(0x4055F1), new Color(0x408DF1), new Color(0x40AAF1), new Color(0x40C5F1)));
        wordCloud.setFontScalar(new LinearFontScalar(15, 55));
        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile("src\\word clouds\\wordcloud_needy.png");
        
        //thank u, next
        wordFrequencies = frequencyAnalyzer.load("src\\thank u, next\\Output-thank u, next.txt");
        dimension = new Dimension(450, 450);
        wordCloud = new WordCloud(dimension, CollisionMode.RECTANGLE);
        wordCloud.setPadding(2);
        wordCloud.setBackground(new CircleBackground(225));
        wordCloud.setColorPalette(new ColorPalette(new Color(0x4055F1), new Color(0x408DF1), new Color(0x40AAF1), new Color(0x40C5F1)));
        wordCloud.setFontScalar(new LinearFontScalar(15, 55));
        wordCloud.build(wordFrequencies);
        wordCloud.writeToFile("src\\word clouds\\wordcloud_thank u, next.png");
    }

}
