package repository;

// repositorio generico que armazena entidades em memoria, sem persistencia
// implementa a interface CrudRepository

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository<T> implements CrudRepository<T>{

    // mapa que armazena as entidades e um contador para gerar os ids
    private Map<Integer, T> entities = new HashMap<>();
    private int nextId = 1;


    // adiciona uma entidade ao mapa e incrementa o contador
    @Override
    public void save(T entity) {
        int id = (int) getId(entity);
        if(entities.containsKey(id)){
            update(entity);
        }else{
            entities.put(nextId, entity);
            nextId++;
        }
    }

    // remove uma entidade do mapa se ela for igual a entidade passada como parametro
    @Override
    public void delete(T entity) {
        int id = (int) getId(entity);
        if(entities.containsKey(id)){
            entities.remove(id);
        }else{
            System.out.println("Entidade com ID " + id + " não encontrada para remoção.");
        }
    }

    // atualiza uma entidade no mapa se ela existir, a partir do id
    @Override
    public void update(T entity) {
        // verifica se a chave existe
        int id = (int) getId(entity);
        if (entities.containsKey(id)) {
            entities.put(id, entity);

        }else{
            System.out.println("Entidade com ID " + id + " não encontrada para atualização.");
        }

    }

    // busca uma entidade no mapa a partir do id
    @Override
    public T findById(int id) {
        if(entities.containsKey(id)){
            return entities.get(id);
        }
        System.out.println("Entidade com ID " + id + " não encontrada.");
        return null;
    }

    // retorna uma lista com todas as entidades do mapa
    @Override
    public List<T> findAll() {
        return new ArrayList<>(entities.values());
    }


    // metodo privado que acessa o id da entidade usando reflexao
    private Object getId(T entity) {
        try {
            // acessa o metodo getId da entidade e o invoca
            Method getIdMethod = entity.getClass().getMethod("getId");
            return getIdMethod.invoke(entity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao acessar ID da entidade.", e);
        }
    }

}
