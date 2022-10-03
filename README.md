# Banking_Design
# From the BankingServiceApplication.java will  read the input from the text file present in the resources package of the project
# From the BankingServiceApplication call the orchestrator service which will trim the input by spaces and get seperate strings/words
# Then the orchestrator Service will call the LoanOperationAction here , according to the different action ie the first word in the input string weather it is balance
,payment and loan will call services for balance/payment/Loan which will have the bussiness logic to get the desrired output
# In the  LoanOperationActionImpl.java at the end we are printing the output for term Balance
# We have three models Loan, Payment,Balance made according to the feilds provided in the sample input
# In the constant package declared the constatans used in the project
