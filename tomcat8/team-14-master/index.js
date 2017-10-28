const express = require('express');
const app = express();
const fs = require('fs');

const port = 8888;

app.get('/*', (req, res) => {
  res.sendFile(__dirname + req.path);
});

app.listen(port, function () {
  console.log("listening on 8888");
});
