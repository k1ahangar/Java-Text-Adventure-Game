# Java-Text-Adventure-Game
# 🎓 University Text Adventure Game 🎓

Welcome to the Polish-Japanese Academy Text Adventure! This is a simple text-based Java game where you play as a student navigating the university to collect items, interact with characters, and ultimately pass the Final Exam.

## Table of Contents
* [About The Project](#about-the-project)
* [Features](#features)
* [Getting Started](#getting-started)
    * [Prerequisites](#prerequisites)
    * [Installation & Running](#installation--running)
* [Gameplay](#gameplay)
    * [Commands](#commands)
    * [Example Gameplay](#example-gameplay)
* [Project Structure](#project-structure)
    * [Key Classes](#key-classes)
* [Developer Notes](#developer-notes)
* [Future Enhancements](#future-enhancements)
* [Contributing](#contributing)
* [License](#license)

## About The Project

This console-based RPG allows players to explore different locations within the Polish-Japanese Academy, collect items, interact with non-player characters (NPCs), and overcome challenges using acquired items. The game is built with an emphasis on object-oriented design principles, utilizing custom classes such as `Location`, `Items`, `Character`, and `Student`. It's designed to be a fun, educational example of game development in Java.

## Features

*   **Dynamic World:** Explore multiple interconnected locations within the university.
*   **Inventory System:** Collect and manage items in your backpack.
*   **Item Usage:** Use items to gain benefits, unlock areas, or interact with the environment.
*   **Character Interaction:** Engage with NPCs like the `Bufet` owner or the `Exam` proctor.
*   **Goal-Oriented Gameplay:** Work towards passing the Final Exam.
*   **Restricted Access:** Certain areas (e.g., Exam Hall) require specific items (e.g., Exam Pass) to enter.
*   **Custom Interactions:** Unique messages and outcomes based on item and character interactions.
*   **Expandable Design:** Built with generics and OOP to facilitate easy expansion (new locations, items, characters, quests).

## Getting Started

Follow these instructions to get a copy of the project up and running on your local machine.

### Prerequisites

*   Java Development Kit (JDK) 8 or higher.
*   A Java IDE (e.g., IntelliJ IDEA, Eclipse, VS Code) or terminal access.

### Installation & Running

1.  **Clone the repository:**
    ```bash
    git clone <repository-url>
    ```
    (Replace `<repository-url>` with the actual URL of your GitHub repository)

2.  **Navigate to the project directory:**
    ```bash
    cd <project-directory-name>
    ```

3.  **Compile the Java files:**
    From the root of the project directory (where `Main.java` and other `.java` files are):
    ```bash
    javac Main.java
    ```
    *(This command assumes all .java files are in the same directory or your classpath is set up accordingly. If you have packages, you'll need to compile them appropriately, e.g., `javac *.java` or `javac com/example/Main.java`)*

4.  **Run the game:**
    ```bash
    java Main
    ```

## Gameplay

Navigate the university, manage your inventory, and interact with the world to achieve your goal.

### Commands

The following commands are available:

*   `look`: Shows available items, characters, and exits in your current location.
*   `inventory`: Displays the items currently in your backpack.
*   `pickup <item name>`: Adds an item from the current location to your inventory (e.g., `pickup MathBook`). *Item names are case-sensitive and should match how they are displayed.*
*   `use <item name>`: Uses an item from your inventory to gain its benefits (e.g., `use MathBook`).
*   `buy <item name>`: Purchase an item when interacting with a vendor (e.g., at the Bufet, after `pickup cake`, you might then `buy cake`).
*   `sell <item name>`: Sell an item when interacting with a vendor (e.g., at a Store, after `pickup Screen Protector`, you might then `sell Screen Protector`).
*   `move <direction>`: Moves your character to an adjacent location (e.g., `move west`, `move north`).
*   `DoExam`: Initiates the final exam sequence (only available in the Exam Hall).
*   `CheckExp`: Displays your current experience points.
*   `quit`: Exits the game.

### Example Gameplay
-look
-You see a Book on the table. There's a door to the east.
-pickup Book
-You picked up the Book.
-inventory
-You have: Book
-use Book
-You read the Book and feel a bit smarter.
-move east
-You move to the next room.

## Project Structure

The project is organized into several key Java classes that define the game's world, characters, and mechanics.

*   `Main.java`: The entry point of the game, containing the main game loop and logic.
*   `Location.java`: Represents a location in the game world (e.g., Library, Exam Hall). Uses generics (`Location<L>`).
*   `Student.java`: Represents the player character, managing inventory, experience, and current location.
*   `Items.java`: An abstract base class for all items in the game. Uses generics (`Items<N, V>`).
    *   `Equipment.java` (Inner class of `Items`): Represents usable equipment like books.
    *   `Booster.java` (Inner class of `Items`): Represents consumable items that provide boosts, like coffee.
    *   `Key.java` (Inner class of `Items`): Represents special items required to access certain areas, like an Exam Pass.
*   `Character.java`: An abstract base class for non-player characters (NPCs). Uses generics (`Character<N, V>`).
    *   `Bufet.java` (Inner class of `Character`): Represents an NPC vendor, like one selling drinks or food.
    *   `Exam.java` (Inner class of `Character`): Represents the character/entity administering the final exam.

## Developer Notes

This project was developed using object-oriented principles, with a focus on creating a flexible and extensible game structure through the use of generics and abstract classes. This design choice aims to simplify the addition of new content such as locations, items, characters, puzzles, and quests.

## Future Enhancements

Potential improvements and future features could include:
*   **GUI:** Develop a graphical or web-based user interface.
*   **Save/Load:** Implement functionality to save and load game progress.
*   **NPC Dialogue:** Implement an `interact <character>` command for more complex NPC dialogue, quests, or challenges.
*   **More Content:** Add more locations, items, characters, and puzzles.
*   **Sound/Music:** Incorporate audio elements.

## Contributing

Contributions are welcome! If you have suggestions for improvements or want to add new features:

1.  Fork the Project
2.  Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3.  Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4.  Push to the Branch (`git push origin feature/AmazingFeature`)
5.  Open a Pull Request

Please make sure to update tests as appropriate.

## License

This project is for educational purposes and is free to use and modify.
Distributed under the MIT License. See `LICENSE.txt` for more information (if you add one).

---
