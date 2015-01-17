Feature: Netnumero client management
	As a logged user
	I am able to create a new client and delete it

	Scenario: New client
		Given I go to "http://netnumero.appspot.com/company/mycompany#client"
		And I should see "New Client"

		When I insert "Norby Tel ltd" into "Organisation name"
		And I insert "GB1234567" into "VAT number"
		And I insert "info@norby.com" into "Email"
		And I insert "1234567" into "Phone"
		And I insert "Test notes" into "Internal notes"

		And I click the "Address" header
		And I insert "Chruch street 21" into "Address"
		And I insert "GB36342" into "Zip Code"
		And I insert "London" into "City"
		And I select "United Kingdom" for "Country"

		And I click the "Contact information" header
		And I insert "John Doe" into "Name"
		And I insert "john@norby.com" into "company.contact.email"
		And I insert "3054522345" into "company.contact.mobile"

		And I click the "Save" button

		Then I should be redirected to "#clients"
		And I should see "Norby Tel ltd"

	Scenario: Delete client
#		Given I go to "http://netnumero.appspot.com/company/mycompany#clients"
		Given I should see "Manage Clients"

		When I check "Norby Tel ltd" in the table
		And I click "Delete Clients" from the Bulk Actions
		And I wait 2s
		And I should not see "Norby Tel ltd"
