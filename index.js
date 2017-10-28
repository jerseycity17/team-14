const express = require('express');
const app = express();
const fs = require('fs');
const api = require('./api.js');
const port = 8888;

app.get('/', (req, res) => {
  res.sendFile(__dirname + "/static/html/index.html");
});

app.post('/quotes', (req, res) => {
  console.log('Hellooooo');
});

app.listen(port, function () {
  console.log("listening on 8888");
});
