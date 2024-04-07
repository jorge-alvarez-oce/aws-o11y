const express = require('express');
const app = express();

const { DynamoDBClient } = require("@aws-sdk/client-dynamodb");
const { DynamoDBDocumentClient, GetCommand } = require("@aws-sdk/lib-dynamodb");

const client = new DynamoDBClient({});

const docClient = DynamoDBDocumentClient.from(client);

app.post('/coupons/:couponCode/redeem', async (req, res) => {
    var params = {
      TableName: "Coupon",
      Key: {
        code: req.params.couponCode,
      }
    };
    console.info("Redeem coupon");
    try {
      const coupon = (await docClient.send(new GetCommand(params))).Item;
      console.trace('Coupon: ', coupon);
      
      if (coupon?.state === "AVAILABLE") {
        console.debug('Coupon avaiable');
        
        res.send(coupon);
  
      } else {
        console.debug('Coupon unavaiable');

        res.status(412)
          .send("Coupon unavaiable");
      }
    } catch (err) {
      console.error(err);
      res.status(500)
          .send("Unexpected error");
    }
  });

module.exports=app;