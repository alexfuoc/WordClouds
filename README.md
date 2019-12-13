# Word Cloud Project
Assignment 3 and 4 for CISC 3130- Data Structures. 

## [Assignment 3 Objective- Word Frequencies](https://github.com/alexfuoc/WordCounterApp)

Analyze a song for the frequency of word used by song utlizing different data structures.

## Assignment 4- Word Cloud Visualization website

Expanded from Assignment 3, creates a visualization of the output.

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
I created the word cloud through uploading the lyric files used in assignment 3. I did **NOT** use the output from assignment 3 because the FrequencyFileAnalyzer class was not available in the repository anymore. There is not a catch for stopwords or for punctuation now. This would be something to fix next implementaion. *There was issues that it counted the frequency number as a word sometimes so it would should 1, or 32 as a word for example. It was formatted correctly so I do not know why it did that. After using the correct class of frequencyAnalyzer and using the not analyzed text file I got the correct output*

*i.e Word Cloud for NASA*
```java
wordFrequencies = frequencyAnalyzer.load("src\\thank u, next\\NASA.txt");
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

To present the word cloud visualizations, I used GitHub pages to host the [website](https://alexfuoc.github.io/WordClouds/). Building it with HTML and CSS. 

#### HTML

* Video 
  
  Added a tiktok featuring the song boyfriend by social house ft Ariana Grande. Had to link from a google drive because github did not support that high quality of videos.
  ```html
  <video controls autoplay preload>
    <source src="https://drive.google.com/uc?export=download&id=18ToEUNSxx8XOjpFUsBX1eeSfhpeQr8QE" type ="video/mp4">
    Your browser does not support HTML5 video.
  </video>
  ```
  
* Song Links to Word Clouds 
  
  Added links to the location on the page of each tracks word cloud. 
  
  *Listed and linked the songs*
  ```html
  <a href="#imagine"> 1. imagine</a><br>
  ```
  
  *Put the songs and word clouds in track order*
  ```html
  <div id="imagine">
   <h4>imagine</h4>
   <img src="src\word clouds\wordcloud_imagine.png" 
        alt="imagine word cloud visualization">
  </div>
  ```
  
#### CSS

* Header 
  
  Used to have the header continue to stay at the top when scrolling
  ```css
  header {
   color: white;
   text-align: center;
   background-color: rgba(180, 180, 180, 0.9);
   position: -webkit-sticky;
   position: sticky;
   top: 0;
  }
  ```
* Background
  
   Used the thank u, next album artwork as a background, having it automatically repeat horizontally and vertically.
  ```css
  body {
   background-image: url("TUNbackground.png");
   color: white;
  }
  ```
  
* Links

  Specified link changes based on the state, of visited or hovered or active.
  ```css
  a:link {
   text-decoration: none;
   color: white;
  }
  a:visited {
   text-decoration: none;
   color: purple;
  }
  a:hover {
   text-decoration: underline;
   color: pink;
  }
  ```
