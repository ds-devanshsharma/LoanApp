Loan App 
This application is using H2 database , it is ready to use i have already added some test data for Customers.
Loan App Functionalities 
- apply loan : Assuming Customer are already in System , they can apply for Loan [ PERSONAL , HOME]
  ![image](https://github.com/user-attachments/assets/d1e731b2-7d1f-4293-a395-0ca29c148b66)

- getLoanInfo :
  ![image](https://github.com/user-attachments/assets/766c5297-a496-4c7e-ac2c-a0eadbc2dc5e)

- getLoanStatus:
  ![image](https://github.com/user-attachments/assets/d6368cf5-e211-4c2f-85c3-547bb02f434a)

- repayLoan : consider payment is done and payment service is hitting webhook api /loan/repay to indicate LoanApp
![image](https://github.com/user-attachments/assets/1ee7de7a-cf82-4483-9684-2f2a4a1f695d)


** Implemented Exception Handler for some of the cases
- like loan doesn't exists and users trying to get loanStatus
![image](https://github.com/user-attachments/assets/56425423-83e9-43bd-af86-7a984cd210ff)
