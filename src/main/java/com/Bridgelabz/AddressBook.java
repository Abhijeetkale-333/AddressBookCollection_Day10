package com.Bridgelabz;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {
    //Declaring HasMap to store all contact details
    HashMap<String, ContactDetails> contactList = new HashMap<String, ContactDetails>();
    Scanner scanner = new Scanner(System.in);
    public ContactDetails getDetailsFromUser()
    {
        System.out.println("Enter first name : ");
        String fName = scanner.next();
        System.out.println("Enter last name : ");
        String lName = scanner.next();
        System.out.println("Enter email id : ");
        String email = scanner.next();
        System.out.println("Enter phone number : ");
        String phone = scanner.next();
        System.out.println("Enter address : ");
        String address = scanner.next();
        System.out.println("Enter zip code : ");
        int zip = scanner.nextInt();
        System.out.println("Enter city : ");
        String city = scanner.next();
        System.out.println("Enter state : ");
        String state = scanner.next();
        ContactDetails contactDetails = new ContactDetails();
        contactDetails.setfName(fName);
        contactDetails.setlName(lName);
        contactDetails.setEmailId(email);
        contactDetails.setPhoneNumber(phone);
        contactDetails.setAddress(address);
        contactDetails.setZip(zip);
        contactDetails.setCity(city);
        contactDetails.setState(state);
        return contactDetails;
    }
    public void addNewContact() {
        ContactDetails contactDetails = getDetailsFromUser();
        contactList.put(contactDetails.getEmailId(), contactDetails);
    }
    public void updateContactDetail(){
        System.out.println("Enter email id too update : ");
        String email = scanner.next();
        ContactDetails contactDetails = contactList.get(email);
        if(!contactList.containsKey(email))
        {
            System.out.println("Invalid email id");
            updateContactDetail();
        }

        System.out.println("1 : For first name \n" +
                "2 : For Last Name \n" +
                "3 : For phone number \n" +
                "4 : For address \n" +
                "5 : For zip code \n" +
                "6 : For city \n" +
                "7 : For state");
        int selectOption = scanner.nextInt();

        switch (selectOption){
            case 1:
                System.out.println("Enter the first name : ");
                String fName = scanner.next();
                contactDetails.setfName(fName);
                break;
            case 2:
                System.out.println("Enter the last name : ");
                String lName = scanner.next();
                contactDetails.setlName(lName);
                break;
            case 3:System.out.println("Enter phone number : ");
                String phone = scanner.next();
                contactDetails.setPhoneNumber(phone);
                break;
            case 4:
                System.out.println("Enter address : ");
                String address = scanner.next();
                contactDetails.setAddress(address);
                break;
            case 5:
                System.out.println("Enter zip code : ");
                int zipCode = scanner.nextInt();
                contactDetails.setZip(zipCode);
                break;
            case 6:
                System.out.println("Enter City");
                String city = scanner.next();
                contactDetails.setCity(city);
                break;
            case 7:
                System.out.println("Enter state");
                String state = scanner.next();
                contactDetails.setState(state);
                break;
            default:
                System.out.println("please select valid option");
                break;
        }
    }

    public void deleteContact()
    {
        System.out.println("Enter the email id to delete : ");
        String email = scanner.next();
        if (!contactList.containsKey(email))
        {
            System.out.println("Please provide valid email id");
            deleteContact();
        }
        contactList.remove(email);
    }

    //This method is used to print the contact details
    public void printAllDetails() {
        for (ContactDetails allContacts : contactList.values()) {
            System.out.println(allContacts);
        }
    }

    public void searchByCityOrState(){

        System.out.println("Enter city name : ");
        String city = scanner.next();
        System.out.println("Enter state name : ");
        String state = scanner.next();
        System.out.println("Iterate over HashMap Keys and Values");

        for (ContactDetails allDetail : contactList.values()) {
            System.out.println("fetched city" +allDetail.getCity() + "fetched state" + allDetail.getState());
            if(allDetail.getCity().contains(city) || allDetail.getState().contains(state))
            {
                System.out.println("from condition"+allDetail);
            }
            else {
                System.out.println("value not fount");
            }
        }
    }

    public void countByCityOrState(){
        int count=0;
        System.out.println("Enter city name : ");
        String city = scanner.next();
        System.out.println("Enter state name : ");
        String state = scanner.next();
        System.out.println("Iterate over HashMap Keys and Values");

        for (ContactDetails allDetail : contactList.values()) {
            System.out.println("fetched city" +allDetail.getCity() + "fetched state" + allDetail.getState());
            if(allDetail.getCity().contains(city) || allDetail.getState().contains(state))
            {
                count = count +1;
            }
            else {
                System.out.println("value not fount");
            }
        }

        System.out.println("Number of address belong to same city or state are : " +count);
    }

    // This function will be used to ask the user choice
    public void getUserChoice()
    {       boolean isTerminate = false;
        while (!isTerminate){
            System.out.println("1: For add new contact \n" +
                    "2: For update existing contact \n" +
                    "3: For print contact list \n" +
                    "4: For delete contact \n" +
                    "5: For search by city name or state : \n" +
                    "6: For count number of address belong to same city or state \n" +
                    "0: For terminate the program");
            int selectedOption = scanner.nextInt();
            switch (selectedOption){
                case 1:
                    addNewContact();
                    break;
                case 2:updateContactDetail();
                    break;
                case 3:
                    printAllDetails();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    searchByCityOrState();
                    break;
                case 6:
                    countByCityOrState();
                    break;
                case 0:
                    isTerminate = true;
                    break;
                default:
                    System.out.println("Please select valid option");
                    break;
            }
        }
    }

}
