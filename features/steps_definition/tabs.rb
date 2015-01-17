require 'rspec'
require 'watir-webdriver'


When /^Table at url "([^"]*)" (contains|doesn't contain)$/ do |url, contains|
  hash_index = BROWSER.url.rindex('#')
  Given %{I go to "#{BROWSER.url[0..hash_index]}#{url}"}

  BROWSER.text_field(:name, fieldName).set(value)
end

When /^I press "([^"]*)"$/ do |buttonText|
  BROWSER.link(:text, buttonText).click
end

Then /^I should see a link "([^"]*)" pointing to "([^"]*)"$/ do |linkText, linkUrl|
  Watir::Wait.until { BROWSER.div(:text, "Manage Clients").exists? }
  BROWSER.link(:href, linkUrl).text.should include(linkText)
end

