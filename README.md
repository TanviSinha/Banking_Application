# Console-Based Banking Application 
This Java console-based banking application allows users to register, log in, open accounts, make transactions, check balances, generate statements, and calculate interest. It’s designed to practice core Java concepts like object-oriented programming, data handling, and exception handling.

Features
1. User Registration & Login
   User Registration: New users can register by creating a unique username and password.
   User Login: Verifies credentials for secure access to accounts.
2. Account Opening
   Open New Account: Registered users can open a new bank account by specifying account type (savings or checking) and an initial deposit.
   Unique Account Number: Each account has a unique identifier.
3. Transaction Processing
   Deposit & Withdrawal: Users can deposit and withdraw money from their account.
   Overdraft Prevention: Withdrawals are validated to prevent overdrafts.
   Transaction Logging: Each transaction is recorded with a unique ID, date, type, and amount.
4. Statement Generation
   Transaction History: Displays a statement of all transactions with details (date, type, amount).
5. Interest Calculation
   Monthly Interest (Savings Accounts): Calculates monthly interest for savings accounts based on a fixed rate and adds it to the balance.
6. Balance Check
   Current Balance: Users can check the balance for any account.

# Project Structure
Java Classes
  Main:Having main() calling BankService
  User: Manages user data and login credentials.
  Account: Manages account information, including balance and transactions.
  Transaction: Logs transactions with ID, date, type, and amount.
  BankService: Contains the main application logic, including the console interface.
Data Management
  In-Memory Storage: User, account, and transaction data are stored in Java collections, ensuring fast access and updates.
Error Handling
  Exception Handling: Catches invalid inputs and overdrafts with informative messages for the user.
