TP3 – Questions (a) to (e)

(a) What does "left to right direction" change? What does the arrow of "Customer --> Withdraw" mean, and which notation does Chapter 3 use?

- "left to right direction" makes the diagram go from left to right instead of top to bottom.
- "Customer --> Withdraw" adds an arrow showing the direction (navigability) of the association.
- Chapter 3 uses associations without arrowheads (solid lines).

(b) Did the tool detect the reversed "extend" relationship of Part B? What does a modeling tool check, and what does it not check?

- No, the tool did not detect the reversed relationship.
- A modeling tool checks the syntax and generates the diagram.
- It does not check if the diagram is logically correct.

(c) Give two advantages and two drawbacks of the automatic layout of PlantUML.

Advantages:

- It saves time.
- It automatically organizes the diagram.

Drawbacks:

- The layout may not look exactly as we want.
- Large diagrams can become difficult to read.

(d) Compare a text-based tool such as PlantUML with a graphical tool such as Modelio: editing, layout, version control, consistency between diagrams.

- Editing: PlantUML uses text, while Modelio uses graphical elements.
- Layout: PlantUML automatically arranges diagrams, while Modelio allows more manual control.
- Version control: PlantUML is easier to track with Git because it uses text files.
- Consistency: PlantUML makes it easier to keep diagrams consistent by editing the text, while graphical tools may require more manual changes.

(e) Why is it useful to keep the models in the same repository as the code?

- Code and diagrams are kept together.
- Git tracks changes to both.
- Developers can understand the system design.
- Older versions can be restored.
- Documentation is easier to maintain.