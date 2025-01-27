// importando o express e o arquivo de rotas
const express = require('express');
const cursosRoutes = require('./routes/cursosRoutes');

// criando a aplicação express
const app = express();
app.use(express.json());

// rota raiz
app.get('/', (req, res) => {
    res.send('API de Cursos funcionando!');
  });
 
// rotas de cursos
app.use('/cursos', cursosRoutes);

// exportando o app
module.exports = app;