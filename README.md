# SWT Homework Deposit Cash Unit Testing

by Chayathon Khuttiyanon ID: 6110546381

## Set up
### Requirement
- Java version 8 or later
- Maven CLI 3.6

### Installation
```shell script
$ git clone https://github.com/plumest/depositCash.git
$ cd depositCash
```

## Testing
### Test Requirement
1. Can deposit less than or equal to 30,000.00 THB per transaction
2. Can deposit less than or equal to 50,000.00 THB per day
3. Only unsuspended account can be deposit
4. Can deposit only when deposit more than or equal to minimum deposit condition (100.00 THB)

### Run
Go to project's root directory then run following command
```shell script
$ mvn test
```