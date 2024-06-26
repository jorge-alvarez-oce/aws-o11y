const express = require('express');

const PORT = parseInt(process.env.PORT || '8080');
const app = express();

app.use(require('./routes/coupons'));

app.listen(PORT, () => {
  console.log(`Listening for requests on http://localhost:${PORT}`);
});