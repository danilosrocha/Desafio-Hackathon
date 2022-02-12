const neDB = require("../configurations/database");
const api = {};

api.findAll = (request, response) => {
  neDB
    .find({})
    .sort({ name: 1 })
    .exec((exception, cards) => {
      if (exception) {
        const setence = "Unable to LIST";
        console.error(setence, exception);

        response.status(exception.status | 400);
        response.json({ mensagem: setence });
      }
      console.log("Card LISTED Successfully", cards);
      response.json(cards);
    });
};

api.save = (request, response) => {
  const cardData = request.body;
  neDB.insert(cardData, (exception, cards) => {
    if (exception) {
      const setence = "Could not SAVE";
      console.error(setence, exception);

      response.status(exception.status | 400);
      response.json({ mensagem: setence });
    }
    console.log("Card data SAVED successfully", cards);
    response.status(201);
    response.json(cards);
  });
};

api.update = (request, response) => {
  cardData = request.body;
  neDB.update({ _id: request.params.id }, { cardData }, (exception, cards) => {
    if (exception) {
      const setence = "Could not UPDATE";
      console.error(setence, exception);

      response.status(exception.status | 400);
      response.json({ mensagem: setence });
    }
    console.log("Card data UPDATE successfully", cards);
    response.json(cards);
  });
};

api.delete = (request, response) => {
  neDB.remove({ _id: request.params.id }, {}, (exception, cards) => {
    if (exception) {
      const setence = "Could not REMOVE";
      console.error(setence, exception);

      response.status(exception.status | 400);
      response.json({ mensagem: setence });
    }
    console.log("Card data REMOVE successfully", cards);
    response.json(cards);
  });
};

api.findOne = (request, response) => {
  neDB
    .findOne({ _id: request.params.id })
    .sort({ name: 1 })
    .exec((exception, cards) => {
      if (exception) {
        const setence = "Unable to LIST by ID";
        console.error(setence, exception);

        response.status(exception.status | 400);
        response.json({ mensagem: setence });
      }
      console.log("Successfully LISTED by ID", cards);
      response.json(cards);
    });
};

module.exports = api;
