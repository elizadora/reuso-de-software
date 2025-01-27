// Importando o express e o arquivo de rotas
const express = require('express');
const router = express.Router();

// Importando o controller de cursos
const cursosController = require('../controllers/cursosController');

// Rotas de cursos
router.get('/', cursosController.listarCursos);
router.get('/:id', cursosController.listarCursoId);
router.post('/', cursosController.criarCurso);
router.put('/:id', cursosController.atualizarCurso);
router.delete('/:id', cursosController.deletarCurso);

// Exportando o router
module.exports = router;