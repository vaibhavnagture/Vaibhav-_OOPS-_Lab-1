

const getAllPayeeNames = (expenseItems) => {

  const payeeNames = [];

  expenseItems.forEach( (expenseItem) => {

    const payeeName = expenseItem.payeeName;

    if (!payeeNames.includes(payeeName)){
      payeeNames.push(payeeName);
    }
  })

  return payeeNames;
}

const getGrandTotal = (expenseItems) => {

  let grandTotal = 0;

  expenseItems.forEach( (expenseItem) => {

    grandTotal = grandTotal + expenseItem.price
  })

  return grandTotal;
}


const getTotalExpenseByPayee = (expenseItems, payeeName) => {

  let totalExpense = 0;

  expenseItems.forEach( (expenseItem) => {

    if (expenseItem.payeeName === payeeName){
      totalExpense = totalExpense + expenseItem.price
    }
  })

  return totalExpense;
}

const getPendingAmount = (expenseItems, payeeName) => {

  // 700

  // Rahul - 100
  // Ramesh - 600

  // 700 / 2 -> 350
  // 350 - 100 [250]

  // 700
  const totalExpense = getGrandTotal(expenseItems);
  
  // Rahul - 100
  const totalExpenseByPayee = getTotalExpenseByPayee(
    expenseItems, payeeName);

  // 350
  const halfAmount = (totalExpense / 2);

  if (totalExpenseByPayee >= halfAmount){
    return 0;
  }else{

    return (halfAmount - totalExpenseByPayee)
  }


}

export {getAllPayeeNames, getGrandTotal, getTotalExpenseByPayee, getPendingAmount}