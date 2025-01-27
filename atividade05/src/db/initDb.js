// iniciando o banco de dados
const sqlite = require("sqlite3").verbose();
const db = new sqlite.Database("db.sqlite");

// criando a tabela cursos, caso nao exista
db.serialize(() =>{
    db.run(`
        create table if not exists cursos(
            id integer primary key,
            nome text not null,
            carga_horaria text not null    
        )
    `);
});

//exportando o banco de dados
module.exports = db;