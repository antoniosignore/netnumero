require 'rspec'
require 'watir-webdriver'
require "watir-webdriver/extensions/wait"


Before("@logged_in") do
	Given %{that I am on the Netnumero login page}
	When %{I insert "danidacila@gmail.com" into "Email Address"}
		And %{I insert "par0la" into "Password"}
		And %{I click the "Login" button}
	Then %{I should be redirected to "#dashboard"}
		And %{I should see "Dashboard"}
end


Given /^that I am on the Netnumero login page$/ do
  Given %{I go to "https://www.netnumero.com/customer/account/logout/"}
  Watir::Wait.until {BROWSER.url == "http://www.netnumero.com/" or BROWSER.url == "https://www.netnumero.com/customer/account/login/"}

  if BROWSER.url != "https://www.netnumero.com/customer/account/login/"
    Given %{I go to "https://www.netnumero.com/customer/account/login/"}
  end

  Watir::Wait.until {BROWSER.title.should include("Customer Login Online")}
  BROWSER.text_field(:id, "email").exists?.should == true
end

