# ATM Working

A simple Java ATM Management System that uses MySQL to store user accounts, transactions, and balances. This project demonstrates basic account management and transaction handling (deposit, withdrawal, transfer) and is intended as an educational/example application.

## Features

- Create and manage user accounts
- Create and manage bank accounts for users
- Perform deposits, withdrawals, and transfers
- Record transactions with timestamps and descriptions
- Persist data in a MySQL database
- Simple CLI / GUI (replace with actual UI info if applicable)

## Tech stack

- Language: Java
- Database: MySQL
- Persistence: JDBC / ORM (replace with actual used library, e.g., JDBC, JPA/Hibernate)
- Build tool: Maven or Gradle (replace with your build tool)
- Java version: 8+ (adjust if you target a different version)

## Prerequisites

- Java JDK 8 or newer
- MySQL server
- (Optional) Maven or Gradle if the project uses them

## Database setup

1. Create a database for the application:

```sql
CREATE DATABASE atm_db CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

2. Example schema (adjust types and constraints to match your implementation):

```sql
-- Users table
CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(100) NOT NULL UNIQUE,
  password_hash VARCHAR(255) NOT NULL,
  full_name VARCHAR(200),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Accounts table
CREATE TABLE accounts (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT NOT NULL,
  account_number VARCHAR(50) NOT NULL UNIQUE,
  balance DECIMAL(15,2) NOT NULL DEFAULT 0.00,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Transactions table
CREATE TABLE transactions (
  id INT AUTO_INCREMENT PRIMARY KEY,
  account_id INT NOT NULL,
  type ENUM('DEPOSIT','WITHDRAWAL','TRANSFER') NOT NULL,
  amount DECIMAL(15,2) NOT NULL,
  related_account_id INT NULL, -- used for transfers
  description VARCHAR(500),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (account_id) REFERENCES accounts(id) ON DELETE CASCADE
);
```

3. (Optional) Add sample data to test:

```sql
INSERT INTO users (username, password_hash, full_name) VALUES ('testuser', '<hashed-password>', 'Test User');
-- create an account for the user with an initial balance
INSERT INTO accounts (user_id, account_number, balance) VALUES (1, 'ACC1000001', 1000.00);
```

Note: Replace `<hashed-password>` with an actual hash depending on your chosen hashing method (bcrypt recommended).

## Configuration

Provide database connection details in your application's configuration file. Example (application.properties / config.properties):

```
db.url=jdbc:mysql://localhost:3306/atm_db?useSSL=false&serverTimezone=UTC
db.username=atm_user
db.password=your_password
```

Adjust keys and file name to match how your app reads configuration.

## Build & Run

Replace the example commands below with the actual build/run instructions for your project.

Using Maven:
```bash
# from the project root
mvn clean package

# run the generated jar (replace the jar name as appropriate)
java -jar target/atm-working.jar
```

Using Gradle:
```bash
./gradlew build
java -jar build/libs/atm-working.jar
```

Or run from your IDE (import as Maven/Gradle project), set the configuration properties, and run the main class.

## Usage

Typical user flows:
- Register a user or create account entry in DB
- Create a bank account for the user
- Deposit: increase account balance and insert a transaction record
- Withdraw: check sufficient balance, decrease balance, insert transaction record
- Transfer: withdraw from source account, deposit into target account, create transaction records for both sides (or a single transfer record depending on implementation)

Example CLI commands / endpoints (replace with actual commands or API endpoints if your app has them):
- create-user --username testuser --password secret
- create-account --user testuser --initial-balance 1000
- deposit --account ACC1000001 --amount 250
- withdraw --account ACC1000001 --amount 100
- transfer --from ACC1000001 --to ACC1000002 --amount 50

## Tests

If you have unit/integration tests, explain how to run them:

```bash
# Maven
mvn test

# Gradle
./gradlew test
```

## Logging & Error Handling

Document where logs are written and how errors are surfaced to users (console, log files, or UI). Include notes on typical exceptions (connection errors, insufficient funds, invalid account).

## Security

- Store passwords hashed (bcrypt or similar) — do not store plain-text passwords.
- Validate and sanitize any user input.
- Use prepared statements or ORM to prevent SQL injection.
- Use TLS if exposing any network endpoints.

## Contributing

Contributions are welcome. Suggested steps:
1. Fork the repository
2. Create a feature branch: git checkout -b feature/my-feature
3. Make changes and add tests
4. Open a pull request describing your changes

Please follow the project's code style and include tests for new functionality.

## License

Specify your license here (e.g., MIT). If you don't have one yet, consider adding a LICENSE file.

## Contact

For questions or issues, open an issue on GitHub or contact the maintainer: PradeepNG321