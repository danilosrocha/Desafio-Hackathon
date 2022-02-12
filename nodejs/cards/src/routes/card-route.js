const api = require('../controllers/card-controller')

module.exports = (app) => {

    app.route('/card')
        .post(api.save)
        .get(api.findAll)
        
    app.route('/card/:id')
        .get(api.findOne)
        .put(api.update)
        .delete(api.delete)
        
}


