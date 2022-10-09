Feature: To verify cucumber functionalities

  Background:
    Given User is on Landing Page
    When User clicks on the Login link
    Then User should be navigated to Login Page



  @HappyPath
  Scenario: To verify the login functionality happy path
    When User logs in with username "sitanshupt5.sp@gmail.com" and password "Bapuna10@"
    Then User should be logged in successfully

  @ErrorPath
  Scenario: To verify the login functionality error path
    When User logs in with username "sitanshupt5.sp@gmail.com" and password "Bapuna01@"
    Then User should not be logged in successfully

  @Examples
  Scenario Outline: To add a new Contact
    When User logs in with username "sitanshupt5.sp@gmail.com" and password "Bapuna10@"
    Then User should be logged in successfully
    When User opens the contacts page
    When User clicks on the create button on contacts page
    Then User is navigated to the create contact page
    When User adds firstName "<firstName>", middleName "<middleName>", lastName "<lastName>", emailType "<emailType>", emailId "<emailId>", category "<category>", status "<status>", social_handle_type "<social_handle_type>", social_handle_id "<social_handle_id>", timezone "<timezone>", street "<street>", city "<city>", province "<province>", postal_code "<postal_code>", address_country "<address_country>", phone_type "<phone_type>", number "<number>", phone_country "<phone_country>", birth_day "<birth_day>", birth_month "<birth_month>", birth_year "<birth_year>", callblock "<callblock>", textblock "<textblock>", emailblock "<emailblock>", company "<company>", tagName "<tagName>", supervisor "<supervisor>", assistant "<assistant>", referrer "<referrer>"

    And User click on save button
    Examples:
    |firstName|middleName |lastName |category | status| social_handle_type| social_handle_id    | timezone    |         street       |     city   | province| postal_code | address_country | phone_type|   number  | phone_country |birth_day| birth_month| birth_year |callblock|  textblock|  emailblock|    company     |  tagName | supervisor| assistant| referrer |
    |subhransu|sekhar     |nayak    |contact  |Active | facebook          |subhransu13@gmail.com| Asia/Kolkata| RBI Colony, Nayapalli| Bhubaneswar| Odisha  |   751007    |       India     |   Mobile  | 7978052018|     India     |   17    |  February  |      1991  |   true  |   false   |    false   | Larsen & Toubro|  friend  |   Snigdha |          |          |