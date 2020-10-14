# My Personal Project

## MiniFridge

**What will this project do:**
This project will act as a virtual minifridge. However, this program does more than simply storing your ingredients. 
There are many aspects to this minifridge that will make your life easier.

This project can be used by anyone, however it specifically targets those who would like to lead a healthier lifestyle or
for those who lead a fast paced and busy lifestyle.
This project will allow you to store items in the fridge, remove item, check whether your fridge contains it, check 
the nutritional facts on an item, and generate a recipe based on an ingredient. This project will help those who would 
like to keep track of the nutrition facts in an item such as calories,fats, and sugars. This program would also help those
who are trying to learn to cook or want a recipe that contains a certain item.
This program would help everyone who is transitioning to a healthy lifestyle or who lead a fast paced and busy lifestyle 
yet would still like to cook their own meals.

##User Stories
- As a user, I want to be able to input objects in my minifridge
- As a user, I want to be able to view the items in my minifridge
- As a user, I want to view nutritional facts about an item 
- As a user, I would like to get a random recipe for an ingredient 
- As a user, I would like to remove items from the fridge
- As a user, I would like check if my fridge contains an item
- As a user, I would like to save the items in my fridge

#Instructions for Grader
You start off with a image (audiovisual component) of a fridge with an option to open the fridge. 
After you click (1st event which allow the user to generate at least two events related to those Xs- clicking a button) open fridge new display menu should show up indicating
 all the options you have to do. To get back to the display menu after any of these actions simply click the normal x button at the top right hand corner that you would use for any application.
 
-  Click add item if you would like to add an item to the fridge, Then type in the name of the item you wish to add.

- Click View items if you would like to view all the items in your fridge and the date they were added. (Loads the state of the application)

- Click Remove item if you wish to remove an item. Then type in the name of the item you would like to remove and hit
 the enter key (2nd allow the user to generate at least two events related to those Xs- hitting a key the enter button to remove an item)
 
- Click Check if the fridge contains an item then type in the name of the item you would like to check then click the button
 and it will tell you if the item is already in your fridge
 
- Click check the nutritional facts on an item to check the calories, fat, and sugars of an item. Please do not pick 
very general items such as beef because the program gives you the nutritional facts on 1 of those items so 1 beef does
 not make sense, an item that would work is an apple, orange,pear,etc. (It may take a few moments to load as the API may
 be abit slow)
 
- Click input an item for a recipe if you would like a recipe that contains it, ex. beef would give you a recipe that 
contains beef, however if you do not like this recipe just resubmit beef and it will give you another random recipe.
(It may take a few moments to load as the API may
 be abit slow)
 
 - Click save fridge if you would like to save your fridge. PLEASE REMEMBER TO CLICK SAVE BEFORE YOU CLOSE THE APPLICATION 
 TO ENSURE YOUR CHANGES ARE SAVED!

 - Click Close fridge if you would like to quit the application
 
 
 #Phase 4: Task 2
 - Task Completed : Make appropriate use of the Map interface somewhere in your code
 - There is a map implemented in the model package's Minifridge class
 
 #Phase 4: Task 3
 - One example of how I improved the cohesion of my program was breaking the httpClient class down. 
 It is currently broken into two separate classes , the NutritiomHttpRequest and the RecipeHttpRequest, this improves 
 the cohesion because those 2 classes are now doing their own well defined job instead of having to do two very different tasks that 
 did not interact or relate to each pther very much. Now they both have their own class and do their own defined job 
 instead of doing 2 different jobs in the same class. 
 - The second example of improving the cohesion in my program is in the GUI. Originally my GUI dealt with everything from 
 the opening frames to implementing all the functionality for my whole program. So it did not have much cohesion to it as 
 the one class was dealing with lots of separate functions. However, it is now broken down into 7 different classes. The GUI class
 is dealing with the opening frame and displaying the options that go on the opening frame. However, it does not deal with the
 implementation of any of these functions. All of the implementation belongs to the other 6 GUI classes. Each of the 6 GUI classes 
 each deal with their own single function whether it be adding an item, viewing an item, etc. Although this increase in classes
 may result in increased coupling, I believe that this is improved cohesion is worth it. Because this increase in cohesion
 allows you to edit code easier. You will not be searching through over 400 lines of code to edit what you would like. When you 
 do edit the code it is not necessarily going to impact the GUI class. So a change in say GUIadd may not even need you to alter the 
 GUI class. So this change in my code although it does increase the coupling the classes are fairly low coupled and a change in say GUIcheck 
  will not necessarily require a change in GUI. This change allows for a more unified purpose for each class as they all serve 1 function instead of a class having
 no true unified relationship. So I believe that having a cleaner high cohesion classes is a good trade off as the coupling between
 these classes are fairly low and it allows for edits more easily.
 
 
