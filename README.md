# Mobile-Draw_Android
It is a very limited paint-like drawing App for Android. This simple application only allows the user to draw rectangles and ovals.

![mobile_draw](https://user-images.githubusercontent.com/20994167/38659936-5ebb6154-3de0-11e8-81bb-2718eff3bdf1.jpg)

- The application can be in one of four modes: Select, Rect, Oval, and Erase. Select allows the user to select a pre-existing shape.
Rect allows the user to create a new rectangle. Oval allows creation of new Ovals. Erase allows the user to remove shapes.

- The application starts in Rect mode.

- Shapes will be drawn using a red outline of width 5.0f, unless they are the currently selected shape, in which case they will 
have a blue outline with width 15.0f. They will all be filled in with white. Android canvas painting either allows the outlining 
of a shape, or the filling of a shape, it will only do both at the same time if the fill color and stroke color are the same. 
So to create an outlined and filled shape where the outline is a different color from the filling, you’ll need to draw it twice, 
once with a Paint set to fill and once with a Paint set for just strokes.

- When the application is in Rect or Oval mode, the user can create new shapes by pressing down on one corner of their future shape,
dragging across the screen, and then releasing, thus defining a diagonal line which specifies two opposing corners of the shape. 
This works for any two diagonally opposite corners, for example dragging from bottom-left to top-right works just 
as well as top-left to bottom-right.

- The newly created shape will appear on top of all the other shapes. To keep things simple, there is no way to re-order the shapes, 
so newer shapes will always appear on top of older ones.

- In Select mode, if the user taps on a shape, that shape becomes the current selection. If the user taps in the drawing area somewhere 
other than on top of a shape, the selection is cleared (leaving no selection). Taps on the tool selection radio buttons or the 
information text fields below the drawing area don’t have any impact on the selection.

- The mechanism used to determine selection takes into account the drawing order – that is to say if two shapes overlap and the user taps in the intersecting area, the one that is drawn on top of the other is the one selected.
- To keep things simple, oval is selected if the user taps anywhere within the rectangular area defining the oval (i.e., even though the corners of the bounding rectangle are technically outside of the actual oval outline, the oval will be selected if the user taps there).
- When a shape is selected, the text fields at the bottom of the window are updated to display the current selections x, y, width, and height. When there is no selection, these fields are left blank.
- The user can edit these text fields and then click on the update button, and the current selection should change to the new x and y positions and the new width and height. We don’t address the situation when the user enters an x or y or height or width that places the shape outside of the drawing area.
- The EditText inputType is “numberDecimal” so the user can only enter decimal numbers.
- When in Rect or Oval mode, when a new shape is drawn, it immediately becomes the current selection. The current mode, however, will remain in Rect or Oval. The mode will only change if the user explicitly clicks on a mode radio button.
- In Erase mode, if the user clicks on a shape it is removed. Regardless of whether or not the shape removed was the current selection, clear the current selection (leaving no selected shape).
- Data is not persistent, so the application will start with a clean drawing surface each time it is restarted.
