
import {useEffect} from "react"

import {getAllExpenseItems} from "../services/expense"
import { ExpenseItemsLister } from "./ExpenseItemsLister"

import {useState} from "react";

import {Container} from "react-bootstrap"
import { ExpenseCreator } from "./ExpenseCreator";
import { ExpenseSummary } from "./ExpenseSummary";

const ExpenseTrackerApp = () => {

  const [expenseItems, setExpenseItems] = useState([]);

  useEffect( () => {

      const getAllExpenseItemsInvoker = async () => {

        const response = await getAllExpenseItems();
        console.log("Expense Items");
        console.log(JSON.stringify(response))

        setExpenseItems(response);
      }

      getAllExpenseItemsInvoker();

  }, [])

  // Write down the useEffect hook
  // Write a new method within the useEffect
  // Within the new method impl, call the service method
  // Print the results

  return (
    <Container>

      <h2>Expense Items</h2>

      <ExpenseCreator expenseItems={expenseItems} ></ExpenseCreator>

      <hr/>

      <ExpenseItemsLister expenseItems={expenseItems}></ExpenseItemsLister>

      <ExpenseSummary expenseItems={expenseItems}></ExpenseSummary>

    </Container>
  )
}

export {ExpenseTrackerApp}