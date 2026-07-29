# SauceDemo QA Automation Suite

End-to-end test automation project for [SauceDemo (Swag Labs)](https://www.saucedemo.com), built with **Katalon Studio**. This project simulates a real-world QA workflow — from test planning and design to execution, debugging, and reporting — covering the complete e-commerce purchase flow.

## Overview

- **40+ test cases** across **8 functional modules**
- Combination of **manual-style scripted test cases** and **data-driven testing**
- **Reusable test architecture** using shared login/checkout keywords
- Dedicated **Smoke Test Suite** and full **Regression Suite Collection**
- Extends beyond UI testing to validate dynamically-generated **PDF file downloads**

## Tech Stack

| Category | Tools |
|---|---|
| Automation Framework | Katalon Studio |
| Scripting Language | Groovy |
| Test Data | Excel (Data-Driven Testing) |
| Version Control | Git / GitHub |
| Planning | Jira (Agile/Scrum simulation) |

## Test Coverage

| Module | Test Cases | Notes |
|---|---|---|
| Login | 10 | Valid/invalid credentials, empty fields, locked-out user, masked password |
| Product Catalog & Sorting | 6 | Sort by name/price, sort behavior after refresh |
| Product Detail Page | 6 | Add/remove cart, data consistency with catalog |
| Cart | 11 | Add/remove, badge count, cross-page persistence |
| Checkout Information | 2 | Data-driven form validation (5+ scenarios from 1 test case) |
| Checkout Overview | 3 | Navigation, order summary, cancel flow |
| Checkout Complete | 4 | Success confirmation, PDF receipt generation & validation |
| Logout | 1 | Session termination |

## Project Structure
SWAGLABS-testingWeb/
├── Test Cases/ # Individual test case scripts, organized by module
├── Test Suites/ # Grouped test suites per module + full regression collection
├── Object Repository/ # Reusable UI element locators
├── Data Files/ # Excel data source for data-driven testing
├── Reports/ # Execution reports (HTML/logs) from test runs
└── Include/ # Config and shared resources
