# Word Cloud Project
Assignment 3 and 4 for CISC 3130- Data Structures. 

## Assignment 3 Objective- Word Frequencies [x](https://github.com/alexfuoc/WordCounterApp)
Analyze a song for the frequency of word used by song utlizing different data structures.
  
  **1. Prepare a text file that contains text to analyze.**
In this case, I have chosen to prepare the songs from the 2019 album thank u, next by Ariana Grande. 

Each song is located in the thank u, next folder within the src folder. Each individual song has a text file with the lyrics gathered from [Genius](https://genius.com/albums/Ariana-grande/Thank-u-next). The distinction of the identifiers of Verse 1, Outro, Pre-Chorus, etc removed. *This could also be done with adding them to the stopwords, adding the specific words. This would be a good addition for next implementaion.*
  
  **2. With your code, you’ll read from the text file and capture the data into a data structure.**

The constructor of the Song object accepts a String inputFile and String songTitle. The inputFile string is the location of the song File with the lyrics, which is then instaites a File object, then instantiating Scanner object. The Scanner object reads in each individual word. Every non-alphanumeric symbol was taken out and changed to lowercase

```java
while(input.hasNext()){
  String next = input.next().toLowerCase();
  next = next.replaceAll("\\p{Punct}", "");
```

  **3. Using a data structure, write the code to count the appearance of each unique word in the lyrics.**

The Song words were inputted into a HashMap<String, Integer>. The key is a String or the word, and the value was the number of times it occured. This was used for easy access to each word to increment or add to. With a O(1) there does not need to be any searching or loops, making it the best data structure. 

It was also checked for stopwords. The stopwords were put into a HashSet, read into through the stopwords.txt file, which contained the Default English Stopwords List from [ranks.nl/stopwords]. The stopwords used a HashSet only needing keys for the stopwords and allows for easy access to compare to the inputting song word. *For every Song a new stopword HashSet was created, which may be unnecessary and instead could pass the stopword HashSet into the contructor of the Song Object.*

```java
if (stopwords.contains(next)) {
} else if (!songLyrics.containsKey(next)) {
    songLyrics.put(next, 1);
    totalWords++;
} else {
    songLyrics.put(next, songLyrics.get(next) + 1);
    totalWords++;
}     
```

  **4. Print out a word frequency list.**

Printing the Frequency List is done through the method in the Song Class. Accepting the HashMap<String, Integer> of the song. It wrote to the frequencyFile.txt. Using a for loop it looped through every key in the set, printing the key with its corresponding value pair. 
  
 ```java 
public void printFrequencyFile(HashMap<String, Integer> song){
  try (PrintWriter output = new PrintWriter("frequencyFile.txt")) {
    for (String word : song.keySet()) {
      int count = song.get(word);
      output.println(count + ": " + word);
    }
  } catch (IOException e){
            e.printStackTrace();
    }
  }    
}   
 ```
 
 *i.e Output File, thank u, next*
```
42: next
38: you
37: thank
15: yeah
8: my
7: say
6: taught
```
  ### Song Class
 
 The Song Class holds data for a song, including fields HashMap<String, Integer> songLyrics, String songTitle and HashSet<String> stopwords. The methods include the constructor, Song(String inputFile, String T) to input the song, void printLyrics(HashMap<String, Integer> song) to print the lyrics to the console, and void printLyricsFile(HashMap<String, Integer> song to print the lyrics to the output file. 
  
  ### Album Class 
The Album class holds the data for the entire album, including fields int NumOfSongs, NumOfWords, andh HashMap<String, Integer> albumLyrics. The methods include the constructor, Album(Song inputSong, int songIndex) to instantiate the album, addSong(Song inputSong, int songIndex) to input the song objects lyrics into the albumLyrics HashMap<String, Integer>, void printLyricsFile(HashMap<String, Integer> album) to print the lyrics to the output file.

*The Song and Album class fields are denoted as public, this could lead to data corruption and should be assigned private and accessed with getter and setter methods OR given package access, allowing the Album class to utilize the songs fields. They are denoted public so the album class can access the Song classes fields.*

***i.e Album class inputting a Song classes songLyrics HashMap<String, Integer>***
```java
inputSong.songLyrics.keySet().forEach((String word) -> {
            if(albumLyrics.containsKey(word)){
                albumLyrics.put(word,
                        inputSong.songLyrics.get(word)+ albumLyrics.get(word));
            }else{
                albumLyrics.put(word, inputSong.songLyrics.get(word));
            }
        });

```

## Assignment 4- Word Cloud Visualization website

**1. Word Clouds - Kumo Maven Repository**

Using the Kumo repository allowed for the creation of a word cloud based on the frequency file created on the song lyrics. This allowed for easy upload of the text file to an image output. This was done using the [Kumo](https://github.com/kennycason/kumo) repository through Maven.

#### Connecting through Maven-
Using Netbeans IDE allowed for creation of a pom.xml and adding the Kumo repository seamlessly. Creating a new Maven java project allowed me to have the Kumo repositiory as a dependency. I did not need to add all of the dependencies that Kumo uses because it accessed it through the Kumo pom.xml. 

```java
 <!-- https://mvnrepository.com/artifact/com.kennycason/kumo -->
        <dependency>
            <groupId>com.kennycason</groupId>
            <artifactId>kumo</artifactId>
            <version>1.8</version>
            <type>jar</type>
        </dependency>
```

***PROBLEMS with Netbeans*** *I had to create a brand new project to access my frequency file outputs, this is because you cannot make a project have maven dependencies through netbeans AFTER you have already created it. This was a severe problem that forced me to create a second project and github repository for assignment 4. This is the link to the assignment 3- frequency file github repo [x](https://github.com/alexfuoc/WordCounterApp)*

#### Creating the Word Clouds-
I created the word cloud through uploading the frequency files created from the songs in assignment 3 to the frequency analyzer class from the Kumo repository. *There was issues that it counted the frequency number as a word sometimes so it would should 1, or 32 as a word for example. It was formatted correctly so I do not know why it did that. 

*i.e Word Cloud for NASA*
```java
wordFrequencies = frequencyAnalyzer.load("src\\thank u, next\\Output-NASA.txt");
dimension = new Dimension(450, 450);
wordCloud = new WordCloud(dimension, CollisionMode.RECTANGLE);
wordCloud.setPadding(2);
wordCloud.setBackground(new CircleBackground(225));
wordCloud.setColorPalette(new ColorPalette(new Color(0x4055F1), 
  new Color(0x408DF1), new Color(0x40AAF1), new Color(0x40C5F1)));
wordCloud.setFontScalar(new LinearFontScalar(15, 55));
wordCloud.build(wordFrequencies);
wordCloud.writeToFile("src\\word clouds\\wordcloud_nasa.png");
```
*i.e Output for NASA*

![Nasa Image](https://github.com/alexfuoc/WordClouds/blob/master/src/word%20clouds/wordcloud_nasa.png)


**2. HTML/CSS and GitHub Pages**

