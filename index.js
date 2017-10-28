var express = require('express');
var app = express();
var fs = require('fs');
var port = 8888;

app.get('/api/test', function (req, res){
  res.write("Hello");
  return res.end();
});

app.get('/', function (req, res){
  var filename = "./" + "Home.html";
  fs.readFile(filename, function(err, data){
    if (err) {
      res.writeHead(404, {'Content-Type': 'text/html'});
      return res.end("404 BOB Not Found");
    }
    res.writeHead(200, {'Content-Type': 'text/html'});
    res.write(data);
    return res.end();
  });
});

var server = app.listen(port, function () {
  console.log("Example app listening at http://localhost:%s", port)

})
