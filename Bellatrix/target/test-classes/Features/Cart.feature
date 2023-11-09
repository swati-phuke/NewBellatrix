Feature: Cart Page Fuctionality
Scenario: To verify if click on add to cart Btn then display view cart Btn
Given Search product in search box
When Click on add to cart btn1
Then View cart btn successfully displayed

@Regression
Scenario: To verify click on add to cart btn related product should be display in cart
Given Search the product in search box
When Click on add to cart btn
And Click on View cart btn
Then Product should display in cart

Scenario: To verify click on add to cart btn related product quantity should be display in Cart
Given Search product1 in search box
When Click on add to cart button
And Click on View cart btn
Then Product quantity should display in cart

Scenario: To verify product subtotal should be display in Cart 
Given Search Product in searchbox
When Click on add to cart button2
And Click on View cart btn
Then Product subtotal should display in cart

Scenario: To verify final value of all products in CartTotal.
Given Get value of subtotal and vat
When  Add subtotal and vat
And Compare subtotal + vat with total
Then Subtotal and vat should equal with Total



