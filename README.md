# WESTERN GOVERNOR UNIVERSITY 
## D287 – JAVA FRAMEWORKS
### C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.
>Updated mainScreen to reflect my custom shop name, parts, 
> and products. In "mainscreen.html" I made changes to lines 
> **14, 19, 21, 53**.
### D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.
> Added aboutPage.html to templates and aboutPageController to controllers. 
> In about page.html changed title on line 5, added about page header and paragraph lines **12-16**,
> added button to mainscreen on line **16**. in mainscreen.html, added about shop button on line **21**.
> in about page controller, added getMapping method for aboutPage.html on lines **8-11**.
### E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.
> in bootstrap/BootStrapData added lines **45-86** to create 5 sample parts.
> also added lines **93-104** to create 5 sample products.
### F.  Add a “Buy Now” button to your product list.
> added BuyProductController to the controller package. added buyProduct.html to the templates directory.

> In mainscreen.html, I added purchase button on line **88**.

> In BuyProductController, I injected ProductService lines **13-18**. I also added method for
> decrementing product inventor and directing to buyProduct.html on lines 20-35.

> In buyProduct.html, I changed title to "Product Purchase Page"
> on line **9**. on lines **12-17** I added the message to display, as well as
> a button to go back to mainscreen.
### G.  Modify the parts to track maximum and minimum inventory.
> added fields to part entity for max and min on lines **31-32** with
> getter and setters on lines **94-108**.

> modified sample inventory in bootstrap/BootStrapData to include
> max and min field values on lines **52-53, 62-63, 72-73, 82-83, 92-93**.

> modified mainscreen.html in templates package to include max and min 
> columns in the parts table on lines **49-50**.

> Modified InhousePartForm.html in templates package to include input fields
> for min and max inventory values on lines **26-28**. I did the same for OutsourcedPartForm.html
> on lines **25-27**. also added element in both forms to display error message if inventory is 
> not between or at min and max values. In InhousePartForm the element is on line **23** and in OutSourcedPartForm,
> it is on line **24**.

> In the validators package, I added ValidInventory annotation and the constraint validator
> named InventoryConstraintValidator. In ValidInventory annotation, on line **10** I 
> specified it is to be used on class level. I also added a default message on line **15**.
> In InventoryConstraintValidator, I defined the validation logic on lines **17-24** in 
> isValid method implementation.

> In Parts class in domain package, I added @ValidInventory on line **23**.

> In application.properties, I renamed the file the presistent storage is saved to on line **6**.
### H.  Add validation for between or at the maximum and minimum fields.
> In EnufPartsValidator in validators package, I added logic to isvalid method to return false if
> part inventory drops below minimum. the change is on lines **37-42**.

>In InventoryConstraintValidator in validators package, I added log to isValid method for displaying different
> error messages depending on whether the inventory is above maximum or below minimum values. the change is on
> lines **23-30**.
### I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.
> added unit test to PartTest class in the test package for setting maximum field on lines
> **104-111**.

>added unit test to PartTest class in teh test package for setting minimum field on lines
> **113-120**.
### J.  Remove the class files for any unused validators in order to clean your code.
> removed DeletePartValidator from the validators package.