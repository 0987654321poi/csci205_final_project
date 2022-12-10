# CSCI 205 -Software Engineering and Design
Bucknell University  Lewisburg, PA
### Course Info
Instructor: Prof. King 

Semester: Fall

Time: 9:00am, MWF
## Team Information
### Team Name: Team 6

### Team Members:
* Jacob Piskadlo - Scrum Master
  - Class of 2025, Computer Science and Engineering major



* Gordon Rose - Product Owner
  - Class of 2025, Computer Science and Engineering major



* Alejandro Vargas - Developer
  - Class of 2025, Computer Science and Engineering and Mathematics major



* Kevin Page - Developer
  - Class of 2025, Computer Science and Engineering major

    
## Project Information
Our project is a computer solitaire game. With our project a person can play solitaire on their computer
with nice visuals making the game easy to play and follow. The game has the solitaire game logic built in meaning
we will not let the user make illegal moves. The user can move cards around by selecting the card to be moved, with
a simple mouse click, and then selecting the location they would like to move the card to, then if this was a legal
move, the card will be moved. We also have a win screen built in so that there is a nice wrap to the game if the 
user is able to win.

## Package Structure
All of our source code is in the src directory, with our test code in the /src/test/ directory and the actual project
code in /src/main/java/, in the org.team6 package. The images for our cards, fxml file for our view, and all of our
resources are in the /src/main/resources folder. In our org.team6 package, which is again where all of our actual
project code is kept, we followed the MVC design pattern. Thus, we have a package with in the org.team6 package, 
named SolitaireModel, this package contains all of our classes that help control the actual logic of a solitaire game
including classes to encapsulate a playing card, a deck of cards, the solitaire tableau, and a class named
SolitaireModel which controls all of the logic of a computer solitaire game. Then outside of the Solitaire Model 
package we have a SolitaireController class that interacts with the SolitareModel to update our view, which is created
via fxml, according to the logic of SolitaireController. Finally, we have a SolitaireMain class which sets everything up,
sets and shows our scene and stage and runs the program.

## 3rd Party Libraries
Our only third party library was JavaFX. We are using version 19. The main page to the JavaFX library is listed here:
https://docs.oracle.com/javafx/2/get_started/hello_world.htm.

## How to run it
As long as you have access to our file tree with our helper classes, running the project is rather simple. In the
org.team6 package, located in /src/main/java, simply run the main method in the class named SolitaireMain, and 
from there, a JavaFx tab should come up with our game ready to be played.

## Link to our Video:
https://mediaspace.bucknell.edu/media/CSCI205%20Team%206%20Final%20Video%202022/1_58iybvff

