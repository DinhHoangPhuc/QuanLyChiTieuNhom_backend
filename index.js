const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');

const app = express();
const port = 3000;

app.use(bodyParser.json());
app.use(cors());

let transactions = [];

app.post('/income', (req, res) => {
  const income = req.body;
  transactions.push({ ...income, type: 'income' });
  res.status(201).send('Income added');
});

app.post('/expense', (req, res) => {
  const expense = req.body;
  transactions.push({ ...expense, type: 'expense' });
  res.status(201).send('Expense added');
});

app.get('/transactions', (req, res) => {
  res.status(200).json(transactions);
});

app.listen(port, () => {
  console.log(`Server running at http://localhost:${port}`);
});