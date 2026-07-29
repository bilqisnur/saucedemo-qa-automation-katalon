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

## How to Run

**Via Katalon Studio GUI:**
1. Open the project in Katalon Studio
2. Navigate to `Test Suites`
3. Right-click a suite (e.g. `TSC_FullRegression`) → `Run`

**Via Command Line:**
```bash
katalonc -noSplash -runMode=console -projectPath="<project-path>" -retry=0 -testSuitePath="Test Suites/TSC_FullRegression" -browserType="Chrome"
```

## Key Techniques & Design Decisions

- **Reusable test case design** — a shared login flow (`TC_Common_ValidLogin`) is called across 20+ dependent test cases via `Call Test Case`, eliminating duplicate setup code and centralizing maintenance.
- **Data-driven testing** — checkout form validation (valid input, empty fields, non-standard formats) is handled by a single parameterized test case bound to an Excel data file, instead of 5 near-duplicate test cases.
- **Redundancy elimination** — test cases with overlapping assertions (e.g. page-navigation checks already covered by a more detailed content-verification test) were identified and removed to keep the suite lean.
- **Requirement-based assertions** — expected results are based on verified application behavior, not assumptions. For example, product sort order is confirmed to reset to default after a page refresh; this is documented as observed behavior, not treated as a bug.
- **Beyond-UI verification** — the PDF receipt download feature is tested by verifying file existence and integrity (non-zero byte size) for a dynamically-timestamped filename, since exact filenames can't be hardcoded.

## Notable Debugging Findings

- Diagnosed and disabled Katalon's **AI Self-Healing** feature after discovering it was silently substituting failed locators with unrelated elements — causing tests to report `PASSED` despite the intended action never occurring. This restored accurate pass/fail reporting across the suite.
- Resolved multiple `WebElementNotFoundException` and `InvalidSelectorException` issues caused by empty or overly-specific XPath locators, replacing them with stable, reusable selectors based on shared HTML classes.
- Fixed test case chaining issues (`BrowserNotOpenedException`) caused by improperly closing the browser inside reusable test cases meant to be called by other test cases.

## Author

**Bilqis Nur Fadhila Iswoyo**
Software Engineering Student — Quality Assurance Focus

- GitHub: [github.com/bilqisnur](https://github.com/bilqisnur)
- LinkedIn: [linkedin.com/in/bilqis-nur-fadhila](http://www.linkedin.com/in/bilqis-nur-fadhila)
- Portfolio: [canva.link/bilqis-porto](https://canva.link/bilqis-porto)
