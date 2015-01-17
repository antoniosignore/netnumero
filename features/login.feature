Feature: Netnumero login
	In order to use netnumero
	As a registered user
	I want to see my company data on netnumero

	Scenario: Netnumero login for registered user with correct password
		Given that I am on the Netnumero login page
		When I insert "danidacila@gmail.com" into "Email Address"
			And I insert "par0la" into "Password"
			And I click the "Login" button
		Then I should be redirected to "/company/danieldacila#dashboard"
			And I should see "Dashboard"

	Scenario: Netnumero login denied to registered user with incorrect password
		Given that I am on the Netnumero login page
		When I insert "danidacila@gmail.com" into "Email Address"
			And I insert "wrongpassword" into "Password"
			And I click the "Login" button
		Then I should be redirected to "account/login/"
			And I should see "Invalid"
