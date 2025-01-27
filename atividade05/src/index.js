// importando o arquivo app.js
const app = require('./app');

// iniciando o servidor na porta 3000
app.listen(3000, () => {
    console.log('Server is running on port 3000');
});
