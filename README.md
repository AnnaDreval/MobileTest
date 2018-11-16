> 1.Rewrite (complete) Driver using “singleton” pattern. Are there any advantages?

Using of "Singleton" pattern means that we will have only one driver object. And more we do not need.

> 2.Suggest improvements for .properties reading. What are the purposes?

2.1. Using of .property file reduces the chance of an error and provides us an easier way to change capabilities;
2.2. It helps us to avoid hardcoding;
2.3. We can separate web and native tests.

> 3.Add checks of other fields and their titles in “native” test.

I have added checks for Target Account, Contact Name and Contact phone.

> 5.Which checks would you place in the “web” test?
> Implement checks for “web” test in code and try to use.

To my mind first things that we should check in "web" tests are URL of the page and it's title.
So I have implemented them.