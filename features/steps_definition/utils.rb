require 'rspec'
require 'watir-webdriver'
require "watir-webdriver/extensions/wait"


BROWSER = Watir::Browser.new(:firefox)


def locate_form_label_td(label, item_right_of_label = true, owner_id = nil)
    ret = nil
    owner = BROWSER
    if owner_id != nil
        if BROWSER.element_by_xpath(:id => owner_id).exists?
            owner = BROWSER.element_by_xpath(:id => owner_id)
        end
    end

    form_label_tds = owner.tds(:class, "form-item-label").to_a + owner.tds(:class, "form-item-label-top").to_a

    form_label_tds.each do |form_label_td|
        #puts form_label_td.text + " id: " + form_label_td.attribute_value("id")
        if form_label_td.text.include?(label)
            tr = form_label_td.parent
            index = 0
            tr.cells.each do |form_td|
                if form_label_td.text == form_td.text
                    if item_right_of_label == true
                        form_item_td = tr[index + 1]
                    else
                        form_item_td = tr[index - 1]
                    end
                    #puts form_item_td.text + " id: " + form_item_td.attribute_value("id")
                    if form_item_td.attribute_value("class") == "formItem"
                        ret = form_item_td
                    end
                    break
                end
                index = index + 1
            end
            break
        end
    end

    if ret == nil
        puts "Can't find TD for label '#{label}'"
    end
    return ret
end

def locate_form_text_field(label, item_right_of_label = true)
    ret = nil
    if BROWSER.text_field(:title, label).exists?
        ret = BROWSER.text_field(:title, label)
    elsif BROWSER.text_field(:id, label).exists?
        ret = BROWSER.text_field(:id, label)
    elsif BROWSER.text_field(:name, label).exists?
        ret = BROWSER.text_field(:name, label)
    else
        form_item_td = locate_form_label_td(label, item_right_of_label)
        if form_item_td != nil
            if form_item_td.text_fields.length > 0
                ret = form_item_td.text_fields[0]
            elsif form_item_td.textareas.length > 0
                ret = form_item_td.textareas[0]
            end
        end
    end

    if ret == nil
        puts "Can't find text_field for label '#{label}'"
    end
    return ret
end

def locate_form_select(label, item_right_of_label = true)
    ret = nil
    if BROWSER.select_list(:id, label).exists?
        ret = BROWSER.select_list(:id, label)
    elsif BROWSER.select_list(:name, label).exists?
        ret = BROWSER.select_list(:name, label)
    else
        form_item_td = locate_form_label_td(label, item_right_of_label)
        if form_item_td != nil
            if form_item_td.select_lists.length > 0
                ret = form_item_td.select_lists[0]
            end
        end
    end

    if ret == nil
        puts "Can't find select_list for label '#{label}'"
    end
    return ret
end

def locate_form_checkbox(label, item_right_of_label = true)
    ret = nil
    if BROWSER.checkbox(:id, label).exists?
        ret = BROWSER.checkbox(:id, label)
    elsif BROWSER.checkbox(:name, label).exists?
        ret = BROWSER.checkbox(:name, label)
    else
        form_item_td = locate_form_label_td(label, item_right_of_label)
        if form_item_td != nil
            if form_item_td.checkboxes.length > 0
                ret = form_item_td.checkboxes[0]
            end
        end
    end

    if ret == nil
        puts "Can't find checkbox for label '#{label}'"
    end
    return ret
end


Given /^I go to "([^"]*)"$/ do |url|
    if BROWSER.url == url
        BROWSER.refresh
    else  
        BROWSER.goto(url)
    end
    sleep 1
end

When /^I insert "([^"]*)" into "([^"]*)"$/ do |value, label|
    el = locate_form_text_field(label)
	  el.set(value)
end

When /^I (check|uncheck) "([^"]*)"$/ do |value, label|
    el = locate_form_checkbox(label, false)
    if value == "check"
        el.set
    else
        el.clear
    end        
end

When /^I select "([^"]*)" for "([^"]*)"$/ do |value, label|
    el = locate_form_select(label)
	  el.select(value)
end

When /^I click the "([^"]*)" header$/ do |title|
	  BROWSER.a(:class => "header", :text => title).click
end


When /^I click the "([^"]*)" button$/ do |title|
    btn = nil
	  if BROWSER.button(:title => title).exists?
  	    btn = BROWSER.button(:title => title)
	  elsif BROWSER.a(:class => "netnumero-button", :text => title).exists?
  	    btn = BROWSER.a(:class => "netnumero-button", :text => title)
	  end
	  btn.should_not == nil
	  btn.click
end



When /^I check "([^"]*)" in the table$/ do |label|
    form_label_td = BROWSER.td(:text => label)
    form_check_td = form_label_td.parent[0]
    if form_check_td.checkboxes.length > 0
        form_check_td.checkboxes[0].set
    end
end

When /^I click "([^"]*)" from the Bulk Actions$/ do |label|
    ba_td = BROWSER.td(:text => "Bulk Actions")
    puts ba_td.text + " id: " + ba_td.attribute_value("id")
    ba_td.click
#    popup_td = BROWSER.td(:class => "menuPopupMiddleCenter")
#    item_td = popup_td.td(:text => label)
#    item_td.click
end

Then /^I should be redirected to "([^"]*)"$/ do |url|
    Watir::Wait.until {BROWSER.url.include?(url)}
end

Then /^I should (see|not see) "([^"]*)"$/ do |see, msg|
    Watir::Wait.until { (see == "see" ? (BROWSER.text.include?(msg) or BROWSER.element_by_xpath("//cufon[contains(@alt, '#{msg}')]").exists?) : (not BROWSER.text.include?(msg) and not BROWSER.element_by_xpath("//cufon[contains(@alt, '#{msg}')]").exists?)) }
end

Then /^I wait "([^"]*)"$/ do |seconds|
    sleep seconds.to_f
end

