const db = require('../db/initDb');

// tratamento de erro no banco de dados
const errorDatabase = (res, err) => {
    console.error('Erro no banco de dados:', err.message);
    return res.status(500).send(`Erro ao acessar o banco de dados: ${err.message}`);
};

// listar todos os cursos
const listarCursos = (req, res) => {
    db.all('select * from cursos', function (err, rows) {
        if (err) return errorDatabase(res, err);
        res.json(rows);
    });
};

// listar um curso específico
const listarCursoId = (req, res) => {
    const id = req.params.id;

    db.get('select * from cursos where id = ?', [id], function (err, row) {
        if (err) return errorDatabase(res, err);

        if (row) {
            res.status(200).json(row);
        } else {
            res.status(404).json({ error: 'Curso não encontrado' });
        }
    });
};

// criar um curso
const criarCurso = (req, res) => {
    const { nome, carga_horaria } = req.body;

    if (!nome || !carga_horaria) {
        return res.status(400).send('Todos os campos (nome, area, carga_horaria) são obrigatórios.');
    }

   // inserir um novo curso 
    db.run(
        'insert into cursos (nome, carga_horaria) values (?, ?)',
        [nome, carga_horaria],
        function (err) {
            if (err) return errorDatabase(res, err);

            res.status(201).json({ id: this.lastID, nome, carga_horaria });
        }
    );
};

// atualizar um curso
const atualizarCurso = (req, res) => {
    const id = req.params.id;
    const { nome, carga_horaria } = req.body;

    // verifica se o curso existe
    db.get('select id from cursos where id = ?', [id], function (err, row) {
        if (err) return errorDatabase(res, err);

        if (!row) {
            return res.status(404).json({ error: 'Curso não encontrado' });
        }

        // realiza a atualizacao do curso
        db.run(
            'update cursos set nome = ?, carga_horaria = ? where id = ?',
            [nome, carga_horaria, id],
            function (err) {
                if (err) {
                    console.error('Erro no banco de dados:', err.message);
                    return res.status(500).send(`Erro ao atualizar o curso: ${err.message}`);
                }

                res.status(200).json({ id, nome, carga_horaria });
            }
        );
    });
};

// deletar um curso
const deletarCurso = (req, res) => {
    const id = req.params.id;

    // verifica se o curso existe
    db.get('select id from cursos where id = ?', [id], function (err, row) {
        if (err) return  errorDatabase(res, err);

        if (!row) {
            return res.status(404).json({ error: 'Curso não encontrado' });
        }

        // realiza a exclusao
        db.run('delete from cursos where id = ?', [id], function (err) {
            if (err) {
                console.error('Erro no banco de dados:', err.message);
                return res.status(500).send(`Erro ao deletar o curso: ${err.message}`);
            }

            res.status(204).json({ message: 'Curso deletado com sucesso'});
        });
    });
};

module.exports = {
    listarCursos,
    listarCursoId,
    criarCurso,
    atualizarCurso,
    deletarCurso,
};